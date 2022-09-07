package model.entities.categoria;


public class Categoria {
	private Integer id;
	private String descricao;
	private Double precoDiaria;
	public Categoria() {
		
	}

	public Categoria(String descricao, Double precoDiaria) {
		this.descricao = descricao;
		this.precoDiaria = precoDiaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(Double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}
	
	
	
}
