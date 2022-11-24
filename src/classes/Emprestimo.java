 package classes;

import java.sql.Date;

import enumeration.StatusEnum;

public class Emprestimo {

	private int id;
	private Cliente cliente;
	private Funcionario funcionario;
	private Acervo acervo;
	private Date dataInicio;
	private Date dataFim;
	private StatusEnum status;
	
	public Emprestimo(int id, Cliente cliente, Funcionario funcionario, Acervo acervo, Date dataInicio, Date dataFim,
			StatusEnum status) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.acervo = acervo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
	}
	
	public Emprestimo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Acervo getAcervo() {
		return acervo;
	}

	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
}