package df.senac.br.spring_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "autores")
public class Autor {

	@Id
	private String id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private boolean ativo;

	public Autor() {
	}

	public Autor(String nome, String sobrenome, String email, String telefone, boolean ativo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.ativo = ativo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", telefone="
				+ telefone + ", ativo=" + ativo + "]";
	}

}
