package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.BuyTwoGetOnePromotion;
import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.Product;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BuyTwoGetOnePromotionTest {

    @Test
    public void should_return_12_when_input_cartItem(){

        Product product = new Product(1,"ITEM000000","可乐","瓶",3.00,null,null);
        CartItem cartItem = new CartItem(product,5);
        BuyTwoGetOnePromotion buyTwoGetOnePromotion = new BuyTwoGetOnePromotion();

        double money = buyTwoGetOnePromotion.getMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }
}
