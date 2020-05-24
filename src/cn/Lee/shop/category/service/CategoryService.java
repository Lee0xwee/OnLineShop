package cn.Lee.shop.category.service;


import cn.Lee.shop.category.dao.CategoryDao;
import cn.Lee.shop.category.domain.Category;
import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("categoryService")
@Transactional
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    //查询所有一级分类
    public List<Category> findAll() {

        return categoryDao.findAll();
    }


    //查询所有二级分类
    public List<CategorySecond> finAllCs() {

        return categoryDao.finAllCs();
    }


    public PageBean<Product> findByPageCid(Integer cid, Integer pageNumber, Integer pageSize) {


        int totalCount = categoryDao.findCountCid(cid);
//        int totalPage = (int) Math.ceil(totalCount / pageSize);
        int totalPage = 0;
        if (totalCount % pageSize == 0) {

            totalPage = totalCount / pageSize;

        } else {

            totalPage = totalCount / pageSize + 1;

        }

        List<Product> productList = categoryDao.findByPageCid(cid, (pageNumber - 1) * pageSize, pageSize);

        PageBean<Product> pageBean = new PageBean();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setList(productList);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }


    public PageBean<Product> findByCsid(Integer csid, Integer pageNumber, Integer pageSize) {

        int totalCount = categoryDao.findCountCsid(csid);
        int totalPage = 0;
        if (totalCount % pageSize == 0) {

            totalPage = totalCount / pageSize;

        } else {

            totalPage = totalCount / pageSize + 1;

        }

        List<Product> productList = categoryDao.findByPageCsid(csid, (pageNumber - 1) * pageSize, pageSize);

        PageBean<Product> pageBean = new PageBean();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setList(productList);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;


    }

    public PageBean<CategorySecond> findPageAll(Integer pageNumber, Integer pageSize) {

        int totalCount = categoryDao.findCount();
        int totalPage = 0;
        if (totalCount % pageSize == 0) {

            totalPage = totalCount / pageSize;

        } else {

            totalPage = totalCount / pageSize + 1;

        }

        List<CategorySecond> categorySecondList = categoryDao.findByPage((pageNumber - 1) * pageSize, pageSize);

        PageBean<CategorySecond> pageBean = new PageBean();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setList(categorySecondList);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;


    }

    public Category findByUid(Integer cid) {

        return categoryDao.findByUid(cid);
    }

    public void updateC(Category category) {

        categoryDao.updateC(category);
    }

    public void deleteC(Integer cid) {

        categoryDao.deleteC(cid);
    }

    public void saveC(Category category) {

        categoryDao.saveC(category);
    }

    public void saveCs(CategorySecond categorySecond) {

        categoryDao.saveCs(categorySecond);
    }

    public CategorySecond findByCsid(Integer csid) {

        return categoryDao.findByCsid(csid);
    }

    public void updateCs(CategorySecond categorySecond) {

        categoryDao.updateCs(categorySecond);
    }

    public void deleteCs(Integer csid) {

        categoryDao.deleteCs(csid);
    }


}
