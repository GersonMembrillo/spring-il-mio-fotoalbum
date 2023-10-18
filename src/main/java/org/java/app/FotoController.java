package org.java.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class FotoController {

	@Autowired
	private FotoServ fotoServ;

	@GetMapping
	public String getIndex(@RequestParam(required = false, name = "search") String searchTitle, Model model) {

		System.out.println("search: " + searchTitle);

//		List<Pizza> pizze = pizzaServ.findAll();
		List<Foto> fotos = searchTitle == null ? fotoServ.findAll() : fotoServ.findByTitle(searchTitle);

		model.addAttribute("fotos", fotos);
		model.addAttribute("searchTitle", searchTitle);

		return "foto-index";
	}

	@GetMapping("/{id}")
	public String getShow(@PathVariable Integer id, Model model) {
		Foto foto = fotoServ.findById(id);
		model.addAttribute("foto", foto);
		return "foto-show";
	}

	@GetMapping("/create")
	public String getCreateFormt(Model model) {

		model.addAttribute("foto", new Foto());

		return "foto-create";
	}

	@PostMapping("/create")
	public String storeNewFoto(
			@Valid @ModelAttribute Foto foto,
			BindingResult bindingResult,
			Model model
    ) {
		
		return storeFoto(foto, bindingResult);
	}
			
	@GetMapping("/edit/{id}")
	public String getEditForm(@PathVariable int id, Model model) {

		Foto foto = fotoServ.findById(id);
		model.addAttribute("foto", foto);

		return "foto-create";
	}

	@PostMapping("/edit/{id}")
	public String updateFoto(@Valid @ModelAttribute Foto foto, BindingResult bindingResult) {

		return storeFoto(foto, bindingResult);
	}

	@PostMapping("/delete/{id}")
	public String deletePizza(@PathVariable int id) {

		Foto foto = fotoServ.findById(id);
		fotoServ.deleteFoto(foto);

		return "redirect:/";
	}

	private String storeFoto(Foto foto, BindingResult bindingResult) {

		System.out.println("foto:\n" + foto);

		if (bindingResult.hasErrors()) {

			System.out.println("Errors");
			bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).forEach(System.out::println);
			return "foto-create";
		}

		fotoServ.save(foto);

		return "redirect:/";
	}

}
