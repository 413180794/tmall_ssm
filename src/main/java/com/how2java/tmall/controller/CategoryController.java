package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;

import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;

import com.how2java.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller // 声明当前类是一个控制器
@RequestMapping("") // 表示访问的时候无需额外的地址
public class CategoryController{
    @Autowired // 把CategoryServiceImpl自动装配进了CategoryService接口
    CategoryService categoryService;

    @RequestMapping("admin_category_list") // 映射admin_category_list路径的访问
    public String list(Model model,Page page){
            // 在list方法中，通过categoryService.list()获取所有的Category对象，然后放在"cs"中，并服务端跳转到"admin/listCategory"视图
            // “admin/listCategory”会根据后续的springMVC.xml配置文件，跳转到WEB-INF/jsp/admin/listCategory.jsp文件
            List<Category> cs = categoryService.getOnePageCategory(page);
            int total = categoryService.total();
            page.setTotal(total);
            model.addAttribute("cs",cs);
            model.addAttribute("page",page);
            return "admin/listCategory";
    }

    /**
     *  add方法映射路径admin_category_add的访问
     * @param c 接收页面提交的分类名称
     * @param session 当用户第一次访问这个Servlet时，服务器端会给用户创建一个独立的Session，并且声称一个SessionID，这个SessionID
     *                在响应浏览器的时候会被装进cookie中，从而保存在浏览器中，当用户再一次访问Servlet时，请求中会携带cookie中的
     *                SessionID去访问服务器会根据这个SessionID去查看是否有对应的Session对象，有就拿出来使用，没有就创建一个Session，
     *                相当于用户第一次访问
     * @param uploadedImageFile
     * @return
     * @throws IOException
     */
    @RequestMapping("admin_category_add")
    public String add(Category c, UploadedImageFile uploadedImageFile , HttpSession session) throws IOException{
        categoryService.addCategory(c); // 向数据库中增加一个分类
        //接下来在本地服务器添加这个分类的图片
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img,"jpg",file);
        return  "redirect:/admin_category_list";
    }
//
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException{
        categoryService.deleteCategory(id);// 删除数据库中的记录
        //删除本地文件夹中对应的文件
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException{
        // 尝试修改分类的属性，这里在修改的时候，把原来分类的名字传入到界面中
        Category c = categoryService.getOneCategoryById(id);
        model.addAttribute("c",c);
        return "admin/editCategory";
    }

    @RequestMapping("admin_category_update")
    public String update(Category c,HttpSession session,UploadedImageFile uploadedImageFile) throws IOException{
        // 更新
        categoryService.updateCategory(c);
        MultipartFile image = uploadedImageFile.getImage();
        if (null!=image && !image.isEmpty()){
            System.out.println("修改图片");
            File imageFloder = new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFloder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img,"jpg",file);
        }
        return "redirect:/admin_category_list";
    }
}