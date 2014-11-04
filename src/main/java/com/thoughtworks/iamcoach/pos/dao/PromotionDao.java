package com.thoughtworks.iamcoach.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionDao extends DbUtils{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public List<Integer> getPromotionTypes(int id) throws SQLException {

        List<Integer> promotionTypes = new ArrayList<Integer>();
        String sql = "select p2.type from productPromotions p1 ,promotion p2 where p2.id = p1.promotion_id and p1.product_id=?";

        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int type = resultSet.getInt("type");
            promotionTypes.add(type);
        }

        return promotionTypes;
    }

    public int getDiscount(int id) throws Exception{
        String sql = "select discount from productPromotions where product_id = ? and promotion_id = 3";

        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();

        resultSet.next();

        return resultSet.getInt("discount");
    }
}
