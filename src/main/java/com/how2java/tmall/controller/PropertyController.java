package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
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
public class PropertyController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;

    @RequestMapping("admin_property_list")
    public String list(int cid, Model model, Page page){
        Category c = categoryService.getOneCategoryById(cid);
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("cid",cid);
        paramMap.put("start",page.getStart());
        paramMap.put("count",page.getCount());
        List<Property> properties = propertyService.getPropertyListByCategoryIdOnePage(paramMap);
        int total = propertyService.total(cid);
        page.setTotal(total);
        page.setParam("&cid="+c.getId());
        model.addAttribute("ps",properties);
        model.addAttribute("c",c);
        model.addAttribute("page",page);
        return "admin/listProperty";
    }
    @RequestMapping("admin_property_add")
    public String addProperty(Property property){
        propertyService.addProperty(property);
        return "redirect:admin_property_list?cid="+property.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String editProperty(int id,Model model){
        Property property = propertyService.getPropertyById(id);
        Category category = categoryService.getOneCategoryById(property.getCid());
        property.setCategory(category);
        model.addAttribute("p",property);
        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String updateProperty(Property p) {
        propertyService.updateProperty(p);
        return "redirect:/admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String deleteProperty(int id){
        Property property = propertyService.getPropertyById(id);
        propertyService.deleteProperty(id);
        return "redirect:/admin_property_list?cid="+property.getCid();
    }


}
