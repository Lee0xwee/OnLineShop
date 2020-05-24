package cn.Lee.shop.category.domain;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column(name = "cname")
    private String cname;

    //    fetch = FetchType.EAGER 取消延迟加载
    @OneToMany(targetEntity = CategorySecond.class, mappedBy = "cid",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CategorySecond> categorySecondSet = new LinkedHashSet<CategorySecond>();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<CategorySecond> getCategorySecondSet() {
        return categorySecondSet;
    }

    public void setCategorySecondSet(Set<CategorySecond> categorySecondSet) {
        this.categorySecondSet = categorySecondSet;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", categorySecondSet=" + categorySecondSet +
                '}';
    }


}
