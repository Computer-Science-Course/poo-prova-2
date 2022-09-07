package model.dao.locacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import model.entities.locacao.Locacao;
import model.entities.locacao.LocacaoDiaria;
import model.entities.locacao.LocacaoLongoPeriodo;
import model.service.DbException;

public class LocacaoDaoJDBC implements LocacaoDao{
	
	private Connection conn;
	
	public LocacaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void criarLocacaoDiaria(LocacaoDiaria locacao, Integer id_cliente, Integer id_carro) {
		
		PreparedStatement statement = null;
		
		try {
			String query = "INSERT INTO locacao " +
					"(data_retirada, data_devolucao, dias_previstos_devolucao, porcentagem_desconto, id_cliente, id_carro) " +
					"VALUES " +
					"(?, null, ?, null, ?, ?)";
			
			statement = conn.prepareStatement(
				query, 
			Statement.RETURN_GENERATED_KEYS);

			statement.setTimestamp(1, Timestamp.valueOf(locacao.getDataRetirada()));
			statement.setDouble(2, locacao.getDiasPrevistoDevolucao());
			statement.setDouble(3, id_cliente);
			statement.setDouble(4, id_carro);

			statement.executeUpdate();
			
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}
		
	}
	
	@Override
	public void criarLocacaoLongoPeriodo(LocacaoLongoPeriodo locacao, Integer id_cliente, Integer id_carro) {

		PreparedStatement statement = null;
		
		try {
			String query = "INSERT INTO locacao " +
					"(data_retirada, data_devolucao, dias_previstos_devolucao, porcentagem_desconto, id_cliente, id_carro) " +
					"VALUES " +
					"(?, null, null, ?, ?, ?)";
			
			statement = conn.prepareStatement(
				query, 
			Statement.RETURN_GENERATED_KEYS);
			statement.setTimestamp(1, Timestamp.valueOf(locacao.getDataRetirada()));
			statement.setDouble(2, locacao.getPorcentagemDesconto());
			statement.setDouble(3, id_cliente);
			statement.setDouble(4, id_carro);

			statement.executeUpdate();
			
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}
	}

	@Override
	public void devolverLocacao(Integer id, LocalDateTime dataDevolucao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Locacao> listarTodasLocacoes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Locacao> listarTodasLocacoesPorCliente(Integer id_cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirLocacao(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
