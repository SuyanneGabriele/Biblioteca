package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Periodico;
import connectionFactory.ConnectionFactory;

public class PeriodicoDAO {

	public void adicionarPeriodico(Periodico periodico) {
		String sql = "INSERT INTO periodico (titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, periodico.getTitulo());
			stmt.setString(2, periodico.getAutor());
			stmt.setInt(3, periodico.getAnoLancamento());
			stmt.setString(4, periodico.getEditora());
			stmt.setString(5, periodico.getEdicao());
			stmt.setInt(6, periodico.getTempoReservaDias());

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

	public Periodico buscarPeriodico(int id) {
		String sql = "select id_periodico, titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias from periodico where id_periodico = "
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
					return new Periodico(rs.getInt("id_periodico"), rs.getString("titulo"), rs.getString("autor"),
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

	public void editarPeriodico(Periodico periodico) {
		String sql = "update periodico set titulo = ?, autor = ?, ano_lancamento = ?, editora = ?, edicao = ?, "
				+ " tempoReservaDias = ? where id_periodico = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, periodico.getTitulo());
			stmt.setString(2, periodico.getAutor());
			stmt.setInt(3, periodico.getAnoLancamento());
			stmt.setString(4, periodico.getEditora());
			stmt.setString(5, periodico.getEdicao());
			stmt.setInt(6, periodico.getTempoReservaDias());
			stmt.setInt(7, periodico.getId());

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

	public void deletarPeriodico(int id) {
		String sql = "delete from periodico where id_periodico = ?";

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
