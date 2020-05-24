package cn.Lee.shop.order.domain;

import cn.Lee.shop.user.domain.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Double> total;
	public static volatile SingularAttribute<Order, String> phone;
	public static volatile SingularAttribute<Order, String> name;
	public static volatile SingularAttribute<Order, Integer> oid;
	public static volatile SingularAttribute<Order, Integer> state;
	public static volatile SingularAttribute<Order, Date> ordertime;
	public static volatile SingularAttribute<Order, String> addr;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile SetAttribute<Order, OrderItem> orderItemSet;

}

