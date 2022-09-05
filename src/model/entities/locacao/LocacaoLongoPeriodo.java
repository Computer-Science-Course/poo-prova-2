package model.entities.locacao;

import java.time.LocalDateTime;

public class LocacaoLongoPeriodo extends Locacao{
	private Integer porcentagemDesconto;
	
	public LocacaoLongoPeriodo() {
		super();
	}

	public LocacaoLongoPeriodo(Integer id, LocalDateTime dataRetirada, LocalDateTime dataDevolucao,Integer porcentagemDesconto) {
		super();
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Integer getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Integer porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}
	
}
