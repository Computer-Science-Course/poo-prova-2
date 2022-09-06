package model.dao.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entities.categoria.Categoria;
import model.service.DataBase;
import model.service.DbException;

public class CategoriaDaoJDBC implements CategoriaDao{

	private Connection conn;
	
	public CategoriaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void criarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categoria> listarTodasCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria pegarCategoria(Integer id) {
		
		try {
			String query = "SELECT id, descricao, preco_diaria FROM categoria " +
					"WHERE id = " + id;
			
			Statement statement = conn.createStatement();
;
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				return new Categoria(
						result.getInt("id"), result.getString("descricao"), result.getDouble("preco_diaria")
				);
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}	
		
		return null;
	}

	@Override
	public void editarCategoria(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirCategoria(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
