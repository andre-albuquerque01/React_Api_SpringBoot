package df.senac.br.spring_mongodb.respositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import df.senac.br.spring_mongodb.model.Autor;

public interface AutorRepositorio extends MongoRepository<Autor, String> {
	List<Autor> findByNome(String nome);

	List<Autor> findByAtivo(boolean ativo);
	
	List<Autor> findByEmail(String email);
}
