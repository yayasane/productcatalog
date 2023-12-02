package sn.ys.productcatalog.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sn.ys.productcatalog.dao.ProductRepository;
import sn.ys.productcatalog.entities.Category;
import sn.ys.productcatalog.entities.Product;
import sn.ys.productcatalog.entities.Product;
import static org.mockito.BDDMockito.then;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;

    private ProductService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProductService(productRepository);
    }

    @Test
    void givenProductDto_whenAddProduct_thenShouldSaveSuccess() {
        //Given
        Collection<Product> products = new ArrayList<>();
        Category category = new Category(null,"Cat test",products);
        Product product = new Product(null,"Cat test",50000, category);

        //When
        underTest.save(product);

        //Then
        then(productRepository).should().save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();
        assertThat(capturedProduct).isEqualTo(product);
        then(productRepository).should().save(product);

    }
}