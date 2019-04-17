package com.how2java.tmall.pojo;

public class Property {
    // 表示该分类下有属性 一个分类可以有多个属性   Category->PropertyMapper 一对多

    private int id; // 主键id
    private int cid; // 外键 cid 对应的是Category的主键
    private String name; // 属性名 注意这个表只有属性名而没有属性名值，
    //因为一个属性名 可能有多个属性值， 所以属性名与属性值是一对多的关系

    private Category category;

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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
