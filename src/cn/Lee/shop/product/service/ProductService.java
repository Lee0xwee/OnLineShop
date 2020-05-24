package cn.Lee.shop.product.service;


import cn.Lee.shop.product.dao.ProductDao;
import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("productService")
@Transactional
public class ProductService {

    @Autowired
    private ProductDao productDao;


    public List<Product> findAll() {

        return productDao.findAll();
    }


    public List<Product> findByHot() {

        return productDao.findByHot();
    }

    public List<Product> findByNew() {

        return productDao.findByNew();
    }

    public Product findProduct(Integer pid) {

        return productDao.findProduct(pid);
    }

    public PageBean<Product> findPageAll(Integer pageNumber, Integer pageSize) {

        int totalCount = productDao.findCount();
        int totalPage = 0;
        if (totalCount % pageSize == 0) {

            totalPage = totalCount / pageSize;

        } else {

            totalPage = totalCount / pageSize + 1;

        }

        List<Product> productList = productDao.findByPage((pageNumber - 1) * pageSize, pageSize);

        PageBean<Product> pageBean = new PageBean();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setList(productList);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    public void save(Product product) {

        productDao.save(product);
    }

    public Product findByPid(Integer pid) {

        return productDao.findByPid(pid);
    }

    public void delete(Product product) {

        productDao.delete(product);
    }

    public void update(Product product) {

        productDao.update(product);
    }
}
