package classes;

import java.util.Date;

public class Cliente extends Pessoa {

	public Cliente(int id, String primeiroNome, String ultimoNome, Date dataNascimento, String documento,
			String telefone, String email, Date dataCadastro, String endereco, int nmrEndereco, int codRegistro) {
		super(id, primeiroNome, ultimoNome, dataNascimento, documento, telefone, email, dataCadastro, endereco, nmrEndereco);
		this.codRegistro = codRegistro;
	}

	private int codRegistro;

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

}
