package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.util.Page;

import java.util.List;
import java.util.Map;

public interface PropertyService {
    List<Property> getAllProperty(); // 拿到数据库中所有的属性
    List<Property> getPropertyListByCategoryId(int cid); // 拿到一个分类的所有属性
    List<Property> getPropertyListByCategoryIdOnePage(Map paramMap);
    Property getPropertyById(int id);
    int total(int cid);
    void addProperty(Property property);
    void updateProperty(Property property);
    void deleteProperty(int id);
}
