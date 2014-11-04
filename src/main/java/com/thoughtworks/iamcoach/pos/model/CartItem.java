package com.thoughtworks.iamcoach.pos.model;

public class CartItem implements Comparable{
    private Product product;
    private double count;

    public CartItem(){

    }

    public CartItem(Product product, double count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {
        CartItem cartItem = (CartItem)o;
        return this.getProduct().getCategory().getId() - cartItem.getProduct().getCategory().getId() ;
    }
}
