package classes;

import java.sql.Date;

public class Cliente extends Pessoa {

	public Cliente(int id, String nome, Date dataNascimento, String documento,
			String telefone, String email, Date dataCadastro, String endereco, int nmrEndereco, int codRegistro, int idCliente) {
		super(id, nome, dataNascimento, documento, telefone, email, dataCadastro, endereco, nmrEndereco);
		this.codRegistro = codRegistro;
		this.idCliente = idCliente;
	}

	private int codRegistro;
	private int idCliente;
	
	public Cliente () {}
	

	public Cliente(String nome, int codRegistro) {
		super(nome);
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
