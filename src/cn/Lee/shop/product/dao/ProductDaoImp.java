package cn.Lee.shop.product.dao;


import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.utils.PageHibernateCallback;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDaoImp")
public class ProductDaoImp implements ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public List<Product> findAll() {

        List<Product> list = (List<Product>) hibernateTemplate.find("from Category ");
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }

    @Override
    public List<Product> findByHot() {


        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        dc.add(Restrictions.eq("is_hot", 1));
        dc.addOrder(Order.desc("pdate"));
        List<Product> list = (List<Product>) hibernateTemplate.findByCriteria(dc, 0, 10);
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }

    @Override
    public List<Product> findByNew() {

        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        dc.addOrder(Order.desc("pdate"));
        List<Product> list = (List<Product>) hibernateTemplate.findByCriteria(dc, 0, 10);
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }

    @Override
    public Product findProduct(Integer pid) {

        String hql = "from Product where pid=?";
        List<Product> list = (List<Product>) hibernateTemplate.find(hql, pid);
        if (list != null && list.size() > 0) {

            return list.get(0);
        }

        return null;
    }

    @Override
    public int findCount() {

        String hql = "select count(*) from Product";
        List<Long> list = (List<Long>) hibernateTemplate.find(hql);

        if (list != null && list.size() > 0) {

            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Product> findByPage(int start, Integer pageSize) {

        String hql = "from Product order by pdate desc";
        List<Product> list = hibernateTemplate.execute(new PageHibernateCallback<Product>(hql, start, pageSize));

        if (list != null && list.size() > 0) {

            return list;
        }
        return null;
    }

    @Override
    public void save(Product product) {

        hibernateTemplate.save(product);
    }

    @Override
    public Product findByPid(Integer pid) {

        return hibernateTemplate.get(Product.class, pid);

    }

    @Override
    public void update(Product product) {

        hibernateTemplate.update(product);

    }

    @Override
    public void delete(Product product) {

        hibernateTemplate.delete(product);

    }


}
