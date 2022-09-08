package model.dao.locacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.entities.categoria.Categoria;
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
		
		List<Locacao> locacoes = new ArrayList<>();
		DateTimeFormatter formatterWithHour = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		try {
			String query = "SELECT * FROM locacao ";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Integer id = result.getInt("id");
				if(result.getString("dias_previstos_devolucao") != null) {
					LocalDateTime data_devolucao = result.getString("data_devolucao") == null ?
							null : LocalDateTime.parse(result.getString("data_devolucao"), formatterWithHour);
					
					LocacaoDiaria newRent = new LocacaoDiaria(
						LocalDateTime.parse(result.getString("data_retirada"), formatterWithHour),	
						data_devolucao,
						result.getInt("dias_previstos_devolucao")
					);						
					newRent.setId(id);	
					locacoes.add(newRent);
				}else{
					LocalDateTime data_devolucao = result.getString("data_devolucao") == null ?
							null : LocalDateTime.parse(result.getString("data_devolucao"), formatterWithHour);
					
					LocacaoLongoPeriodo newRent = new LocacaoLongoPeriodo(
							LocalDateTime.parse(result.getString("data_retirada"), formatterWithHour),	
							data_devolucao,
							result.getDouble("porcentagem_desconto")
							);						
					newRent.setId(id);	
					locacoes.add(newRent);
				}
			}
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}
		return locacoes;
	}

	@Override
	public List<Locacao> listarTodasLocacoesPorCliente(Integer id_cliente) {
		
		List<Locacao> locacoes = new ArrayList<>();
		DateTimeFormatter formatterWithHour = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		try {
			String query = "SELECT * FROM locacao " +
							"WHERE id_cliente = " + id_cliente;
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Integer id = result.getInt("id");
				if(result.getString("dias_previstos_devolucao") != null) {
					LocalDateTime data_devolucao = result.getString("data_devolucao") == null ?
							null : LocalDateTime.parse(result.getString("data_devolucao"), formatterWithHour);
					
					LocacaoDiaria newRent = new LocacaoDiaria(
						LocalDateTime.parse(result.getString("data_retirada"), formatterWithHour),	
						data_devolucao,
						result.getInt("dias_previstos_devolucao")
					);						
					newRent.setId(id);	
					locacoes.add(newRent);
				}else{
					LocalDateTime data_devolucao = result.getString("data_devolucao") == null ?
							null : LocalDateTime.parse(result.getString("data_devolucao"), formatterWithHour);
					
					LocacaoLongoPeriodo newRent = new LocacaoLongoPeriodo(
							LocalDateTime.parse(result.getString("data_retirada"), formatterWithHour),	
							data_devolucao,
							result.getDouble("porcentagem_desconto")
							);						
					newRent.setId(id);	
					locacoes.add(newRent);
				}
			}
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}
		return locacoes;
	}

	@Override
	public void excluirLocacao(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
