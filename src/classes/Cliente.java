package classes;

import java.sql.Date;

public class Cliente extends Pessoa {

	public Cliente(int id, String primeiroNome, String ultimoNome, Date dataNascimento, String documento,
			String telefone, String email, Date dataCadastro, String endereco, int nmrEndereco, int codRegistro, int idCliente) {
		super(id, primeiroNome, ultimoNome, dataNascimento, documento, telefone, email, dataCadastro, endereco, nmrEndereco);
		this.codRegistro = codRegistro;
		this.idCliente = idCliente;
	}

	private int codRegistro;
	private int idCliente;
	
	public Cliente () {}
	

	public Cliente(String primeiroNome, String ultimoNome, int codRegistro) {
		super(primeiroNome, ultimoNome);
		this.codRegistro = codRegistro;
	}

	public int getCodRegistro() {
		return codRegistro;
	}

	public void setCodRegistro(int codRegistro) {
		this.codRegistro = codRegistro;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
