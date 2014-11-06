package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.*;

public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate ;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getProductList() throws SQLException {
        List<Product> productList;
        String sql = "select * from product";

        productList = jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product(resultSet.getInt("id"),resultSet.getString("barcode"),
                    resultSet.getString("name"),resultSet.getString("unit"),
                    resultSet.getDouble("price"),null,null);
                return product;
            }
        });
        return productList;
    }
}
