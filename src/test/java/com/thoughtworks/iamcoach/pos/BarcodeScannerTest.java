package com.thoughtworks.iamcoach.pos;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.iamcoach.pos.dao.ProductDaoImpl;
import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.service.ProductService;
import com.thoughtworks.iamcoach.pos.service.ProductServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.*;
import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BarcodeScannerTest {

    private static BarcodeScanner barcodeScanner;

    @BeforeClass
    public static void beforeClass() throws SQLException {

        ProductServiceImpl productService = mock(ProductServiceImpl.class);

        ImmutableList<Product> products = ImmutableList.of(
                new Product(1, "ITEM000000", "可乐", "瓶", 3, new Category(1,"饮料"), null),
                new Product(2, "ITEM000001", "雪碧", "瓶", 3.5, new Category(1,"饮料"), null),
                new Product(3, "ITEM000002", "苹果", "斤", 4.5, new Category(2,"水果"), null));

        when(productService.getProductList()).thenReturn(products);
        barcodeScanner = new BarcodeScanner(productService);
    }

    @Test
    public void should_get_a_product_when_input_an_barcode() throws Exception {

        String barcode = "ITEM000001";
        Product product = barcodeScanner.getProduct(barcode);

        assertThat(product.getName()).isEqualTo("雪碧");
        assertThat(product.getCategory().getName()).isEqualTo("饮料");
    }

    @Test
    public void should_get_cartItem_list() throws Exception {

        List<String> list = new ArrayList<String>();

        list.add("ITEM000001");
        list.add("ITEM000001");
        list.add("ITEM000003-2.5");
        list.add("ITEM000005");

        List<CartItem> cartItemList = barcodeScanner.scan(list);

        assertThat(cartItemList.size()).isEqualTo(3);
        assertThat(cartItemList.get(0).getCount()).isEqualTo(2);
        assertThat(cartItemList.get(0).getProduct().getName()).isEqualTo("雪碧");
    }
}
