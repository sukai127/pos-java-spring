package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.model.CartItem;
import com.thoughtworks.iamcoach.pos.service.PromotionServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pos {
    private Scanner scanner;
    private PromotionServiceImpl promotionServiceImpl;

    public Pos() {
    }

    public Pos(Scanner scanner, PromotionServiceImpl promotionServiceImpl) {
        this.scanner = scanner;
        this.promotionServiceImpl = promotionServiceImpl;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public PromotionServiceImpl getPromotionServiceImpl() {
        return promotionServiceImpl;
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
            finalMoney += this.getPromotionServiceImpl().calculateMoney(cartItem);
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
            stringBuffer.append(" \t"+this.getPromotionServiceImpl().calculateMoney(cartItem)+"\n");
        }
        return stringBuffer.toString();
    }

    private String getDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
