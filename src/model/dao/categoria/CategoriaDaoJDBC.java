package model.dao.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.cliente.TelefoneDaoJDBC;
import model.entities.categoria.Categoria;
import model.entities.cliente.Cliente;
import model.entities.cliente.Telefone;
import model.service.DataBase;
import model.service.DbException;

public class CategoriaDaoJDBC implements CategoriaDao{

	private Connection conn;
	
	public CategoriaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void criarCategoria(Categoria categoria) {
PreparedStatement statement = null;
		
		try {
			String query = "INSERT INTO categoria " +
					"(descricao, preco_diaria) " +
					"VALUES " +
					"(?, ?)";
			
			statement = conn.prepareStatement(
				query, 
				Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, categoria.getDescricao());
			statement.setDouble(2, categoria.getPrecoDiaria());

			statement.executeUpdate();
			
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}
		
	}

	@Override
	public List<Categoria> listarTodasCategorias() {
		
		List<Categoria> categorias = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM categoria ";
			
			Statement statement = conn.createStatement();
;
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Integer id = result.getInt("id");
				
				Categoria newCategory = new Categoria(
						result.getString("descricao"),
						result.getDouble("preco_diaria")
				);	
				newCategory.setId(id);	
				categorias.add(newCategory);
			}
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}
		return categorias;
	}

	@Override
	public Categoria pegarCategoria(Integer id) {
		
		try {
			String query = "SELECT * FROM categoria " +
					"WHERE id = " + id;
			
			Statement statement = conn.createStatement();
;
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Categoria categoria = new Categoria(
						result.getString("descricao"), result.getDouble("preco_diaria")
				);
				categoria.setId(result.getInt("id"));
				return categoria;
			}
		}
		catch (SQLException error) {
			throw new DbException(error.getMessage());
		}	
		
		return null;
	}

	@Override
	public void editarCategoria(Categoria categoria, Integer id) {
		
		PreparedStatement statement = null;
		
		try {			
			String query = "UPDATE categoria " +
					 "SET " +
					 "descricao =  ?, " +
					 "preco_diaria =  ?" +
					 "WHERE " +
					 "(id = " + id + ")";
			
			statement = conn.prepareStatement(query);
			statement.setString(1, categoria.getDescricao());
			statement.setDouble(2, categoria.getPrecoDiaria());
			
			statement.executeUpdate();			
		}
		catch (SQLException error) {
			error.printStackTrace();
		}
		
	}

	@Override
	public void excluirCategoria(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
