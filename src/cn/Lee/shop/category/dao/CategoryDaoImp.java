package cn.Lee.shop.category.dao;


import cn.Lee.shop.category.domain.Category;
import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.utils.PageHibernateCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDaoImp")
public class CategoryDaoImp implements CategoryDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public List<Category> findAll() {

        List<Category> list = (List<Category>) hibernateTemplate.find("from Category ");
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }

    @Override
    public List<CategorySecond> finAllCs() {

        List<CategorySecond> list = (List<CategorySecond>) hibernateTemplate.find("from CategorySecond ");
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }


    @Override
    public int findCountCid(Integer cid) {

        String hql = "select count(*) from Product p where p.csid.cid.cid=?";
        List<Long> list = (List<Long>) hibernateTemplate.find(hql, cid);

        if (list != null && list.size() > 0) {

            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Product> findByPageCid(Integer cid, int start, Integer pageSize) {

        String hql = "select p from Product p join p.csid cs join cs.cid c where c.cid=? ";
        List<Product> list = hibernateTemplate.execute(new PageHibernateCallback<Product>(hql, start, pageSize, cid));
        if (list != null && list.size() > 0) {

            return list;
        }
        return null;
    }

    @Override
    public int findCountCsid(Integer csid) {

        String hql = "select count(*) from Product p where p.csid.csid=?";
        List<Long> list = (List<Long>) hibernateTemplate.find(hql, csid);
        if (list != null && list.size() > 0) {

            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Product> findByPageCsid(Integer csid, int start, Integer pageSize) {

//        String hql = "select p from Product p join p.csid cs where cs.csid=? ";

        String hql = "from Product p where p.csid.csid=? ";
        List<Product> list = hibernateTemplate.execute(new PageHibernateCallback<Product>(hql, start, pageSize, csid));
        if (list != null && list.size() > 0) {

            return list;
        }
        return null;
    }

    @Override
    public int findCount() {

        String hql = "select count(*) from CategorySecond ";
        List<Long> list = (List<Long>) hibernateTemplate.find(hql);
        if (list != null && list.size() > 0) {

            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<CategorySecond> findByPage(int start, Integer pageSize) {

        String hql = "from CategorySecond order by cid desc";
        List<CategorySecond> list = hibernateTemplate.execute(new PageHibernateCallback<CategorySecond>(hql, start, pageSize));
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }

    @Override
    public Category findByUid(Integer cid) {

        return hibernateTemplate.get(Category.class, cid);
    }

    @Override
    public CategorySecond findByCsid(Integer csid) {

        return hibernateTemplate.get(CategorySecond.class, csid);
    }


    //添加一级分类
    @Override
    public void saveC(Category category) {

        hibernateTemplate.save(category);
    }

    //添加二级分类
    @Override
    public void saveCs(CategorySecond categorySecond) {

        hibernateTemplate.save(categorySecond);

    }

    @Override
    public void updateC(Category category) {

        hibernateTemplate.update(category);

    }

    @Override
    public void updateCs(CategorySecond categorySecond) {

        hibernateTemplate.update(categorySecond);

    }

    @Override
    public void deleteC(Integer cid) {

        Category category = hibernateTemplate.get(Category.class, cid);
        hibernateTemplate.delete(category);

    }


    @Override
    public void deleteCs(Integer csid) {

        CategorySecond categorySecond = hibernateTemplate.get(CategorySecond.class, csid);
        hibernateTemplate.delete(categorySecond);

    }


}
