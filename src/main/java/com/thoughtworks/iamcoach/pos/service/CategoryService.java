package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.Category;

import java.sql.SQLException;

/**
 * Created by sukai on 11/4/14.
 */
public interface CategoryService {
    Category getCategory(int id) throws SQLException;
}
