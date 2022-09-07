package model.entities.locacao;

import java.time.LocalDateTime;

public class Locacao {
	private Integer id;
	private LocalDateTime dataRetirada;
	private LocalDateTime dataDevolucao;
	
	public Locacao() {
		
	}	

	public Locacao(LocalDateTime dataRetirada, LocalDateTime dataDevolucao) {
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	
	
}
