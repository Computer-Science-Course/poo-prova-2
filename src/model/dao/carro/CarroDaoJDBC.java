package model.dao.carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dao.categoria.CategoriaDaoJDBC;
import model.entities.carro.Carro;
import model.enums.Cor;
import model.service.DataBase;
import model.service.DbException;

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
		
	}

	@Override
	public List<Carro> listarTodosCarros() {
		
		List<Carro> carros = new ArrayList<>();
		try {
			String query = "SELECT * FROM carro ";
			
			Statement statement = conn.createStatement();
;
			ResultSet result = statement.executeQuery(query);
			
			CategoriaDaoJDBC categoriaDao = new CategoriaDaoJDBC(conn);
			
			while(result.next()) {
				Carro newCar = new Carro(
						result.getString("modelo"), result.getString("placa"),
						Cor.valueOf(result.getString("cor")), result.getInt("ano"),
						LocalDate.parse(result.getString("data_aquisicao")),
						categoriaDao.pegarCategoria(result.getInt("id_categoria"))
					);
				newCar.setId(result.getInt("id"));
				
				carros.add(newCar);
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return carros;
	}

	@Override
	public List<Carro> listarCarrosPorCategoria(Integer id_categoria) {
		List<Carro> carros = new ArrayList<>();
		try {
			String query = "SELECT * FROM carro WHERE id_categoria = " + id_categoria;
			
			Statement statement = conn.createStatement();
;
			ResultSet result = statement.executeQuery(query);
			
			CategoriaDaoJDBC categoriaDao = new CategoriaDaoJDBC(conn);
			
			while(result.next()) {
				Carro newCar = new Carro(
						result.getString("modelo"), result.getString("placa"),
						Cor.valueOf(result.getString("cor")), result.getInt("ano"),
						LocalDate.parse(result.getString("data_aquisicao")),
						categoriaDao.pegarCategoria(result.getInt("id_categoria"))
					);
				newCar.setId(result.getInt("id"));
				
				carros.add(newCar);
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return carros;
	}

	@Override
	public void editarCarro(Integer id, Carro carro) {
		
		PreparedStatement statement = null;
		try {			
			String query = "UPDATE carro " +
					 "SET " +
					 "modelo =  ?, " +
					 "placa =  ?, " +
					 "cor =  ?, " +
					 "ano =  ?, " +
					 "data_aquisicao =  ?, " +
					 "id_categoria =  ? " +
					 "WHERE " +
					 "(id = " + id + ")";
			
			statement = conn.prepareStatement(query);
			statement.setString(1, carro.getModelo());
			statement.setString(2, carro.getPlaca());
			statement.setString(3, carro.getCor().name());
			statement.setInt(4, carro.getAno());
			statement.setTimestamp(5, Timestamp.valueOf(carro.getDataAquisicao().atStartOfDay()));
			statement.setInt(6, carro.getCategoria().getId());
			
			statement.executeUpdate();			
			
		}
		catch (SQLException error) {
			error.printStackTrace();
		}
		
	}

	@Override
	public void excluirCarro(Integer id) {
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DataBase.getConnection();
			
			String query = "DELETE FROM carro " +
							"WHERE " +
							"id = ?";
			statement = conn.prepareStatement(query);
			statement.setInt(1,2);
			
			statement.executeUpdate();
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}		
	}
	
	
}
