package model.entities.carro;

import java.time.LocalDate;

import model.enums.Cor;

public class Carro {
	private String modelo;
	private String placa;
	private	Cor cor;
	private Integer ano;
	private LocalDate dataAquisicao;
	
	public Carro() {
		
	}

	public Carro(String modelo, String placa, Cor cor, Integer ano, LocalDate dataAquisicao) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.dataAquisicao = dataAquisicao;
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
	
	
	
}