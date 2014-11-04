package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.DiscountPromotion;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import com.thoughtworks.iamcoach.pos.service.PromotionFactory;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionFactoryTest {

    @Test
    public void should_return_discountPromotion_when_input_2(){

        Promotion promotion = PromotionFactory.getInstance(2);

        assertThat(promotion instanceof DiscountPromotion).isEqualTo(true);

    }
}
