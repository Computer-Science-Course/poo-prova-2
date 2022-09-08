package model.dao.factory;

import java.sql.Connection;

import model.dao.carro.CarroDao;
import model.dao.carro.CarroDaoJDBC;
import model.dao.categoria.CategoriaDao;
import model.dao.categoria.CategoriaDaoJDBC;
import model.dao.cliente.ClienteDao;
import model.dao.cliente.ClienteDaoJDBC;
import model.dao.locacao.LocacaoDao;
import model.dao.locacao.LocacaoDaoJDBC;
import model.service.DataBase;

public class DaoFactory {
	
	private static final Connection CONNECTION = DataBase.getConnection();
	
	public static CategoriaDao createCategoriaDao() {
		return new CategoriaDaoJDBC(CONNECTION);
	}
	
	public static CarroDao createCarroDao() {
		return new CarroDaoJDBC(CONNECTION);
	}
	
	public static LocacaoDao createLocacaoDao() {
		return new LocacaoDaoJDBC(CONNECTION);
	}
	
	public static ClienteDao createClienteDao() {
		return new ClienteDaoJDBC(CONNECTION);
	}
}
