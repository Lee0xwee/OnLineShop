package cn.Lee.shop.product.action;


import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.category.service.CategoryService;
import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.product.service.ProductService;
import cn.Lee.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.Date;
import java.util.List;


@Controller("adminProductAction")
@Scope("prototype")
@ParentPackage("shop")

public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    private List<CategorySecond> csList;

    //分页参数
    private PageBean<Product> pageBean;
    private Integer pageNumber = 1;
    private Integer pageSize = 10;

    //模型驱动封装参数
    private Product product = new Product();

    //文件上传参数

    private File upload;  //上传的文件
    private String uploadFileName;   //接收文件的上传的文件名
    private String uploadContexType; //接收文件上床的文件MIME的类型


    @Override
    public Product getModel() {
        return product;
    }

    public PageBean<Product> getPageBean() {
        return pageBean;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUploadContexType(String uploadContexType) {
        this.uploadContexType = uploadContexType;
    }

    public List<CategorySecond> getCsList() {
        return csList;
    }

    @Action(value = "adminProduct_findAll", results = {@Result(name = "findAll", location = "/admin/product/list.jsp")})
    public String findAll() {


        pageBean = productService.findPageAll(pageNumber, pageSize);
        return "findAll";
    }

    @Action(value = "adminProduct_toAddPage", results = {@Result(name = "toAddPage", location = "/admin/product/add.jsp")})
    public String toAddPage() {

        csList = categoryService.finAllCs();
        return "toAddPage";
    }

    @Action(value = "adminProduct_save", results = {@Result(name = "save", type = "redirectAction", location = "adminProduct_findAll")})
    public String save() throws Exception {


        product.setPdate(new Date());
        //保存商品图片路径
        if (upload != null) {

            String realPath = ServletActionContext.getServletContext()
                    .getRealPath("/products");
            File desFile = new File(realPath + "//" + uploadFileName);
            FileUtils.copyFile(upload, desFile);
            product.setImage("products/" + uploadFileName);

        }
        productService.save(product);
        return "save";
    }

    @Action(value = "adminProduct_edit", results = {@Result(name = "edit", location = "/admin/product/edit.jsp")})
    public String edit() {

        csList = categoryService.finAllCs();
        product = productService.findByPid(product.getPid());
        return "edit";
    }


    @Action(value = "adminProduct_update", results = {@Result(name = "update", type = "redirectAction", location = "adminProduct_findAll")})
    public String update() throws Exception {

        product.setPdate(new Date());

        if (upload != null) {

            //删除原尚商品图片
            String path = product.getImage();
            File file = new File(ServletActionContext
                    .getServletContext().getRealPath("/" + path));
            file.delete();
            String realPath = ServletActionContext.getServletContext()
                    .getRealPath("/products");
            File desFile = new File(realPath + "/" + uploadFileName);
            FileUtils.copyFile(upload, desFile);
            product.setImage("products/" + uploadFileName);

        }
        productService.update(product);
        return "update";
    }


    @Action(value = "adminProduct_delete", results = {@Result(name = "delete", type = "redirectAction", location = "adminProduct_findAll")})
    public String delete() {


        product = productService.findByPid(product.getPid());
        //删除商品图片
        String path = product.getImage();

        if (path != null) {

            String realPath = ServletActionContext.getServletContext().getRealPath("/" + path);
            File file = new File(realPath);
            file.delete();
        }
        productService.delete(product);
        return "delete";
    }


}
