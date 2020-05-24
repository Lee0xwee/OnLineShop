package cn.Lee.shop.category.domain;

import cn.Lee.shop.product.domain.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CategorySecond.class)
public abstract class CategorySecond_ {

	public static volatile SingularAttribute<CategorySecond, Integer> csid;
	public static volatile SingularAttribute<CategorySecond, String> csname;
	public static volatile SingularAttribute<CategorySecond, Category> cid;
	public static volatile SetAttribute<CategorySecond, Product> productSet;

}

