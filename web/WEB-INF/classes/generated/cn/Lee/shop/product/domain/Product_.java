package cn.Lee.shop.product.domain;

import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.order.domain.OrderItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> image;
	public static volatile SingularAttribute<Product, Double> shop_price;
	public static volatile SingularAttribute<Product, CategorySecond> csid;
	public static volatile SingularAttribute<Product, String> pname;
	public static volatile SingularAttribute<Product, Integer> is_hot;
	public static volatile SingularAttribute<Product, Date> pdate;
	public static volatile SingularAttribute<Product, String> pdesc;
	public static volatile SingularAttribute<Product, Double> market_price;
	public static volatile SingularAttribute<Product, Integer> pid;
	public static volatile SetAttribute<Product, OrderItem> orderItemSet;

}

