package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ProductDao;
import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;
    private CategoryService categoryService;
    private PromotionService promotionService;

    public ProductServiceImpl(ProductDao productDao,CategoryService categoryService,PromotionService promotionService) {
        this.productDao = productDao;
        this.categoryService = categoryService;
        this.promotionService = promotionService;
    }

    public ProductServiceImpl(){

    }

    @Override
    public List<Product> getProductList() throws SQLException {

        List<Product> productList = productDao.getProductList();

        for(Product product : productList){

            Category category = categoryService.getCategory(product.getId());
            List<Promotion> promotions = promotionService.getPromotionList(product.getId());

            product.setCategory(category);
            product.setPromotions(promotions);
        }

        return productList;
    }

}
