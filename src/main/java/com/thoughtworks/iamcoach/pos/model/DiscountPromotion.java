package com.thoughtworks.iamcoach.pos.model;

import com.thoughtworks.iamcoach.pos.service.PromotionService;
import com.thoughtworks.iamcoach.pos.service.PromotionServiceImpl;

public class DiscountPromotion extends Promotion{

    private PromotionService promotionService;

    public DiscountPromotion(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public DiscountPromotion(){

    }
    @Override
    public double getMoney(CartItem cartItem) {

        int discount = promotionService.getDiscount(cartItem.getProduct().getId());
        double money = cartItem.getProduct().getPrice() * cartItem.getCount() * discount / 100.0;
        return money;

    }
}
