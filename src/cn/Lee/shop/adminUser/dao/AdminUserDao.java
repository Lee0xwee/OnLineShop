package cn.Lee.shop.adminUser.dao;


import cn.Lee.shop.adminUser.domain.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminUserDao")
public class AdminUserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public AdminUser login(AdminUser adminUser) {

        String hql = "from AdminUser where username=? and password=?";
        List<AdminUser> list = (List<AdminUser>) hibernateTemplate.find(hql, adminUser.getUsername(), adminUser.getPassword());

        if (list != null && list.size() > 0) {

            return list.get(0);

        }

        return null;

    }
}
