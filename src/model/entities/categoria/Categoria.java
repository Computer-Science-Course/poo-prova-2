package model.entities.categoria;


public class Categoria {
	private Integer id;
	private String descricao;
	private Double precoDiaria;
	public Categoria() {
		
	}

	public Categoria(Integer id, String descricao, Double precoDiaria) {
		this.id = id;
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
