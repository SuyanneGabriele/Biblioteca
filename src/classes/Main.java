package classes;

import dao.LivroDAO;

public class Main {

	public static void main(String[] args) {
		LivroDAO dao = new LivroDAO();
		Livro livro = dao.buscarLivro(2);

		if (livro != null) {
			System.out.println(livro.getId());
			System.out.println(livro.getTitulo());
		}

//		Livro livro2 = new Livro(0, "harry potter 5", livro.getAutor(), livro.getAnoLancamento(), livro.getEditora(), livro.getEdicao(), livro.getTempoReservaDias());
//		dao.adicionarLivro(livro2);
		
//		livro.setTitulo("Harry Potter 1 editado 2 vezes");
//		dao.editarLivro(livro);
		
//		dao.deletarLivro(9);
		
	}

}
