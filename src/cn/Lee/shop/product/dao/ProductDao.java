package cn.Lee.shop.product.dao;

import cn.Lee.shop.product.domain.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    List<Product> findByHot();

    List<Product> findByNew();

    Product findProduct(Integer pid);

    int findCount();

    List<Product> findByPage(int start, Integer pageSize);

    void save(Product product);

    Product findByPid(Integer pid);

    void delete(Product product);

    void update(Product product);
}
