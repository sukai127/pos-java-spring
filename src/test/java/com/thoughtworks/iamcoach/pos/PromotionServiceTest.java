package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.service.PromotionService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionServiceTest {
    @Test
    public void should_return_12_when_input_cartItem(){

        List<Promotion> list = new ArrayList<Promotion>();
        list.add(new BuyTwoGetOnePromotion());
        list.add(new SecondHalfPricePromotion());
        list.add(new DiscountPromotion());

        Product product = new Product(1,"ITEM000001","可乐","瓶",3.00,null,list);
        CartItem cartItem = new CartItem(product,6);
        PromotionService promotionService = new PromotionService();

        double money = promotionService.calculateMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }

    @Test
    public void should_return_75_when_input_productId() throws Exception{

        PromotionService promotionService = new PromotionService();

        int result = promotionService.getDiscount(2);

        assertThat(result).isEqualTo(75);
    }

    @Test
    public void should_return_promotionList_when_input_productId() throws SQLException {
        PromotionService promotionService = new PromotionService();

        List<Promotion> promotions = promotionService.getPromotionList(2);

        assertThat(promotions.size()).isEqualTo(3);
    }
}
