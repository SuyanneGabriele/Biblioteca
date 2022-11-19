package classes;

import java.util.Date;

public class Funcionario extends Pessoa {

	private int codFuncionario;

	public Funcionario(int id, String primeiroNome, String ultimoNome, Date dataNascimento, String documento,
			String telefone, String email, Date dataCadastro, String endereco, int nmrEndereco, int codFuncionario) {
		super(id, primeiroNome, ultimoNome, dataNascimento, documento, telefone, email, dataCadastro, endereco,
				nmrEndereco);
		this.codFuncionario = codFuncionario;
	}

	public Funcionario(String primeiroNome, String ultimoNome, int codFuncionario) {
		super(primeiroNome, ultimoNome);
		this.codFuncionario = codFuncionario;
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

}
