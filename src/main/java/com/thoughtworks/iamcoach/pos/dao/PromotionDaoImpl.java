package com.thoughtworks.iamcoach.pos.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PromotionDaoImpl implements PromotionDao {

    private JdbcTemplate jdbcTemplate ;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Integer> getPromotionTypes(int id) throws SQLException {

        List<Integer> promotionTypes;
        String sql = "select p2.type from productPromotions p1 ,promotion p2 where p2.id = p1.promotion_id and p1.product_id=?";

        promotionTypes = jdbcTemplate.query(sql,new Object[]{id},new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("type");
            }
        });

        return promotionTypes;
    }

    @Override
    public int getDiscount(int id) throws Exception{

        String sql = "select discount from productPromotions where product_id = ? and promotion_id = 3";

        int discount = jdbcTemplate.query(sql,new Object[]{id},new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("discount");
            }
        }).get(0);

        return discount;
    }
}
