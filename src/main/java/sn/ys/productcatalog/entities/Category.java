package sn.ys.productcatalog.entities;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products = new ArrayList<>();

    public String toString(){
        return "Category{" + "id=' " + id + '\'' + ", name= '" + name + '\'' + '}';
    }
}
