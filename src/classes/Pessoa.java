package classes;

import java.util.Date;

public abstract class Pessoa {

	private int id;
	private String primeiroNome;
	private String ultimoNome;
	private Date dataNascimento;
	private String documento;
	private String telefone;
	private String email;
	private Date dataCadastro;
	private String endereco;
	private int nmrEndereco;

	public Pessoa(String primeiroNome, String ultimoNome) {
		super();
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
	}

	public Pessoa(int id, String primeiroNome, String ultimoNome, Date dataNascimento, String documento,
			String telefone, String email, Date dataCadastro, String endereco, int nmrEndereco) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.dataNascimento = dataNascimento;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.endereco = endereco;
		this.nmrEndereco = nmrEndereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNmrEndereco() {
		return nmrEndereco;
	}

	public void setNmrEndereco(int nmrEndereco) {
		this.nmrEndereco = nmrEndereco;
	}
	
}
