package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Emprestimo;
import connectionFactory.ConnectionFactory;

public class EmprestimoDAO {
	

	public void adicionarEmprestimo(Emprestimo emprestimo) {
		String sql = "INSERT INTO emprestimo (titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, emprestimo.getTitulo());
			stmt.setString(2, emprestimo.getAutor());
			stmt.setInt(3, emprestimo.getAnoLancamento());
			stmt.setString(4, emprestimo.getEditora());
			stmt.setString(5, emprestimo.getEdicao());
			stmt.setInt(6, emprestimo.getTempoReservaDias());

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

	public Emprestimo buscarEmprestimo(int id) {
		String sql = "select id_emprestimo, titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias from emprestimo where id_emprestimo = "
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
					return new Emprestimo(rs.getInt("id_emprestimo"), rs.getString("titulo"), rs.getString("autor"),
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

	public void editarEmprestimo(Emprestimo emprestimo) {
		String sql = "update emprestimo set titulo = ?, autor = ?, ano_lancamento = ?, editora = ?, edicao = ?, "
				+ " tempoReservaDias = ? where id_emprestimo = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, emprestimo.getTitulo());
			stmt.setString(2, emprestimo.getAutor());
			stmt.setInt(3, emprestimo.getAnoLancamento());
			stmt.setString(4, emprestimo.getEditora());
			stmt.setString(5, emprestimo.getEdicao());
			stmt.setInt(6, emprestimo.getTempoReservaDias());
			stmt.setInt(7, emprestimo.getId());

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

	public void deletarEmprestimo(int id) {
		String sql = "delete from emprestimo where id_emprestimo = ?";

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
