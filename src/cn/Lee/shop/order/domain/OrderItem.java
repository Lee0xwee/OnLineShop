package cn.Lee.shop.order.domain;

import cn.Lee.shop.product.domain.Product;

import javax.persistence.*;


@Entity
@Table(name = "orderItem")
public class OrderItem {


    @Id
    @Column(name = "itemid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemid;
    private Integer count;
    private Double subtotal;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    private Product product;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    private Order order;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
