package classes;

import dao.LivroDAO;

public class Main {

	public static void main(String[] args) {
		Livro livro = LivroDAO.buscarLivro(2);

		if (livro != null) {
			System.out.println(livro.getId());
			System.out.println(livro.getTitulo());
		}
//		
//		Livro livro2 = new Livro();
//		livro2.setTitulo("s");
//		livro2.setAutor("a");
//		livro2.setEdicao("a");
//		livro2.setEditora("a");
//		livro2.setTempoReservaDias(1);
//		livro2.setAnoLancamento(1);
//		
		Livro livro2 = new Livro(0, "harry potter 5", livro.getAutor(), livro.getAnoLancamento(), livro.getEditora(), livro.getEdicao(), livro.getTempoReservaDias());
boolean a = LivroDAO.adicionarLivro(livro2);
		
		if (a) {
			System.out.println("trueee");
		}

//		livro.setTitulo("Harry Potter 1 editado 2 vezes");
//		dao.editarLivro(livro);
		
//		dao.deletarLivro(9);
		
	}

}
