package cn.Lee.shop.cart.domain;

import cn.Lee.shop.product.domain.Product;

import java.math.BigDecimal;

public class CartItem {

    private Product product;  //商品
    private int count;  //数量
//    private double subtotal;    //小计


    //小计方法
    public double getSubtotal() {

        BigDecimal d1 = new BigDecimal(product.getShop_price() + "");
        BigDecimal d2 = new BigDecimal(count + "");
        return d1.multiply(d2).doubleValue();
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
