package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.service.ProductServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ProductServiceImplTest {

    public static ProductServiceImpl productServiceImpl;

    @BeforeClass
    public static void beforeClass(){
        productServiceImpl = new ProductServiceImpl();
    }

    @Test
    public void should_return_a_product_list() throws Exception {

        List<Product> productList = productServiceImpl.getProductList();

        assertThat(productList.size()).isEqualTo(6);
        assertThat(productList.get(0).getCategory().getName()).isEqualTo("饮料");
        assertThat(productList.get(0).getName()).isEqualTo("可乐");
        assertThat(productList.get(1).getPromotions().size()).isEqualTo(3);
    }
}
