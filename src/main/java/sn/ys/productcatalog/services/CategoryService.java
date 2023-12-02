package sn.ys.productcatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ys.productcatalog.dao.CategoryRepository;
import sn.ys.productcatalog.entities.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {

        return categoryRepository.save(category);
    }

    public Category findById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.isPresent() ? optionalCategory.get() : null;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void delete(Integer id) {


        categoryRepository.deleteById(id);
    }

}