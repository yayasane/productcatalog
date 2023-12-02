package sn.ys.productcatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ys.productcatalog.dao.ProductRepository;
import sn.ys.productcatalog.entities.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

    public Product save(Product product) {

        return productRepository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.isPresent() ? optionalProduct.get() : null;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void delete(Long id) {
        

        productRepository.deleteById(id);
    }

}