package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Funcionario;
import classes.Pessoa;
import connectionFactory.ConnectionFactory;

public class FuncionarioDAO {
	
	public void adicionarFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario (id_pessoa, cod_funcionario) vaule (?,?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setInt(1, funcionario.getId());
			stmt.setInt(2, funcionario.getCodFuncionario());
			
			
			
			stmt.execute();
			stmt.close();
			ConnectionFactory.getConnection().close();
			
		} catch(SQLException e) {
			System.out.println("SQLExeption: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendedorError: " + e.getErrorCode());
			
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}
	}
	public Funcionario buscarFuncionario(int id) {
		String sql = "select id_funcionario, id_pessoa, cod_funcionario from funcionario where id_funcionario = " + id;
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			int numberRegisters = rs.getRow();
			rs.beforeFirst();
			
			if (numberRegisters > 0) {
				while (rs.next()){
					Funcionario funcionario = new Funcionario();
					funcionario.setIdFuncionario(rs.getInt("id_funcionario")); 
					funcionario.setCodFuncionario(rs.getInt("cod_funcionario"));
					Pessoa pessoa = PessoaDAO.buscarPessoa(rs.getInt("id_pessoa"));
					funcionario.setNome(pessoa.getNome());
					funcionario.setDataNascimento(pessoa.getDataNascimento());
					funcionario.setDocumento(pessoa.getDocumento());
					funcionario.setTelefone(pessoa.getTelefone());
					funcionario.setDataCadastro(pessoa.getDataCadastro());
					funcionario.setEndereco(pessoa.getEndereco());
					funcionario.setNmrEndereco(pessoa.getNmrEndereco());
					
					
					return funcionario;

				}
				System.out.println("");
			} else {
				System.out.println(String.format("- Without results for id %d -"));
				return null;
			}
			stmt.close();
			ConnectionFactory.getConnection().close();
		}catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void deletarFuncionario(int id) {
		String sql = "delete from funcionario where id_funcionario = ?";
		
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
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
