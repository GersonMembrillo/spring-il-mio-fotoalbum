package org.java.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private FotoServ fotoServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	@GetMapping
	public String getIndex(Model model) {
		
		List<Category> categories = categoryServ.findAll();
		model.addAttribute("categories", categories);
		
		return "category-index";
	}
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		
		model.addAttribute("category", new Category());
		
		return "category-create";
	}
	
	@PostMapping("/create")
	public String storeCategory(
			@Valid @ModelAttribute Category category,
			BindingResult bindingResult,
			Model model
		) {
		
		if (bindingResult.hasErrors()) {
			
			return "category-create";
			
		}
			
			categoryServ.save(category);
				
		return "redirect:/categories";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteCategory(
			@PathVariable int id
		) {
		
		Category category = categoryServ.findById(id);

		for (Foto f : category.getFotos()) {
			
			f.deleteCategory(category);
			fotoServ.save(f);
		}

		categoryServ.delete(category);
		
		return "redirect:/categories";
	}
}
