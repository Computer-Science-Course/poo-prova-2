package model.entities.locacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	@Override
	public String toString() {
		DateTimeFormatter formatterWithHour = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(this.getId() + ", ");
		stringBuilder.append(this.getDataRetirada() != null ? this.getDataRetirada().format(formatterWithHour) + ", " : null + ", ");
		stringBuilder.append(this.getDataDevolucao() != null ? this.getDataDevolucao().format(formatterWithHour) + ", " : null + ", ");
		stringBuilder.append(this.getDiasPrevistoDevolucao());
		
		return stringBuilder.toString();
	}
}
