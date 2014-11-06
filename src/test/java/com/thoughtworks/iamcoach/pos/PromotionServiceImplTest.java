package com.thoughtworks.iamcoach.pos;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.iamcoach.pos.dao.PromotionDao;
import com.thoughtworks.iamcoach.pos.dao.PromotionDaoImpl;
import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.service.PromotionService;
import com.thoughtworks.iamcoach.pos.service.PromotionServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PromotionServiceImplTest {

    private PromotionService promotionService;
    @Before
    public void init() throws Exception {

        PromotionDao promotionDao = mock(PromotionDaoImpl.class);
        ImmutableList<Integer> types = ImmutableList.of(0,1,2);

        when(promotionDao.getPromotionTypes(2)).thenReturn(types);
        when(promotionDao.getDiscount(2)).thenReturn(75);

        promotionService = new PromotionServiceImpl(promotionDao);
    }

    @Test
    public void should_return_12_when_input_cartItem(){

        List<Promotion> list = new ArrayList<Promotion>();
        list.add(new BuyTwoGetOnePromotion());
        list.add(new SecondHalfPricePromotion());
        list.add(new DiscountPromotion());

        Product product = new Product(1,"ITEM000001","可乐","瓶",3.00,null,list);
        CartItem cartItem = new CartItem(product,6);
        PromotionService promotionService = new PromotionServiceImpl();

        double money = promotionService.calculateMoney(cartItem);

        assertThat(money).isEqualTo(12);
    }

    @Test
    public void should_return_75_when_input_productId() throws Exception{

        int result = promotionService.getDiscount(2);

        assertThat(result).isEqualTo(75);
    }

    @Test
    public void should_return_promotionList_when_input_productId() throws SQLException {

        List<Promotion> promotions = promotionService.getPromotionList(2);

        assertThat(promotions.size()).isEqualTo(3);
    }
}
