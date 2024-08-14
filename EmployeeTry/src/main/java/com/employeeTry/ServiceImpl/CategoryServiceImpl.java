package com.employeeTry.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeTry.Repo.CategoryRepo;
import com.employeeTry.Service.CategoryService;
import com.employeeTry.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		Category createCategory=this.categoryRepo.save(category);
		return createCategory;
	}

	@Override
	public Category updateCategory(Category category, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categories=this.categoryRepo.findAll();
		List<Category> categories2=categories.stream().map(category -> {
            // Perform mapping logic here
            Category newCategory = new Category();
            newCategory.setCategoryId(category.getCategoryId());
            newCategory.setCategory(category.getCategory());
            return newCategory;
        }).collect(Collectors.toList());
		return categories2;
	}

}
