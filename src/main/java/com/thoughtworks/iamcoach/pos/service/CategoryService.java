package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.model.Category;

import java.sql.SQLException;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public Category getCategory(int id) throws SQLException {
        return categoryDao.getCategory(id);
    }
}
