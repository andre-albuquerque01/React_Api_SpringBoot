package df.senac.br.spring_mongodb.respositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import df.senac.br.spring_mongodb.model.Livro;

public interface LivroRepositorio extends MongoRepository<Livro, String> {

	List<Livro> findByPublicado(boolean publicado);

	List<Livro> findByTitulo(String titulo);

}
