package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.*;

public class PromotionFactory {

    public static final int BUY_TWO_GET_ONE = 0;
    public static final int SECOND_HALF_PRICE = 1;
    public static final int DISCOUNT = 2;

    public static Promotion getInstance(int type){
        Promotion promotion = null;
        switch (type) {
            case PromotionFactory.BUY_TWO_GET_ONE:
                promotion = new BuyTwoGetOnePromotion();
                break;
            case PromotionFactory.SECOND_HALF_PRICE:
                promotion = new SecondHalfPricePromotion();
                break;
            case PromotionFactory.DISCOUNT:
                promotion = new DiscountPromotion();
                break;
            default:
                break;
        }

        return promotion;
    }
}
