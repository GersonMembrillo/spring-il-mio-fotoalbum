package org.java.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoServ {

	@Autowired
	private FotoRepo fotoRepo;
	
	public Foto save(Foto foto) {
		
		return fotoRepo.save(foto);
	}
	public List<Foto> findAll() {
		
		return fotoRepo.findAll();
	}
	
	public List<Foto> findByTitle(String title) {

		return fotoRepo.findByTitleContaining(title);
	}
	public Optional<Foto> findById(int id) {
		
		return fotoRepo.findById(id);
	}
	
public void deleteFoto(Foto foto) {
		
		fotoRepo.delete(foto);
	}
	
}
