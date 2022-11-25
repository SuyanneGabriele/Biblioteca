package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import classes.Pessoa;
import connectionFactory.ConnectionFactory;

public class PessoaDAO {
	
<<<<<<< HEAD
		public static boolean adicionarPessoa(Pessoa pessoa) {
			String sql = "INSERT INTO pessoa (primeiro_nome, ultimo_nome, data_nascimento, documento, telefone, e-amil, data_cadastro, endereco,numero_endereco) vaule (?,?,?,?,?,?,?,?)";
=======
		public void adicionarPessoa(Pessoa pessoa) {
			String sql = "INSERT INTO pessoa (nome, data_nascimento, documento, telefone, email, data_cadastro, endereco,numero_endereco) vaule (?,?,?,?,?,?,?,?)";
>>>>>>> 7854427a29c240be85906ab372b34072c7df7e1b
			
			try {
				PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
				
				stmt.setString(1, pessoa.getNome());
				stmt.setDate(2, pessoa.getDataNascimento());
				stmt.setString(3, pessoa.getDocumento());
				stmt.setString(4, pessoa.getTelefone());
				stmt.setString(5, pessoa.getEmail());
				stmt.setDate(6, pessoa.getDataCadastro());
				stmt.setString(7, pessoa.getEndereco());
				stmt.setInt(8, pessoa.getNmrEndereco());
				
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
			return false;
		}
		public static Pessoa buscarPessoa(int id) {
			String sql = "select id_pessoa, nome, data_nascimento, documento, telefone, email, data_cadastro, endereco, numero_endereco from pessoa where id_pessoa = " + id;
			
			try {
				PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql, 
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql);
				
				rs.last();
				int numberRegisters = rs.getRow();
				rs.beforeFirst();
				
				if (numberRegisters > 0) {
					while (rs.next()){
						return new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getDate("data_nascimento"),
								rs.getString("documento"), rs.getString("telefone"), rs.getString("email"), rs.getDate("data_cadastro"), rs.getString("endereco"), rs.getInt("numero_endereco"));
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
		
		public void editarPessoa(Pessoa pessoa) {
			String sql = "update pessoa set nome = ?, data_nascimento = ?, documento = ?, telefone = ?, email = ?, data_cadastro = ?, endereco = ?, numero_endereco =? where id_pessoa = ? ";
			
			try { 
				PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
				
				stmt.setString(1, pessoa.getNome());
				stmt.setDate(2, pessoa.getDataNascimento());
				stmt.setString(3, pessoa.getDocumento());
				stmt.setString(4, pessoa.getTelefone());
				stmt.setString(5, pessoa.getEmail());
				stmt.setDate(6, pessoa.getDataCadastro());
				stmt.setString(7, pessoa.getEndereco());
				stmt.setInt(8, pessoa.getNmrEndereco());
				
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
		
		public void deletarPessoa(int id) {
			String sql = "delete from pessoa where id_pessoa = ?";
			
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
		public static Pessoa buscarUltimaPessoaInserido() {
			String sql = "select id_pessoa,primeiro_nome, ultimo_nome, data_nascimento, documento, telefone, e-amil, data_cadastro, endereco, numero_endereco from pessoa order by id_pessoa desc ";
			try {
				PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql, 
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql);
				
				rs.last();
				int numberRegisters = rs.getRow();
				rs.beforeFirst();
				
				if (numberRegisters > 0) {
					while (rs.next()){
						return new Pessoa(rs.getInt("id_pessoa"), rs.getString("primeiro_nome"), rs.getString("ultimo_nome"), rs.getDate("data_nascimento"),
								rs.getString("documento"), rs.getString("telefone"), rs.getString("e-amil"), rs.getDate("data_cadastro"), rs.getString("endereco"), rs.getInt("numero_endereco"));
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
}
