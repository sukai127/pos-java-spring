package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.Product;
import org.junit.Test;

import java.util.*;
import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class BarcodeScannerTest {

    @Test
    public void should_get_a_product_when_input_an_barcode() throws Exception {

        BarcodeScanner barcodeScanner = new BarcodeScanner();
        String barcode = "ITEM000001";
        Product product = barcodeScanner.getProduct(barcode);

        assertThat(product.getName()).isEqualTo("雪碧");
        assertEquals(product.getName(),"雪碧");
    }

    @Test
    public void should_get_cartItem_list() throws Exception {

        BarcodeScanner barcodeScanner = new BarcodeScanner();
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
