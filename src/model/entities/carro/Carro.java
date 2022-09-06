package model.entities.carro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.entities.categoria.Categoria;
import model.entities.locacao.Locacao;
import model.enums.Cor;

public class Carro {
	private Integer id;
	private String modelo;
	private String placa;
	private	Cor cor;
	private Integer ano;
	private LocalDate dataAquisicao;
	private Categoria categoria;
	
	private List<Locacao> locacoes = new ArrayList<>();
	
	public Carro() {
		
	}

	public Carro(
			String modelo,
			String placa,
			Cor cor,
			Integer ano,
			LocalDate dataAquisicao,
			Categoria categoria
	) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.dataAquisicao = dataAquisicao;
		this.categoria = categoria;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void addLocacoes(Locacao locacao) {
		this.locacoes.add(locacao);
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return id + ", " + modelo + ", " + placa + ", " + cor + ", " + ano
				+ ", " + dataAquisicao.format(formatter) + ", " + categoria.getDescricao();
	}
	
		
	
}