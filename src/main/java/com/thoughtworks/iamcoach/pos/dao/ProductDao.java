package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Product;

import java.sql.*;
import java.util.*;

public class ProductDao extends DbUtils{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public List<Product> getProductList() throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from product";
        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Product product = new Product(resultSet.getInt("id"),resultSet.getString("barcode"),
                    resultSet.getString("name"),resultSet.getString("unit"),
                    resultSet.getDouble("price"),null,null);
            productList.add(product);
        }
        return productList;
    }
}
