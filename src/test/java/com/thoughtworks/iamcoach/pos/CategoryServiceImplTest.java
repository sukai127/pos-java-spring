package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.service.CategoryService;
import com.thoughtworks.iamcoach.pos.service.CategoryServiceImpl;
import org.junit.Test;

import java.sql.SQLException;

import static org.fest.assertions.api.Assertions.assertThat;

public class CategoryServiceImplTest {
    @Test
    public void should_return_category_when_input_productId() throws SQLException {
        
        CategoryService categryService = new CategoryServiceImpl();
        Category category = categryService.getCategory(1);

        assertThat(category.getName()).isEqualTo("饮料");
    }
}
