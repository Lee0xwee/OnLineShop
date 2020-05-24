package cn.Lee.shop.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
    private double total;  //总计

    public void clearCart() {

        map.clear();
        //总计清零
        total = 0;


    }

    public void removeCart(Integer pid) {

        CartItem cartItem = map.remove(pid);

        total -= cartItem.getSubtotal();


    }

    public void addCart(CartItem cartItem) {

        Integer pid = cartItem.getProduct().getPid();

        if (map.containsKey(pid)) {  //判断原来车中是否存在该条目

            CartItem _cartItem = map.get(pid);  //返回原条目

            //设置老条目的数量为，其自己数量+新条目的数量
            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());


        } else {

            map.put(pid, cartItem);
        }

        total += cartItem.getSubtotal();


    }

    public Collection<CartItem> getCartItems() {

        return map.values();
    }

    public double getTotal() {


        // 合计=所有条目的小计之和
        BigDecimal total = new BigDecimal("0");
        for (CartItem cartItem : map.values()) {
            BigDecimal subtotal = new BigDecimal("" + cartItem.getSubtotal());
            total = total.add(subtotal);
        }
        return total.doubleValue();
    }


}
