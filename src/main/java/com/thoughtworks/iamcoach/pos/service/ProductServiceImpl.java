package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.dao.ProductDaoImpl;
import com.thoughtworks.iamcoach.pos.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;
    private CategoryService categoryService = new CategoryServiceImpl();
    private PromotionService promotionService = new PromotionServiceImpl();

    public ProductServiceImpl(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    public ProductServiceImpl(){

    }

    @Override
    public List<Product> getProductList() throws SQLException {

        List<Product> productList = productDao.getProductList();

        for(Product product : productList){
            product.setCategory(categoryService.getCategory(product.getId()));
            product.setPromotions(promotionService.getPromotionList(product.getId()));
        }

        return productList;
    }

}
