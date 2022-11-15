package classes;

import java.util.Date;

public class Emprestimo {

	private int id;
	private Pessoa pessoa;
	private Acervo acervo;
	private Date dataInicio;
	private Date dataFim;
	private StatusEnum status;

	public Emprestimo(int id, Pessoa pessoa, Acervo acervo, Date dataInicio, Date dataFim, StatusEnum status) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.acervo = acervo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
