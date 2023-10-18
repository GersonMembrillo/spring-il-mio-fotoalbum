package org.java.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.java.app.user.Role;
import org.java.app.user.User;
import org.java.app.user.RoleServ;
import org.java.app.user.UserServ;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private FotoServ fotoServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private RoleServ roleServ;

	@Autowired
	private UserServ userServ;

	@Override
	public void run(String... args) throws Exception {
		
		Category category1 = new Category("Architettura");
		Category category2 = new Category("Luogo");
		Category category3 = new Category("Monumento");
		Category category4 = new Category("Pianta");
		Category category5 = new Category("Animale");
		Category category6 = new Category("Scultura");
		Category category7 = new Category("Arte");
		Category category8 = new Category("Dipinto");
		Category category9 = new Category("Ambiente");
		Category category10 = new Category("Cibo");
		Category category11 = new Category("Persona");
		Category category12 = new Category("Città");
		
		categoryServ.save(category1);
		categoryServ.save(category2);
		categoryServ.save(category3);
		categoryServ.save(category4);
		categoryServ.save(category5);
		categoryServ.save(category6);
		categoryServ.save(category7);
		categoryServ.save(category8);
		categoryServ.save(category9);
		categoryServ.save(category10);
		categoryServ.save(category11);
		categoryServ.save(category12);
		
  		Foto foto1 = new Foto("Architettura moderna",
  				"Interno di un edificio appena edificato",
  				"https://images.unsplash.com/photo-1672079535924-d00ac5f25590?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2148&q=80",
  				true, category1, category2, category12
  				);
  		Foto foto2 = new Foto("Acqua Eterna",
  				"Scultura dell'acqua ferma nel tempo",
  				"https://images.unsplash.com/photo-1695917642455-8ee7e1ce83db?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2160&q=80",
  				true, category6, category7
  				);
  		Foto foto3 = new Foto("Into the Wild",
  				"Fauna nel suo habitad naturale",
  				"https://images.unsplash.com/photo-1682687982093-4773cb0dbc2e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2187&q=80",
  				true, category2, category5, category9
  				);
  		Foto foto4 = new Foto("Reaching god",
  				"Luoghi estremi dove predicare il proprio dio",
  				"https://images.unsplash.com/photo-1696960595275-9d9c84977c52?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2188&q=80",
  				true, category2, category9
  				);
  		Foto foto5 = new Foto("Siegessäule",
  				"La colonna della Vittoria è uno dei monumenti più celebri di Berlino. Si trova all'interno del parco del Tiergarten.",
  				"https://images.unsplash.com/photo-1696960594920-1ca9a1f250bc?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2186&q=80",
  				true, category1, category2, category3, category12
  				);
  		
  		fotoServ.save(foto1);
  		fotoServ.save(foto2);
  		fotoServ.save(foto3);
  		fotoServ.save(foto4);
  		fotoServ.save(foto5);
  		
  		Role userRole = new Role("USER");
		Role adminRole = new Role("ADMIN");
		
		roleServ.save(userRole);
		roleServ.save(adminRole);
		
		final String pwsUser = new BCryptPasswordEncoder().encode("pws");
		final String pwsAdmin = new BCryptPasswordEncoder().encode("pws");
		
		User ciccioUser = new User("ciccioUser", pwsUser, userRole);
		User ciccioAdmin = new User("ciccioAdmin", pwsAdmin, adminRole);
		
		userServ.save(ciccioUser);
		userServ.save(ciccioAdmin);
  		
  		System.out.println("Insert OK");
	}
}
