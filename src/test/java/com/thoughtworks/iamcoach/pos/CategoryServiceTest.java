package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.service.CategoryService;
import org.junit.Test;

import java.sql.SQLException;

import static org.fest.assertions.api.Assertions.assertThat;

public class CategoryServiceTest {
    @Test
    public void should_return_category_when_input_productId() throws SQLException {
        
        CategoryService categryService = new CategoryService();
        Category category = categryService.getCategory(1);

        assertThat(category.getName()).isEqualTo("饮料");
    }
}
