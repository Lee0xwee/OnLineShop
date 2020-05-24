package cn.Lee.shop.product.domain;


import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.order.domain.OrderItem;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "market_price")
    private Double market_price;

    @Column(name = "shop_price")
    private Double shop_price;

    @Column(name = "image")
    private String image;

    @Column(name = "pdesc")
    private String pdesc;

    @Column(name = "is_hot")
    private Integer is_hot;

    @Column(name = "pdate")
    private Date pdate;

    //fetch = FetchType.EAGER取消延迟加载
    @ManyToOne(targetEntity = CategorySecond.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "csid", referencedColumnName = "csid")
    private CategorySecond csid;

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "product")
    private Set<OrderItem> orderItemSet = new LinkedHashSet<OrderItem>();

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public CategorySecond getCsid() {
        return csid;
    }

    public void setCsid(CategorySecond csid) {
        this.csid = csid;
    }
}
