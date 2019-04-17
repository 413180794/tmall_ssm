package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.PropertyMapper;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyMapper propertyMapper;
    @Override
    public List<Property> getAllProperty() {
        return propertyMapper.getAllProperty();
    }

    @Override
    public List<Property> getPropertyListByCategoryId(int cid) {
        return propertyMapper.getPropertyListByCategoryId(cid);
    }

    @Override
    public List<Property> getPropertyListByCategoryIdOnePage(Map paramMap) {
        return propertyMapper.getPropertyListByCategoryIdOnePage(paramMap);
    }

    @Override
    public Property getPropertyById(int id) {
        return propertyMapper.getPropertyById(id);
    }

    @Override
    public int total(int cid) {
        return propertyMapper.total(cid);
    }

    @Override
    public void addProperty(Property property) {
        propertyMapper.addProperty(property);
    }

    @Override
    public void updateProperty(Property property) {
        propertyMapper.updateProperty(property);
    }

    @Override
    public void deleteProperty(int id) {
        propertyMapper.deleteProperty(id);
    }
}
