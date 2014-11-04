package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao extends DbUtils{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Category getCategory(int productId) throws SQLException {

        String sql = "select * from category c,product p where p.category_id = c.id and p.id=?";

        connection = getConnection();
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,productId);
        resultSet = preparedStatement.executeQuery();

        resultSet.next();
        Category category = new Category(resultSet.getInt("id"),resultSet.getString("name"));
        return category;
    }
}
