package cn.Lee.shop.order.domain;

import cn.Lee.shop.product.domain.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderItem.class)
public abstract class OrderItem_ {

	public static volatile SingularAttribute<OrderItem, Integer> itemid;
	public static volatile SingularAttribute<OrderItem, Product> product;
	public static volatile SingularAttribute<OrderItem, Double> subtotal;
	public static volatile SingularAttribute<OrderItem, Integer> count;
	public static volatile SingularAttribute<OrderItem, Order> order;

}

