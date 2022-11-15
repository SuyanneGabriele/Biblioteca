package classes;

public class Livro extends Item {

	private int tempoReservaDias;

	public Livro(int id, String titulo, String autor, int anoLancamento, String editora, String edicao,
			int tempoReservaDias) {
		super(id, titulo, autor, anoLancamento, editora, edicao);
		this.tempoReservaDias = tempoReservaDias;
	}

	public int getTempoReservaDias() {
		return tempoReservaDias;
	}

	public void setTempoReservaDias(int tempoReservaDias) {
		this.tempoReservaDias = tempoReservaDias;
	}

}
