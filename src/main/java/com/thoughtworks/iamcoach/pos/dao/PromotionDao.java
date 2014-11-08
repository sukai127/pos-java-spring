package com.thoughtworks.iamcoach.pos.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sukai on 11/4/14.
 */
public interface PromotionDao {
    List<Integer> getPromotionTypes(int id) throws SQLException;

    int getDiscount(int id);
}
