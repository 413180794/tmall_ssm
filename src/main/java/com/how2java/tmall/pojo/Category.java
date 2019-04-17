package com.how2java.tmall.pojo;

import java.util.List;

public class Category {
    // 分类有  分类名称 id（主键） 对应的图片
    // 一个分类会对应多个属性
    // 一个分类会对应多个产品
    private int id;
    private String name;
    private List<Product> productList;
    private List<Property> propertyList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }
}
