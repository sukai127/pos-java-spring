package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.dao.ProductDaoImpl;
import com.thoughtworks.iamcoach.pos.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl {

    private ProductDao productDao = new ProductDaoImpl();
    private CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
    private PromotionServiceImpl promotionServiceImpl = new PromotionServiceImpl();

    public List<Product> getProductList() throws SQLException {

        List<Product> productList = productDao.getProductList();

        for(Product product : productList){
            product.setCategory(categoryServiceImpl.getCategory(product.getId()));
            product.setPromotions(promotionServiceImpl.getPromotionList(product.getId()));
        }

        return productList;
    }

}
