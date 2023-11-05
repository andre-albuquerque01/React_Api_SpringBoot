package df.senac.br.spring_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "livraria")
public class Livro {
	
	@Id
	private String id;
	private String titulo;
	private String descricao;
	private boolean publicado;
	
	public Livro() {		
	}

	public Livro(String titulo, String descricao, boolean publicado) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.publicado = publicado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", publicado=" + publicado + "]";
	}	
	

}
