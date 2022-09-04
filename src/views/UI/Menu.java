package views.UI;

import java.util.Arrays;

public final class Menu {
	public final static UiMenu principal = new UiMenu(
			"Sistema de locação de carros:\nMenu principal",
			Arrays.asList("Categoria", "Carro", "Cliente", "Locação", "Sair")
	);
	
	public final static UiMenu categoria = new UiMenu(
			"Menu Categoria",
			Arrays.asList("Cadastrar", "Listar", "Editar", "Excluir", "Voltar")
	);
	
	public final static UiMenu carro = new UiMenu(
			"Menu Carro",
			Arrays.asList("Cadastrar", "Listar todos", "Listar por categoria", "Editar", "Excluir", "Voltar")
	);
	
	public final static UiMenu cliente = new UiMenu(
			"Menu Cliente",
			Arrays.asList("Cadastrar", "Listar", "Editar", "Excluir", "Voltar")
	);
	
	public final static UiMenu locacao = new UiMenu(
			"Menu Locação",
			Arrays.asList("Nova locação", "Devolução", "Listar todas", "Listar locação por cliente", "Excluir", "Voltar")
	);

	
	
}
