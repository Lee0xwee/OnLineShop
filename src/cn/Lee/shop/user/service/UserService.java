package cn.Lee.shop.user.service;


import cn.Lee.shop.user.dao.UserDao;
import cn.Lee.shop.user.domain.User;
import cn.Lee.shop.utils.MailUtil;
import cn.Lee.shop.utils.PageBean;
import cn.itcast.commons.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserService {


    @Autowired
    private UserDao userDao;

    public User findByUserName(String username) {

        return userDao.findByUserName(username);

    }

    public void regist(User user) throws Exception {


        user.setState(0);
        String code = CommonUtils.uuid() + CommonUtils.uuid();
        user.setCode(code);
        userDao.add(user);
        MailUtil.sendMail(user.getEmail(), code);

    }

    public User active(String code) {

        return userDao.findByCode(code);
    }

    public void updateState(User user) {

        userDao.updateState(user);
    }

    public User findByUser(User user) {

        return userDao.findByUser(user);
    }

    public User findByEmail(String email) {

        return userDao.findByEmail(email);
    }

    public PageBean<User> findPageAll(Integer pageNumber, Integer pageSize) {

        int totalCount = userDao.findCount();
        int totalPage = 0;
        if (totalCount % pageSize == 0) {

            totalPage = totalCount / pageSize;

        } else {

            totalPage = totalCount / pageSize + 1;

        }

        List<User> userList = userDao.findByPage((pageNumber - 1) * pageSize, pageSize);

        PageBean<User> pageBean = new PageBean();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setList(userList);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    public User findByUid(Integer uid) {

        return userDao.findByUid(uid);

    }

    public void update(User user) {

        userDao.update(user);
    }

    public void delete(Integer uid) {

        userDao.delete(uid);
    }
}
