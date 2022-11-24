package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Emprestimo;
import connectionFactory.ConnectionFactory;
import enumeration.StatusEnum;

public class EmprestimoDAO {

	public void adicionarEmprestimo(Emprestimo emprestimo) {
		String sql = "INSERT INTO emprestimo (id_cliente, id_funcionario, id_acervo, data_inicio, data_devolucao, status) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setInt(1, emprestimo.getCliente().getId());
			stmt.setInt(2, emprestimo.getFuncionario().getId());
			stmt.setInt(3, emprestimo.getAcervo().getId());
			stmt.setDate(4, emprestimo.getDataInicio());
			stmt.setDate(5, emprestimo.getDataFim());
			stmt.setString(6, emprestimo.getStatus().name());

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
		String sql = "select id_emprestimo, id_cliente, id_funcionario, id_acervo, data_inicio, data_devolucao, status from emprestimo where id_emprestimo = "
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
					Emprestimo emprestimo = new Emprestimo();
					emprestimo.setId(rs.getInt("id_emprestimo"));

//				rs.getInt("id_cliente");
//				rs.getInt("id_funcionario");

					AcervoDAO acervoDao = new AcervoDAO();
					emprestimo.setAcervo(acervoDao.buscarAcervo(rs.getInt("id_acervo")));

					emprestimo.setDataInicio(rs.getDate("data_inicio"));
					emprestimo.setDataFim(rs.getDate("data_devolucao"));
					emprestimo.setStatus(StatusEnum.valueOf(rs.getString("status")));

					return emprestimo;
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
		String sql = "update emprestimo set data_devolucao = ?, status = ? where id_emprestimo = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			stmt.setDate(1, emprestimo.getDataFim());
			stmt.setString(2, emprestimo.getStatus().name());
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
