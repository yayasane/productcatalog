package sn.ys.productcatalog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ys.productcatalog.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
