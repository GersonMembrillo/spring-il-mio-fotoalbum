package org.java.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoServ {

	@Autowired
	private FotoRepo fotoRepo;
	
	public void save(Foto foto) {
		
		fotoRepo.save(foto);
	}
	public List<Foto> findAll() {
		
		return fotoRepo.findAll();
	}
	
	public List<Foto> findByTitle(String title) {

		return fotoRepo.findByTitleContaining(title);
	}
	public Foto findById(int id) {
		
		return fotoRepo.findById(id).get();
	}
	
public void deleteFoto(Foto foto) {
		
		fotoRepo.delete(foto);
	}
	
}
