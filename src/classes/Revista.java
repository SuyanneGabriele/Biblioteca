package classes;

public class Revista extends Item {
	
	public Revista( ) {}

	public Revista(int id, String titulo, String autor, int anoLancamento, String editora, String edicao, int tempoReservaDias) {
		super(id, titulo, autor, anoLancamento, editora, edicao, tempoReservaDias);
	}

}
