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

import df.senac.br.spring_mongodb.model.Livro;
import df.senac.br.spring_mongodb.respositorio.LivroRepositorio;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class LivroController {

	@Autowired
	LivroRepositorio livroRepositorio;

	@GetMapping("/livros")
	public ResponseEntity<List<Livro>> getAllLivros(@RequestParam(required = false) String titulo) {
		try {
			List<Livro> livros = new ArrayList<Livro>();

			if (titulo == null)
				livroRepositorio.findAll().forEach(livros::add);
			else
				livroRepositorio.findByTitulo(titulo).forEach(livros::add);

			if (livros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(livros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/livros/{id}")
	public ResponseEntity<Livro> getLivroById(@PathVariable("id") String id) {
		Optional<Livro> LivroData = livroRepositorio.findById(id);

		if (LivroData.isPresent()) {
			return new ResponseEntity<>(LivroData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/livros")
	public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
		try {
			Livro _livro = livroRepositorio.save(new Livro(livro.getTitulo(), livro.getDescricao(), false));
			return new ResponseEntity<>(_livro, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/livros/{id}")
	public ResponseEntity<Livro> updateLivro(@PathVariable("id") String id, @RequestBody Livro Livro) {
		Optional<Livro> LivroData = livroRepositorio.findById(id);

		if (LivroData.isPresent()) {
			Livro _Livro = LivroData.get();
			_Livro.setTitulo(Livro.getTitulo());
			_Livro.setDescricao(Livro.getDescricao());
			_Livro.setPublicado(Livro.isPublicado());
			return new ResponseEntity<>(livroRepositorio.save(_Livro), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/livros/{id}")
	public ResponseEntity<HttpStatus> deleteLivro(@PathVariable("id") String id) {
		try {
			livroRepositorio.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/livros")
	public ResponseEntity<HttpStatus> deleteAllLivros() {
		try {
			livroRepositorio.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/livros/publicado")
	public ResponseEntity<List<Livro>> findByPublicado() {
		try {
			List<Livro> Livros = livroRepositorio.findByPublicado(true);

			if (Livros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Livros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
