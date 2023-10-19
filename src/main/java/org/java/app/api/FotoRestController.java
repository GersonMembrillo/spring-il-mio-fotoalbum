package org.java.app.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.java.app.Foto;
import org.java.app.FotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/fotos")
public class FotoRestController {

	@Autowired
	private FotoServ fotoServ;

	@GetMapping
	public ResponseEntity<List<FotoDTO>> getFoto(
			@RequestParam(required = false, name = "q") String query
		) {

		List<Foto> fotos = null;

		if (query == null) 
			fotos = fotoServ.findAll();
		else 
			fotos = fotoServ.findByTitle(query);

		// Nuovo codice
		List<FotoDTO> fotoDTOs = fotos.stream()
				.map(foto -> new FotoDTO(foto.getId(), foto.getTitle(), foto.getDescription(), foto.getPhoto(), foto.getVisibility(), foto.getCategories().stream()
						.map(c -> new CategoryDTO(c.getName()))
						.collect(Collectors.toList())))
				.collect(Collectors.toList());

		return new ResponseEntity<>(fotoDTOs, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Foto> getFotoById(
			@PathVariable int id
		) {

		Optional<Foto> optFoto = fotoServ.findById(id);

		if (optFoto.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(optFoto.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Foto> createFoto(
			@RequestBody FotoDTO fotoDto
		) {

		Foto foto = new Foto(fotoDto);
		foto = fotoServ.save(foto);

		return new ResponseEntity<>(foto, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Foto> updateFoto(
			@PathVariable int id,
			@RequestBody FotoDTO fotoDto
		) {

		Optional<Foto> optFoto = fotoServ.findById(id);

		if (optFoto.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		Foto foto = optFoto.get();
		foto.fillFromDto(fotoDto);

		foto = fotoServ.save(foto);

		return new ResponseEntity<>(foto, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteFoto(
			@PathVariable int id
		) {

		Optional<Foto> optFoto = fotoServ.findById(id);

		if (optFoto.isEmpty())
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

		Foto foto = optFoto.get();

		fotoServ.deleteFoto(foto);

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}