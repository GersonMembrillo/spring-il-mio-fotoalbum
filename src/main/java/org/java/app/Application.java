package org.java.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private FotoServ fotoServ;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
  		Foto foto1 = new Foto("Architettura moderna",
  				"Interno di un edificio appena edificato",
  				"https://images.unsplash.com/photo-1672079535924-d00ac5f25590?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2148&q=80",
  				true,
  				"Architettura");
  		Foto foto2 = new Foto("Acqua Eterna",
  				"Scultura dell'acqua ferma nel tempo",
  				"https://images.unsplash.com/photo-1695917642455-8ee7e1ce83db?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2160&q=80",
  				true,
  				"Scultura");
  		Foto foto3 = new Foto("Into the Wild",
  				"Fauna nel suo habitad naturale",
  				"https://images.unsplash.com/photo-1682687982093-4773cb0dbc2e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2187&q=80",
  				true,
  				"Animali");
  		Foto foto4 = new Foto("Reaching god",
  				"Luoghi estremi dove predicare il proprio dio",
  				"https://images.unsplash.com/photo-1696960595275-9d9c84977c52?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2188&q=80",
  				true,
  				"Luoghi");
  		Foto foto5 = new Foto("Siegessäule",
  				"La colonna della Vittoria è uno dei monumenti più celebri di Berlino. Si trova all'interno del parco del Tiergarten.",
  				"https://images.unsplash.com/photo-1696960594920-1ca9a1f250bc?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2186&q=80",
  				true,
  				"Monumenti");
  		
  		fotoServ.save(foto1);
  		fotoServ.save(foto2);
  		fotoServ.save(foto3);
  		fotoServ.save(foto4);
  		fotoServ.save(foto5);
  		
  		System.out.println("Insert OK");
	}
}
