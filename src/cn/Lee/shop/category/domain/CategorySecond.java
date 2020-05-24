package cn.Lee.shop.category.domain;


import cn.Lee.shop.product.domain.Product;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categorysecond")
public class CategorySecond {

    @Id
    @Column(name = "csid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer csid;

    @Column(name = "csname")
    private String csname;

    @ManyToOne(targetEntity = Category.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Category cid;

    //    fetch = FetchType.EAGER 取消延迟加载
    @OneToMany(targetEntity = Product.class, mappedBy = "csid", fetch = FetchType.EAGER)
    private Set<Product> productSet=new LinkedHashSet<Product>();

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public Category getCid() {
        return cid;
    }

    public void setCid(Category cid) {
        this.cid = cid;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }


}
