package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.service.PromotionService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pos {
    private Scanner scanner;
    private PromotionService promotionService;

    public Pos() {
    }

    public Pos(Scanner scanner, PromotionService promotionService) {
        this.scanner = scanner;
        this.promotionService = promotionService;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public PromotionService getPromotionService() {
        return promotionService;
    }

    public void printInventory(List<String> barcodes) throws Exception {

        List<CartItem> cartItemList = this.getScanner().scan(barcodes);

        StringBuffer stringBuffer = new StringBuffer("\t\t\tlet us go购物清单 \t\t\t\t\n\n");

        stringBuffer.append("\t\t\t\t"+this.getDate()+"\n\n");
        stringBuffer.append("\t分类 \t名称 \t单位 \t价格 \t数量 \t小计\n\n");
        stringBuffer.append(buildCartItemString(cartItemList));
        stringBuffer.append(buildTotalMoneyString(cartItemList));

        System.out.println(stringBuffer.toString());
    }

    private String buildTotalMoneyString(List<CartItem> cartItemList){

        double totalMoney = 0.0;
        double discountMoney;
        double finalMoney = 0.0;

        for(CartItem cartItem : cartItemList){
            totalMoney += cartItem.getCount() * cartItem.getProduct().getPrice();
            finalMoney += this.getPromotionService().calculateMoney(cartItem);
        }
        discountMoney = totalMoney - finalMoney;
        return "\n\t\t\t\t\t优惠前:"+ totalMoney+
                "\n\t\t\t\t\t优惠后:" + finalMoney +
                "\n\t\t\t\t\t优惠差价:"+discountMoney;
    }

    private String buildCartItemString(List<CartItem> cartItemList){

        StringBuffer stringBuffer = new StringBuffer();

        for(CartItem cartItem:cartItemList){
            stringBuffer.append("\t"+cartItem.getProduct().getCategory().getName());
            stringBuffer.append(" \t"+cartItem.getProduct().getName());
            stringBuffer.append(" \t"+cartItem.getProduct().getUnit());
            stringBuffer.append(" \t"+cartItem.getProduct().getPrice());
            stringBuffer.append(" \t"+cartItem.getCount());
            stringBuffer.append(" \t"+this.getPromotionService().calculateMoney(cartItem)+"\n");
        }
        return stringBuffer.toString();
    }

    private String getDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
