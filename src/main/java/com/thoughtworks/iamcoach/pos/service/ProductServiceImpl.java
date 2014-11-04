package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ProductDaoImpl;
import com.thoughtworks.iamcoach.pos.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl {

    private ProductDaoImpl productDaoImpl = new ProductDaoImpl();
    private CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
    private PromotionService promotionService = new PromotionService();

    public List<Product> getProductList() throws SQLException {

        List<Product> productList = productDaoImpl.getProductList();

        for(Product product : productList){
            product.setCategory(categoryServiceImpl.getCategory(product.getId()));
            product.setPromotions(promotionService.getPromotionList(product.getId()));
        }

        return productList;
    }

}
