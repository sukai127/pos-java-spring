package com.thoughtworks.iamcoach.pos.model;

public class SecondHalfPricePromotion extends Promotion {

    @Override
    public double getMoney(CartItem cartItem) {

        int promotionCount = (int)(cartItem.getCount()/2.0);
        double count = cartItem.getCount() - promotionCount;
        double promotionMoney = cartItem.getProduct().getPrice()/2 * promotionCount;
        double money = cartItem.getProduct().getPrice() * count;

        return money + promotionMoney;
    }
}
