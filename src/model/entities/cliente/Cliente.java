package model.entities.cliente;

import java.util.ArrayList;
import java.util.List;

import model.entities.locacao.Locacao;

public class Cliente {

	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private List<Telefone> telefones = new ArrayList<>();
	private List<Locacao> locacoes = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public Cliente() {}
	
	public Cliente(
			String nome, String cpf, String email, Telefone telefone
	) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		if(telefone != null) {
			this.addTelefone(telefone);			
		}
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
	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
	}
	public List<Locacao> getLocacoes() {
		return locacoes;
	}
	public void addLocacao(Locacao locacao) {
		this.locacoes.add(locacao);
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(this.id + ", " + this.nome + ", " + this.cpf + ", " + this.email + "\n");
		stringBuilder.append("Telefones:\n");
		for(Telefone telefone: this.getTelefones()) {
			stringBuilder.append("\t" + telefone.getNumero());
		}
		
		return stringBuilder.toString();
	}
	
	
	
}
