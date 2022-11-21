package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Livro;
import connectionFactory.ConnectionFactory;

public class LivroDAO {

	public void adicionarLivro(Livro livro) {
		String sql = "INSERT INTO livro (titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setInt(3, livro.getAnoLancamento());
			stmt.setString(4, livro.getEditora());
			stmt.setString(5, livro.getEdicao());
			stmt.setInt(6, livro.getTempoReservaDias());

			stmt.execute();
			stmt.close();
			ConnectionFactory.getConnection().close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Livro buscarLivro(int id) {
		String sql = "select id_livro, titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias from livro where id_livro = "
				+ id;

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);

			rs.last();
			int numberRegisters = rs.getRow();
			rs.beforeFirst();

			if (numberRegisters > 0) {
				while (rs.next()) {
					return new Livro(rs.getInt("id_livro"), rs.getString("titulo"), rs.getString("autor"),
							rs.getInt("ano_lancamento"), rs.getString("editora"), rs.getString("edicao"), //
							rs.getInt("tempoReservaDias"));
				}
				System.out.println("");
			} else {
				System.out.println(String.format("- Without results for id %d -", id));
				return null;
			}
			stmt.close();
			ConnectionFactory.getConnection().close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void editarLivro(Livro livro) {
		String sql = "update livro set titulo = ?, autor = ?, ano_lancamento = ?, editora = ?, edicao = ?, "
				+ " tempoReservaDias = ? where id_livro = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setInt(3, livro.getAnoLancamento());
			stmt.setString(4, livro.getEditora());
			stmt.setString(5, livro.getEdicao());
			stmt.setInt(6, livro.getTempoReservaDias());
			stmt.setInt(7, livro.getId());

			stmt.execute();
			stmt.close();
			ConnectionFactory.getConnection().close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletarLivro(int id) {
		String sql = "delete from livro where id_livro = ?";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.execute();
			stmt.close();
			ConnectionFactory.getConnection().close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
