package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate jdbcTemplate ;

    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CategoryDaoImpl() {
    }

    @Override
    public Category getCategory(int productId) throws SQLException {

        String sql = "select c.* from category c,product p where p.category_id = c.id and p.id=?";

        Category category = jdbcTemplate.query(sql,new Object[]{productId},new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Category(resultSet.getInt("id"), resultSet.getString("name"));
            }
        }).get(0);

        return category;
    }
}
