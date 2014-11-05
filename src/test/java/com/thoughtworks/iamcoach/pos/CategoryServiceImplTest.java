package com.thoughtworks.iamcoach.pos;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.service.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {

    public static CategoryService categoryService;

    @BeforeClass
    public static void beforeClass() throws SQLException {

        CategoryDao categoryDao = mock(CategoryDao.class);

        ImmutableList<Category> categories = ImmutableList.of(new Category(1,"饮料"),
                new Category(2,"电器"), new Category(2,"水果"));

        when(categoryDao.getCategory(1)).thenReturn(categories.get(0));
        categoryService = new CategoryServiceImpl(categoryDao);
    }

    @Test
    public void should_return_category_when_input_productId() throws SQLException {

        Category category = categoryService.getCategory(1);

        assertThat(category.getName()).isEqualTo("饮料");
    }
}
