package model.dao.carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import model.entities.carro.Carro;
import model.service.DbException;
import model.service.DataBase;

public class CarroDaoJDBC implements CarroDao{
	private Connection conn;
	
	public CarroDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void criarCarro(Carro carro) {
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(
				"INSERT INTO carro " +
				"(modelo, placa, cor, ano, data_aquisicao, id_categoria) " +
				"VALUES " +
				"(?, ?, ?, ?, ?, ?)", 
				Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, carro.getModelo());
			statement.setString(2, carro.getPlaca());
			statement.setString(3, carro.getCor().name());
			statement.setInt(4, carro.getAno());
			statement.setTimestamp(5, Timestamp.valueOf(carro.getDataAquisicao().atStartOfDay()));
			statement.setInt(6, carro.getCategoria().getId());

			int rowsAffected = statement.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet result = statement.getGeneratedKeys();
				if (result.next()) {
					int id = result.getInt(1);
					carro.setId(id);
				}
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma linha foi afetada!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DataBase.closeStatement(statement);
		}
		
	}

	@Override
	public List<Carro> listarTodosCarros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carro> listarCarrosPorCategoria(Integer id_categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editarCarro(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirCarro(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
