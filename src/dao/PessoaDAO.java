package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import classes.Pessoa;
import connectionFactory.ConnectionFactory;

public class PessoaDAO {
	
		public void adicionarPessoa(Pessoa pessoa) {
			String sql = "INSERT INTO pessoa (primeiro_nome, ultimo_nome, data_nascimento, documento, telefone, e-amil, data_cadastro, endereco,numero_endereco) vaule (?,?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
				
				stmt.setString(1, pessoa.getPrimeiroNome());
				stmt.setString(2, pessoa.getUltimoNome());
				stmt.setDate(3, pessoa.getDataNascimento());
				stmt.setString(4, pessoa.getDocumento());
				stmt.setString(5, pessoa.getTelefone());
				stmt.setString(6, pessoa.getEmail());
				stmt.setDate(7, pessoa.getDataCadastro());
				stmt.setString(8, pessoa.getEndereco());
				stmt.setInt(9, pessoa.getNmrEndereco());
				
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
		public static Pessoa buscarPessoa(int id) {
			String sql = "select id_pessoa,primeiro_nome, ultimo_nome, data_nascimento, documento, telefone, e-amil, data_cadastro, endereco, numero_endereco from pessoa where id_pessoa = " + id;
			
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
		
		public void editarPessoa(Pessoa pessoa) {
			String sql = "update pessoa set primeiro_nome = ?, ultimo_nome = ?, data_nascimento = ?, documento = ?, telefone = ?, e-amil = ?, data_cadastro = ?, endereco = ?, numero_endereco =? where id_pessoa = ? ";
			
			try { 
				PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
				
				stmt.setString(1, pessoa.getPrimeiroNome());
				stmt.setString(2, pessoa.getUltimoNome());
				stmt.setDate(3, pessoa.getDataNascimento());
				stmt.setString(4, pessoa.getDocumento());
				stmt.setString(5, pessoa.getTelefone());
				stmt.setString(6, pessoa.getEmail());
				stmt.setDate(7, pessoa.getDataCadastro());
				stmt.setString(8, pessoa.getEndereco());
				stmt.setInt(9, pessoa.getNmrEndereco());
				
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
}
