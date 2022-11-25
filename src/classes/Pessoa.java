package classes;

import java.sql.Date;

public class Pessoa {

	private int id;
	private String nome;
	private Date dataNascimento;
	private String documento;
	private String telefone;
	private String email;
	private Date dataCadastro;
	private String endereco;
	private int nmrEndereco;
	
	public Pessoa () {}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public Pessoa(int id, String nome, Date dataNascimento, String documento,
			String telefone, String email, Date dataCadastro, String endereco, int nmrEndereco) {
		super();
		this.id = id;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
