package cn.Lee.shop.category.dao;

import cn.Lee.shop.category.domain.Category;
import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.product.domain.Product;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    int findCountCid(Integer cid);

    List<Product> findByPageCid(Integer cid, int start, Integer pageSize);

    int findCountCsid(Integer csid);

    List<Product> findByPageCsid(Integer csid, int start, Integer pageSize);

    int findCount();

    List<CategorySecond> findByPage(int start, Integer pageSize);

    Category findByUid(Integer cid);

    CategorySecond findByCsid(Integer csid);

    void updateC(Category category);

    void deleteC(Integer cid);

    void saveC(Category category);

    void saveCs(CategorySecond categorySecond);


    void updateCs(CategorySecond categorySecond);

    void deleteCs(Integer csid);

    List<CategorySecond> finAllCs();
}
