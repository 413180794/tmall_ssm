package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CategoryServiceImpl implements CategoryService{


    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public Category getOneCategoryById(int id) {
        return categoryMapper.getOneCategoryById(id);
    }

    @Override
    public List<Category> getOnePageCategory(Page page) {
        return categoryMapper.getOnePageCategory(page);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryMapper.deleteCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }
    @Override
    public int total(){
        return categoryMapper.total();
    }
}