package model.entities.locacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocacaoLongoPeriodo extends Locacao{
	private Double porcentagemDesconto;
	
	public LocacaoLongoPeriodo() {
		super();
	}

	public LocacaoLongoPeriodo(LocalDateTime dataRetirada, LocalDateTime dataDevolucao,Double porcentagemDesconto) {
		super(dataRetirada, dataDevolucao);
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatterWithHour = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(this.getId() + ", ");
		stringBuilder.append(this.getDataRetirada() != null ? this.getDataRetirada().format(formatterWithHour) + ", " : null + ", ");
		stringBuilder.append(this.getDataDevolucao() != null ? this.getDataDevolucao().format(formatterWithHour) + ", " : null + ", ");
		stringBuilder.append(this.getPorcentagemDesconto());
		
		return stringBuilder.toString();
	}
	
	
	
}
