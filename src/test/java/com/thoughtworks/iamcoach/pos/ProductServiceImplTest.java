package com.thoughtworks.iamcoach.pos;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.iamcoach.pos.dao.ProductDaoImpl;
import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.service.CategoryServiceImpl;
import com.thoughtworks.iamcoach.pos.service.ProductService;
import com.thoughtworks.iamcoach.pos.service.ProductServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    public static ProductService productService;

    @BeforeClass
    public static void beforeClass() throws SQLException {

        ProductDaoImpl productDao = mock(ProductDaoImpl.class);

        ImmutableList<Product> products = ImmutableList.of(
                new Product(1, "ITEM000000", "可乐", "瓶", 3, new Category(1,"饮料"), null),
                new Product(2, "ITEM000001", "雪碧", "瓶", 3.5, new Category(1,"饮料"), null),
                new Product(3, "ITEM000002", "苹果", "斤", 4.5, new Category(2,"水果"), null));

        when(productDao.getProductList()).thenReturn(products);

        CategoryServiceImpl categoryService = mock(CategoryServiceImpl.class);

        when(categoryService.getCategory(1)).thenReturn(new Category(1,"饮料"));
        productService = new ProductServiceImpl(productDao,categoryService);
    }

    @Test
    public void should_return_a_product_list() throws Exception {

        List<Product> productList = productService.getProductList();

        assertThat(productList.size()).isEqualTo(3);
        assertThat(productList.get(0).getCategory().getName()).isEqualTo("饮料");
        assertThat(productList.get(0).getName()).isEqualTo("可乐");
    }
}
