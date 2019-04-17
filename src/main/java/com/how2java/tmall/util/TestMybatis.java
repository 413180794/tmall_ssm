package com.how2java.tmall.util;

import com.how2java.tmall.mapper.CategoryMapper;

import com.how2java.tmall.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        deleteOrder(session);
//        deleteOrderItem(session);
//        addOrderItem(session);
//        listOrder(session);
//        testAddCategory(session);
        testDeleteCategory(session);
        testGetAllCategory(session);



        session.commit();
        session.close();
//        List<Category> cs = session.selectList("listCategory");
//

    }

    private static void testDeleteCategory(SqlSession session){
        // 删除第二条分类
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        mapper.deleteCategory(2);
    }
    private static void testAddCategory(SqlSession session){
        // 向数据库中添加一些分类
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        String[] categoryNameList = {"食品","化妆品","计算机","书籍","男性用品"};
        for (String categoryName :categoryNameList){
            Category category = new Category();
            category.setName(categoryName);
            mapper.addCategory(category);
        }
    }
    private static void testGetAllCategory(SqlSession session){
        //打印数据库中所有的分类的id和名字
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        List<Category> categories = mapper.getAllCategory();
        for (Category category:categories){
            System.out.format("id:%d,name:%s",category.getId(),category.getName());
        }
    }
    private static void testUpdateCategory(SqlSession session){
        //更新数据库中第二条数据的内容
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        Category newCategory = new Category();
        newCategory.setId(2);
        newCategory.setName("爆炸用品");
        mapper.updateCategory(newCategory);
    }
//    private static void update(CategoryMapper mapper){
//        Category c= mapper.get(1);
//        c.setName("修改了的Category名称");
//        mapper.update(c);
//        listAll(mapper);
//    }
//    private static void get(CategoryMapper mapper){
//        Category c = mapper.get(1);
//        System.out.println(c.getName());
//    }
//    private static void delete(CategoryMapper mapper){
//        mapper.delete(2);
//        listAll(mapper);
//    }
//    private static void add(CategoryMapper mapper){
//        Category c = new Category();
//        c.setName("新增加的Category");
//        mapper.add(c);
//        listAll(mapper);
//    }
//    private static void listOrder(SqlSession sqlSession){
//        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
//        List<Order> os = orderMapper.list();
//
//        for (Order o:os){
//            System.out.println(o.getCode());
//            List<OrderItem> orderItems = o.getOrderItems();
//            if (null!=orderItems){
//                for (OrderItem oi:orderItems){
//                    System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
//                }
//            }
//        }
//    }
//    private static void listAll(CategoryMapper mapper){
//        List<Category> cs = mapper.list();
//        for(Category c : cs){
//            System.out.println(c.getName());
//            List<Product> ps = c.getProducts();
//            for (Product p : ps){
//                System.out.println("\t"+p.getName());
//            }
//        }
//    }
}
