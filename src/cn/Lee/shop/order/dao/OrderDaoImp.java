package cn.Lee.shop.order.dao;

import cn.Lee.shop.order.domain.Order;
import cn.Lee.shop.utils.PageHibernateCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("orderDaoImp")
public class OrderDaoImp implements OrderDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public void save(Order order) {

        hibernateTemplate.save(order);
    }

    @Override
    public int findCountUid(Integer uid) {

        String hql = "select count(*) from Order o where o.user.uid=?";
        List<Long> list = (List<Long>) hibernateTemplate.find(hql, uid);
        if (list != null && list.size() > 0) {

            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Order> findByPageUid(Integer uid, int start, Integer pageSize) {


        String hql = "from Order o where o.user.uid = ? order by ordertime desc";
        List<Order> list = hibernateTemplate.execute(new PageHibernateCallback<Order>(hql, start, pageSize, uid));
        if (list != null && list.size() > 0) {

            return list;
        }
        return null;
    }

    @Override
    public Order findByOid(Integer oid) {

        return hibernateTemplate.get(Order.class, oid);
    }

    @Override
    public void update(Order currOrder) {

        hibernateTemplate.update(currOrder);

    }

    @Override
    public int findCount() {

        String hql = "select count(*) from Order";
        List<Long> list = (List<Long>) hibernateTemplate.find(hql);

        if (list != null && list.size() > 0) {

            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Order> findByPage(int start, Integer pageSize) {

        String hql = "from Order order by ordertime desc";
        List<Order> list = hibernateTemplate.execute(new PageHibernateCallback<Order>(hql, start, pageSize));
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }



}



