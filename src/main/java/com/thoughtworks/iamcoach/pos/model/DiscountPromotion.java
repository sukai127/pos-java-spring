package com.thoughtworks.iamcoach.pos.model;

import com.thoughtworks.iamcoach.pos.service.PromotionServiceImpl;

public class DiscountPromotion extends Promotion{

    private PromotionServiceImpl promotionServiceImpl = new PromotionServiceImpl();

    @Override
    public double getMoney(CartItem cartItem) {

        int discount = promotionServiceImpl.getDiscount(cartItem.getProduct().getId());
        double money = cartItem.getProduct().getPrice() * cartItem.getCount() * discount / 100.0;
        return money;

    }
}
