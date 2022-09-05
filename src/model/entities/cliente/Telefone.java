package model.entities.cliente;

public class Telefone {
	private String numero;

	public Telefone() {}
	
	public Telefone(String numero) {
		this.setNumero(numero);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
