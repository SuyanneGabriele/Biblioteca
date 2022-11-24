package classes;

public abstract class Item {

	private int id;
	private String titulo;
	private String autor;
	private int anoLancamento;
	private String editora;
	private String edicao;
	private int tempoReservaDias;
	
	public Item() {}

	public Item(int id, String titulo, String autor, int anoLancamento, String editora, String edicao,
			int tempoReservaDias) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anoLancamento = anoLancamento;
		this.editora = editora;
		this.edicao = edicao;
		this.tempoReservaDias = tempoReservaDias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public int getTempoReservaDias() {
		return tempoReservaDias;
	}

	public void setTempoReservaDias(int tempoReservaDias) {
		this.tempoReservaDias = tempoReservaDias;
	}

}
