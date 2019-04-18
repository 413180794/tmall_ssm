package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductMapper productMapper;


    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productMapper.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public Product getProduct(int id) {
        return productMapper.getProduct(id);
    }

    @Override
    public List<Product> getProductList(int cid) {
        return productMapper.getProductList(cid);
    }

    @Override
    public List<Product> getProductListOnePage(Map paramMap) {
        return productMapper.getProductListOnePage(paramMap);
    }

    @Override
    public int total(int cid) {
        return productMapper.total(cid);
    }


}
