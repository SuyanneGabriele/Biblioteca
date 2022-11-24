package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Revista;
import connectionFactory.ConnectionFactory;

public class RevistaDAO {

	public static boolean adicionarRevista(Revista revista) {
		String sql = "INSERT INTO revista (titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, revista.getTitulo());
			stmt.setString(2, revista.getAutor());
			stmt.setInt(3, revista.getAnoLancamento());
			stmt.setString(4, revista.getEditora());
			stmt.setString(5, revista.getEdicao());
			stmt.setInt(6, revista.getTempoReservaDias());

			if (stmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static Revista buscarRevista(int id) {
		String sql = "select id_revista, titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias from revista where id_revista = "
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
					return new Revista(rs.getInt("id_revista"), rs.getString("titulo"), rs.getString("autor"),
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

	public static boolean editarRevista(Revista revista) {
		String sql = "update revista set titulo = ?, autor = ?, ano_lancamento = ?, editora = ?, edicao = ?, "
				+ " tempoReservaDias = ? where id_revista = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, revista.getTitulo());
			stmt.setString(2, revista.getAutor());
			stmt.setInt(3, revista.getAnoLancamento());
			stmt.setString(4, revista.getEditora());
			stmt.setString(5, revista.getEdicao());
			stmt.setInt(6, revista.getTempoReservaDias());
			stmt.setInt(7, revista.getId());

			if (stmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean deletarRevista(int id) {
		String sql = "delete from revista where id_revista = ?";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setInt(1, id);

			if (stmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static Revista buscarUltimaRevistaInserida() {
		String sql = "select id_revista, titulo, autor, ano_lancamento, editora, edicao, tempoReservaDias from revista order by id_revista";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);

			rs.last();
			int numberRegisters = rs.getRow();
			rs.beforeFirst();

			if (numberRegisters > 0) {
				while (rs.next()) {
					return new Revista(rs.getInt("id_revista"), rs.getString("titulo"), rs.getString("autor"),
							rs.getInt("ano_lancamento"), rs.getString("editora"), rs.getString("edicao"), //
							rs.getInt("tempoReservaDias"));
				}
				System.out.println("");
			} else {
				System.out.println("Nenhuma revista encontrada");
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
}
