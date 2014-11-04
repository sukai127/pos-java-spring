package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;

import java.sql.SQLException;

/**
 * Created by sukai on 11/4/14.
 */
public interface CategoryDao {
    Category getCategory(int productId) throws SQLException;
}
