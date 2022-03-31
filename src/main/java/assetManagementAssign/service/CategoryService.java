package assetManagementAssign.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assetManagementAssign.entity.Category;
import assetManagementAssign.repository.CategoryRepository;
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		categoryRepository.save(category);
		
	}

	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
		
	}

	public void updateCategory(Category category) {
		Optional<Category> categ = categoryRepository.findById(category.getId());
		if(categ.isPresent()) {
			Category existing = categ.get();
			if(category.getName() != null) {
				existing.setName(category.getName());
			}
			if(category.getDescription() != null) {
				existing.setDescription(category.getDescription());
			}
		categoryRepository.save(existing);

		}	
	}

	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
}
