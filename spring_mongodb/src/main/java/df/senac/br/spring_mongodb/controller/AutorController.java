package df.senac.br.spring_mongodb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import df.senac.br.spring_mongodb.model.Autor;
import df.senac.br.spring_mongodb.respositorio.AutorRepositorio;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class AutorController {

	@Autowired
	AutorRepositorio autorRepositorio;
	
	@GetMapping("/autor")
	public ResponseEntity<List<Autor>> getAllAutor(@RequestParam(required = false) String nome){
		try {
			List<Autor> autors = new ArrayList<Autor>();
			if (nome == null)
				autorRepositorio.findAll().forEach(autors::add);
			else
				autorRepositorio.findByNome(nome).forEach(autors::add);

			if (autors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(autors, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/autor/{id}")
	public ResponseEntity<Autor> getAutorById(@PathVariable("id") String id) {
		Optional<Autor> AutorData = autorRepositorio.findById(id);

		if (AutorData.isPresent()) {
			return new ResponseEntity<>(AutorData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/autor")
	public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
		try {
			Autor _autor = autorRepositorio.save(new Autor(autor.getNome(), autor.getSobrenome(), autor.getEmail(), autor.getTelefone(), autor.isAtivo()));
			return new ResponseEntity<>(_autor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/autor/{id}")
	public ResponseEntity<Autor> updateAutor(@PathVariable("id") String id, @RequestBody Autor autor) {
	    Optional<Autor> AutorData = autorRepositorio.findById(id);

	    if (AutorData.isPresent()) {
	        Autor _Autor = AutorData.get();
	        _Autor.setNome(autor.getNome());
	        _Autor.setSobrenome(autor.getSobrenome());
	        _Autor.setEmail(autor.getEmail());
	        _Autor.setTelefone(autor.getTelefone());
	        _Autor.setAtivo(autor.isAtivo());
	        return new ResponseEntity<>(autorRepositorio.save(_Autor), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	
	@DeleteMapping("/autor/{id}")
	public ResponseEntity<HttpStatus> deleteAutor(@PathVariable("id") String id) {
		try {
			autorRepositorio.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/autor")
	public ResponseEntity<HttpStatus> deleteAllAutor() {
		try {
			autorRepositorio.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/autor/nome")
	public ResponseEntity<List<Autor>> findByNome(@RequestParam("nome") String nome) {
		try {
			List<Autor> Autors = autorRepositorio.findByNome(nome);

			if (Autors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Autors, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/autor/ativo")
//	public ResponseEntity<List<Autor>> findByAtivo() {
//		try {
//			List<Autor> Autors= autorRepositorio.findByAtivo(true);
//
//			if (Autors.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(Autors, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@GetMapping("/autor/email")
//	public ResponseEntity<List<Autor>> findByEmail(@PathVariable("email") String email) {
//		try {
//			List<Autor> Autors = autorRepositorio.findByEmail(email);
//
//			if (Autors.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(Autors, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
