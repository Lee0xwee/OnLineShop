package cn.Lee.shop.order.service;


import cn.Lee.shop.order.dao.OrderDao;
import cn.Lee.shop.order.domain.Order;
import cn.Lee.shop.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderService {

    @Autowired
    private OrderDao orderDao;


    public void save(Order order) {

        orderDao.save(order);
    }


    public PageBean<Order> findByUid(Integer uid, Integer pageNumber, Integer pageSize) {

        int totalCount = orderDao.findCountUid(uid);
        int totalPage = 0;
        if (totalCount % pageSize == 0) {

            totalPage = totalCount / pageSize;

        } else {

            totalPage = totalCount / pageSize + 1;

        }

        List<Order> productList = orderDao.findByPageUid(uid, (pageNumber - 1) * pageSize, pageSize);

        PageBean<Order> pageBean = new PageBean();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setList(productList);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;

    }

    public Order findByOid(Integer oid) {

        return orderDao.findByOid(oid);
    }

    public void update(Order currOrder) {

        orderDao.update(currOrder);
    }

    public PageBean<Order> findPageAll(Integer pageNumber, Integer pageSize) {

        int totalCount = orderDao.findCount();
        int totalPage = 0;
        if (totalCount % pageSize == 0) {

            totalPage = totalCount / pageSize;

        } else {

            totalPage = totalCount / pageSize + 1;

        }

        List<Order> orderList = orderDao.findByPage((pageNumber - 1) * pageSize, pageSize);

        PageBean<Order> pageBean = new PageBean<Order>();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setList(orderList);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;


    }
}
