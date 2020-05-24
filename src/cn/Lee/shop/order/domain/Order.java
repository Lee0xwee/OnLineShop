package cn.Lee.shop.order.domain;

import cn.Lee.shop.user.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "oid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    @Column(name = "total")
    private Double total;

    @Column(name = "ordertime")
    private Date ordertime;

    @Column(name = "state")
    private Integer state;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addr")
    private String addr;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "order",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemSet = new LinkedHashSet<OrderItem>();


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

}
