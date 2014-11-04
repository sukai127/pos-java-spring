package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.model.SecondHalfPricePromotion;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SecondHalfPricePromotionTest {
    @Test
    public void should_return_12_when_input_cartItem(){
        Product product = new Product(1,"ITEM000000","可乐","瓶",3.00,null,null);
        CartItem cartItem = new CartItem(product,5);
        SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion();

        double money = secondHalfPricePromotion.getMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }
}
