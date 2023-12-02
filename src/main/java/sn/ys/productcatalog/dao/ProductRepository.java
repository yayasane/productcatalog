package sn.ys.productcatalog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ys.productcatalog.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
