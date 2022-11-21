package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Acervo;
import connectionFactory.ConnectionFactory;

public class AcervoDAO {

	public void adicionarAcervo(Acervo acervo) {
		String sql = "INSERT INTO acervo (tipoItem, id_item) values (?, ?)";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setString(1, acervo.getTipoItem());
			stmt.setInt(2, acervo.getIdItem());

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

	public Acervo buscarAcervo(int id) {
		String sql = "select id_acervo, id_item, tipo_item from acervo where id_acervo = "
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
					return new Acervo(rs.getInt("id_acervo"), rs.getString("tipo_item"), rs.getInt("id_item"));
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

	public void editarAcervo(Acervo acervo) {
		String sql = "update acervo set id_item = ?, tipo_item = ? where id_acervo = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setInt(1, acervo.getIdItem());
			stmt.setString(2, acervo.getTipoItem());
			stmt.setInt(3, acervo.getId());

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

	public void deletarAcervo(int id) {
		String sql = "delete from acervo where id_acervo = ?";

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
