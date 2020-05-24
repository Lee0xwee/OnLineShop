package cn.Lee.shop.user.dao;

import cn.Lee.shop.user.domain.User;

import java.util.List;

public interface UserDao {


    User findByUserName(String username);

    void add(User user);

    User findByCode(String code);

    void updateState(User user);

    User findByUser(User user);

    User findByEmail(String email);

    int findCount();

    List<User> findByPage(int start, Integer pageSize);

    User findByUid(Integer uid);

    void update(User user);

    void delete(Integer uid);





}
