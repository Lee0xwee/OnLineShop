package cn.Lee.shop.order.dao;

import cn.Lee.shop.order.domain.Order;

import java.util.List;

public interface OrderDao {

    void save(Order order);

    int findCountUid(Integer uid);

    List<Order> findByPageUid(Integer uid, int start, Integer pageSize);

    Order findByOid(Integer oid);

    void update(Order currOrder);

    int findCount();

    List<Order> findByPage(int start, Integer pageSize);

}
