package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.util.Page;

import java.util.List;
import java.util.Map;

public interface PropertyMapper {
    List<Property> getAllProperty(); // 拿到数据库中所有的属性
    List<Property> getPropertyListByCategoryId(int cid); // 拿到一个分类的所有属性
    List<Property> getPropertyListByCategoryIdOnePage(Map paramMap);
    int total(int cid);
    void addProperty(Property property);
    Property getPropertyById(int id);
    void updateProperty(Property property);
    void deleteProperty(int id);
}
