package org.java.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> findAll() {
		
		return categoryRepo.findAll();
	}
	public Category findById(int id) {
		
		return categoryRepo.findById(id).get();
	}
	public void save(Category category) {
		
		categoryRepo.save(category);
	}
	
	public void delete(Category category) {
		
		categoryRepo.delete(category);
	}
}

