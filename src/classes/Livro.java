package classes;

public class Livro extends Item {
	
	public Livro() {}

	public Livro(int id, String titulo, String autor, int anoLancamento, String editora, String edicao, int tempoReservaDias) {
		super(id, titulo, autor, anoLancamento, editora, edicao, tempoReservaDias);
	}

}
