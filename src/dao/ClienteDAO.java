package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Cliente;
import classes.Pessoa;
import connectionFactory.ConnectionFactory;

public class ClienteDAO {
	
	
	
	public void adicionarClient(Cliente cliente) {
		String sql = "INSERT INTO cliente (id_pessoa, cod_registro) vaule (?,?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setInt(1, cliente.getId());
			stmt.setInt(2, cliente.getCodRegistro());
			
			
			
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
	public Cliente buscarCliente(int id) {
		String sql = "select id_cliente, id_pessoa, cod_registro from cliente where id_cliente = " + id;
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			int numberRegisters = rs.getRow();
			rs.beforeFirst();
			
			if (numberRegisters > 0) {
				while (rs.next()){
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getInt("id_cliente")); 
					cliente.setCodRegistro(rs.getInt("cod_registro"));
					Pessoa pessoa = PessoaDAO.buscarPessoa(rs.getInt("id_pessoa"));
					cliente.setPrimeiroNome(pessoa.getPrimeiroNome());
					cliente.setUltimoNome(pessoa.getUltimoNome());
					cliente.setDataNascimento(pessoa.getDataNascimento());
					cliente.setDocumento(pessoa.getDocumento());
					cliente.setTelefone(pessoa.getTelefone());
					cliente.setDataCadastro(pessoa.getDataCadastro());
					cliente.setEndereco(pessoa.getEndereco());
					cliente.setNmrEndereco(pessoa.getNmrEndereco());
					
					
					return cliente;

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
	public void deletarCliente(int id) {
		String sql = "delete from cliente where id_cliente = ?";
		
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
