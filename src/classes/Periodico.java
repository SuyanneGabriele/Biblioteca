package classes;

public class Periodico extends Item {

	private int tempoReservaDias;

	public Periodico(int id, String titulo, String autor, int anoLancamento, String editora, String edicao,
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
