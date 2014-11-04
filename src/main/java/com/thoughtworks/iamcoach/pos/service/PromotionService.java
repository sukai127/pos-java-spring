package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sukai on 11/4/14.
 */
public interface PromotionService {
    double calculateMoney(CartItem cartItem);

    int getDiscount(int id);

    List<Promotion> getPromotionList(int id) throws SQLException;
}
