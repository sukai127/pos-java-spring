package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.DiscountPromotion;
import com.thoughtworks.iamcoach.pos.model.Product;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DiscountPromotionTest {
    @Test
    public void should_return_12_when_input_cartItem(){
        Product product = new Product(2,"ITEM000001","可乐","瓶",4.00,null,null);
        CartItem cartItem = new CartItem(product,4);
        DiscountPromotion discountPromotion = new DiscountPromotion();

        double money = discountPromotion.getMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }
}
