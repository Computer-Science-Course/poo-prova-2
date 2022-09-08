package model.entities.locacao;

import java.time.LocalDateTime;

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
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(this.getId() + ", ");
		stringBuilder.append(this.getDataRetirada() + ", ");
		stringBuilder.append(this.getDataDevolucao() + ", ");
		stringBuilder.append(this.getPorcentagemDesconto());
		
		return stringBuilder.toString();
	}
	
	
	
}
