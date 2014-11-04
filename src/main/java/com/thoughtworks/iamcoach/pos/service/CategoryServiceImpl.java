package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.dao.CategoryDaoImpl;
import com.thoughtworks.iamcoach.pos.model.Category;

import java.sql.SQLException;

public class CategoryServiceImpl {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    public Category getCategory(int id) throws SQLException {
        return categoryDao.getCategory(id);
    }
}
