package model.entities.locacao;

import java.time.LocalDateTime;

public class LocacaoDiaria extends Locacao{
	private Integer diasPrevistoDevolucao;
	
	public LocacaoDiaria() {
		super();
	}

	public LocacaoDiaria(LocalDateTime dataRetirada, LocalDateTime dataDevolucao,Integer diasPrevistoDevolucao) {
		super(dataRetirada, dataDevolucao);
		this.diasPrevistoDevolucao = diasPrevistoDevolucao;
	}

	public Integer getDiasPrevistoDevolucao() {
		return diasPrevistoDevolucao;
	}

	public void setDiasPrevistoDevolucao(Integer diasPrevistoDevolucao) {
		this.diasPrevistoDevolucao = diasPrevistoDevolucao;
	}
	
	
	
}
