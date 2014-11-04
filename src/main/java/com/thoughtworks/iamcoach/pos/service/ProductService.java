package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sukai on 11/4/14.
 */
public interface ProductService {
    List<Product> getProductList() throws SQLException;
}
