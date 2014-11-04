package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.CategoryDaoImpl;
import com.thoughtworks.iamcoach.pos.model.Category;

import java.sql.SQLException;

public class CategoryService {

    private CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();

    public Category getCategory(int id) throws SQLException {
        return categoryDaoImpl.getCategory(id);
    }
}
