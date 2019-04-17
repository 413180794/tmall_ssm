package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    List<Category> getAllCategory(); // 查询所有的Category数据
    Category getOneCategoryById(int id); // 根据id查询Category数据
    List<Category> getOnePageCategory(Page page); // 根据页数来查数据
    void addCategory(Category category); // 增加一个分类 增
    void deleteCategory(int id); // 删除一个分类 删
    void updateCategory(Category category); // 改
    int total(); // 获取全部的总数

}
