package model.dao.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.cliente.Cliente;
import model.entities.cliente.Telefone;
import model.service.DbException;

public class TelefoneDaoJDBC implements TelefoneDao{
	private Connection conn;
	
	public TelefoneDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Telefone> listarTodosTelefones(Integer id_cliente) {
		List<Telefone> telefones = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM telefone" +
							"WHERE id_cliente = " + id_cliente;
			
			Statement statement = conn.createStatement();
;
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Telefone newTelefone = new Telefone(
						result.getString("numero")
				);
				telefones.add(newTelefone);
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return telefones;
	}
}
