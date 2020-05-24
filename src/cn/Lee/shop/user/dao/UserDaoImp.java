package cn.Lee.shop.user.dao;


import cn.Lee.shop.user.domain.User;
import cn.Lee.shop.utils.PageHibernateCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDaoImp")
public class UserDaoImp implements UserDao {


    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public User findByUserName(String username) {

        String hql = "from User where username=?";
        List<User> list = (List<User>) hibernateTemplate.find(hql, username);

        if (list != null && list.size() > 0) {

            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {

        String hql = "from User where email=?";
        List<User> list = (List<User>) hibernateTemplate.find(hql, email);

        if (list != null && list.size() > 0) {

            return list.get(0);
        }
        return null;
    }


    @Override
    public void add(User user) {

        hibernateTemplate.save(user);

    }

    @Override
    public User findByCode(String code) {


        String hql = "from User where code=?";
        List<User> list = (List<User>) hibernateTemplate.find(hql, code);

        if (list != null && list.size() > 0) {

            return list.get(0);
        }
        return null;
    }

    @Override
    public void updateState(User user) {

        hibernateTemplate.update(user);
    }

    @Override
    public User findByUser(User user) {

        String hql = "from User where username=? and password=? and state=?";
        List<User> list = (List<User>) hibernateTemplate.find(hql, user.getUsername(), user.getPassword(), 1);
        if (list != null && list.size() > 0) {

            return list.get(0);
        }
        return null;
    }

    @Override
    public int findCount() {

        String hql = "select count(*) from User";
        List<Long> list = (List<Long>) hibernateTemplate.find(hql);

        if (list != null && list.size() > 0) {

            return list.get(0).intValue();
        }
        return 0;

    }

    @Override
    public List<User> findByPage(int start, Integer pageSize) {

        String hql = "from User order by username desc";
        List<User> list = hibernateTemplate.execute(new PageHibernateCallback<User>(hql, start, pageSize));
        if (list != null && list.size() > 0) {

            return list;
        }

        return null;
    }

    @Override
    public User findByUid(Integer uid) {

        return hibernateTemplate.get(User.class, uid);

    }

    @Override
    public void update(User user) {

        hibernateTemplate.update(user);

    }

    @Override
    public void delete(Integer uid) {

        User user = hibernateTemplate.get(User.class, uid);

        hibernateTemplate.delete(user);

    }


}
