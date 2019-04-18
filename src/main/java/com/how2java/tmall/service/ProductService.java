package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.util.Page;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void addProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    Product getProduct(int id); // 根据产品的id查询
    List<Product> getProductList(int cid); // 根据category查询该分类的所有产品
    List<Product> getProductListOnePage(Map paramMap); // 根据cid查询该分类的一页数据
    int total(int cid);
}
