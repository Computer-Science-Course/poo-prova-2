package model.entities.cliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private List<Telefone> telefones = new ArrayList<>();
	// Create attribute List<locacao>
	
	public Integer getId() {
		return id;
	}
	public Cliente() {}
	
	public Cliente(
			Integer id, String nome, String cpf, String email, String telefone
	) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.addTelefone(telefone);
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void addTelefone(String telefone) {
		this.telefones.add(new Telefone(telefone));
	}
	
	
	
}
