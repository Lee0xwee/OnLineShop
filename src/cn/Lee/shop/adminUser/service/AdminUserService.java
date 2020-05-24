package cn.Lee.shop.adminUser.service;


import cn.Lee.shop.adminUser.dao.AdminUserDao;
import cn.Lee.shop.adminUser.domain.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminUserService")
@Transactional
public class AdminUserService {


    @Autowired
    private AdminUserDao adminUserDao;


    public AdminUser login(AdminUser adminUser) {

        return adminUserDao.login(adminUser);
    }
}
