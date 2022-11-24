package classes;

import java.sql.Date;

public class Funcionario extends Pessoa {

	private int codFuncionario;
	private int idFuncionario;
	
	public Funcionario () {}

	

	public Funcionario(int id, String primeiroNome, String ultimoNome, Date dataNascimento, String documento,
			String telefone, String email, Date dataCadastro, String endereco, int nmrEndereco, int codFuncionario, int idFuncionario) {
		super(id, primeiroNome, ultimoNome, dataNascimento, documento, telefone, email, dataCadastro, endereco,
				nmrEndereco);
		this.codFuncionario = codFuncionario;
		this.idFuncionario = idFuncionario;
	}

	public Funcionario(String primeiroNome, String ultimoNome, int codFuncionario) {
		super(primeiroNome, ultimoNome);
		this.codFuncionario = codFuncionario;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

}
