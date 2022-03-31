package assetManagementAssign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import assetManagementAssign.entity.Category;
import assetManagementAssign.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public String addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
				return "created";
	}
	
	@DeleteMapping("/category/{id}")
	public String deleteCategory(@RequestBody Category category) {
		categoryService.deleteCategory(category);
				return "deleted";
	}

	
	@PutMapping("/category/{id}")
	public String updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
				return "updated";
	}
	@GetMapping("/categories")
	public List<Category> getCategory() {
		return categoryService.getAll();
	}
}
