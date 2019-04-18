package com.how2java.tmall.controller;


import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_product_list")
    public String list(int cid, Model model, Page page){
        Category c = categoryService.getOneCategoryById(cid);
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("cid",cid);
        paramMap.put("start",page.getStart());
        paramMap.put("count",page.getCount());
        List<Product> products =productService.getProductListOnePage(paramMap);
        int total = productService.total(cid);
        page.setTotal(total);
        page.setParam("&cid="+c.getId());
        model.addAttribute("ps",products);
        model.addAttribute("c",c);
        model.addAttribute("page",page);
        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String addProduct(Product product){
        productService.addProduct(product);
        return "redirect:admin_product_list?cid="+product.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String deleteProduct(int id){
        Product product = productService.getProduct(id);
        productService.deleteProduct(id);
        return "redirect:admin_product_list?cid="+product.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String editProduct(int id,Model model){
        Product product = productService.getProduct(id);
        Category category = categoryService.getOneCategoryById(product.getCid());
        product.setCategory(category);
        model.addAttribute("p",product);
        return "admin/editProduct";
    }


}
