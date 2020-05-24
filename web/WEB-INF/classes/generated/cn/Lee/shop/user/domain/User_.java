package cn.Lee.shop.user.domain;

import cn.Lee.shop.order.domain.Order;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Integer> uid;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> code;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SetAttribute<User, Order> orderSet;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, Integer> state;
	public static volatile SingularAttribute<User, String> addr;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;

}

