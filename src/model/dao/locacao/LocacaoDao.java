package model.dao.locacao;

import java.time.LocalDateTime;
import java.util.List;

import model.entities.locacao.Locacao;
import model.entities.locacao.LocacaoDiaria;
import model.entities.locacao.LocacaoLongoPeriodo;

public interface LocacaoDao {
	void criarLocacaoDiaria(LocacaoDiaria locacao, Integer id_cliente, Integer id_carro);
	void criarLocacaoLongoPeriodo(LocacaoLongoPeriodo locacao, Integer id_cliente, Integer id_carro);
	void devolverLocacao(Integer id, LocalDateTime dataDevolucao);
	List<Locacao> listarTodasLocacoes();
	List<Locacao> listarTodasLocacoesPorCliente(Integer id_cliente);
	void excluirLocacao(Integer id);
}
