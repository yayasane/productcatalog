package sn.ys.productcatalog.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sn.ys.productcatalog.dao.CategoryRepository;
import sn.ys.productcatalog.entities.Category;
import sn.ys.productcatalog.entities.Product;
import static org.mockito.BDDMockito.then;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Captor
    ArgumentCaptor<Category> categoryArgumentCaptor;

    private CategoryService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CategoryService(categoryRepository);
    }

    @Test
    void givenCategoryDto_whenAddCategory_thenShouldSaveSuccess() {
        //Given
        Collection<Product> products = new ArrayList<>();
        Category category = new Category(null,"Cat test",products);

        //When
        underTest.save(category);

        //Then
        then(categoryRepository).should().save(categoryArgumentCaptor.capture());
        Category capturedCategory = categoryArgumentCaptor.getValue();
        assertThat(capturedCategory).isEqualTo(category);
        then(categoryRepository).should().save(category);

    }
}