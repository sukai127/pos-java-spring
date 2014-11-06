package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.DiscountPromotion;
import com.thoughtworks.iamcoach.pos.model.Product;
import com.thoughtworks.iamcoach.pos.service.ProductService;
import com.thoughtworks.iamcoach.pos.service.PromotionService;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountPromotionTest {

    private DiscountPromotion discountPromotion;
    @Before
    public void init() throws Exception{
        PromotionService promotionService = mock(PromotionService.class);
        when(promotionService.getDiscount(2)).thenReturn(75);

        discountPromotion = new DiscountPromotion(promotionService);
    }
    @Test
    public void should_return_12_when_input_cartItem(){
        Product product = new Product(2,"ITEM000001","可乐","瓶",4.00,null,null);
        CartItem cartItem = new CartItem(product,4);

        double money = discountPromotion.getMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }
}
