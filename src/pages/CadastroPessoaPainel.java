package pages;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import classes.Pessoa;
import dao.PessoaDAO;
import dao.ClienteDAO;
import dao.FuncionarioDAO;
import enumeration.TipoItemEnum;
import enumeration.TipoPessoaEnum;

public class CadastroPessoaPainel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public CadastroPessoaPainel () {
		setBorder(new LineBorder(new Color(0,0,0),1, true));
		setBackground(new Color(51,0,0));
		setLayout(null);
		
		JLabel primeiroNomeLabel = new JLabel("Primeiro Nome");
		primeiroNomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		primeiroNomeLabel.setBounds(100,100,200, 20);
		add(primeiroNomeLabel);
		
		JTextField primeiroNomeTextField = new JTextField();
		primeiroNomeTextField.setBounds(100,100,200, 20);
		primeiroNomeTextField.setColumns(15);
		add(primeiroNomeTextField);
		
		JLabel ultimoNomeLabel = new JLabel("Sobrenome Nome");
		ultimoNomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ultimoNomeLabel.setBounds(400,100,200, 20);
		add(ultimoNomeLabel);
		
		JTextField ultimoNomeTextField = new JTextField();
		ultimoNomeTextField.setBounds(400,100,200, 20);
		ultimoNomeTextField.setColumns(15);
		add(ultimoNomeTextField);
		
		JLabel dataNascimentoLabel = new JLabel("Data de Nascimento");
		dataNascimentoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dataNascimentoLabel.setBounds(100,200,200, 20);
		add(dataNascimentoLabel);
		
		JTextField dataNascimentoTextField = new JTextField();
		dataNascimentoTextField.setBounds(100,200,200, 20);
		dataNascimentoTextField.setColumns(15);
		add(dataNascimentoTextField);
		
		
		JLabel documentoLabel = new JLabel("Documento");
		documentoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		documentoLabel.setBounds(100,300,200, 20);
		add(dataNascimentoLabel);
		
		JTextField documentoTextField = new JTextField();
		documentoTextField.setBounds(100,300,200, 20);
		documentoTextField.setColumns(15);
		add(documentoTextField);
		
		JLabel telefoneLabel = new JLabel("Telefone");
		telefoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		telefoneLabel.setBounds(400,300,200, 20);
		add(telefoneLabel);
		
		JTextField telefoneTextField = new JTextField();
		telefoneTextField.setBounds(400,300,200, 20);
		telefoneTextField.setColumns(15);
		add(telefoneTextField);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		emailLabel.setBounds(400,300,200, 20);
		add(emailLabel);
		
		JTextField emailTextField = new JTextField();
		emailTextField.setBounds(400,300,200, 20);
		emailTextField.setColumns(15);
		add(telefoneTextField);
		
		JLabel dataCadastroLabel = new JLabel("Data de Cadastro");
		dataCadastroLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dataCadastroLabel.setBounds(400,300,200, 20);
		add(dataCadastroLabel);
		
		JTextField dataCadastroTextField = new JTextField();
		dataCadastroTextField.setBounds(400,300,200, 20);
		dataCadastroTextField.setColumns(15);
		add(dataCadastroTextField);
		
		JLabel enderecoLabel = new JLabel("Endereço");
		enderecoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		enderecoLabel.setBounds(400,300,200, 20);
		add(enderecoLabel);
		
		JTextField enderecoTextField = new JTextField();
		enderecoTextField.setBounds(400,300,200, 20);
		enderecoTextField.setColumns(15);
		add(enderecoTextField);
		
		JLabel numEnderecoLabel = new JLabel("Numero do endereço");
		numEnderecoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		numEnderecoLabel.setBounds(400,300,200, 20);
		add(numEnderecoLabel);
		
		JTextField numEnderecoTextField = new JTextField();
		numEnderecoTextField.setBounds(400,300,200, 20);
		numEnderecoTextField.setColumns(15);
		add(numEnderecoTextField);
		
		JComboBox<TipoPessoaEnum> TipoPessoaComboBox = new JComboBox<TipoPessoaEnum>();
		TipoPessoaComboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		TipoPessoaComboBox.setModel(new DefaultComboBoxModel<TipoPessoaEnum>(TipoPessoaEnum.values()));
		TipoPessoaComboBox.setBounds(10, 269, 185, 21);
		add(TipoPessoaComboBox);
		
		JLabel tipoDadoLabel = new JLabel("Tipo de dado");
		tipoDadoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tipoDadoLabel.setBounds(10, 246, 119, 13);
		add(tipoDadoLabel);
		
		JCheckBox inserePessoaCheckBox = new JCheckBox("Inserir a Pessoa");
		inserePessoaCheckBox.setBackground(new Color(255, 255, 255));
		inserePessoaCheckBox.setBounds(227, 270, 143, 21);
		add(inserePessoaCheckBox);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSalvar.setBounds(10, 312, 85, 21);
		btnSalvar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
	
				if (TipoPessoaComboBox.getSelectedCliente().equals(TipoPessoaEnum.Cliente)) {
					Cliente Cliente = createCliente(primeiroNomeTextField.getText(), ultimoNomeTextField.getText(),
							dataNascimentoTextField.getText(), documentoTextField.getText(), telefoneTextField.getText(), emailTextField.getText(),
							dataCadastroTextField.getText(), enderecoTextField.getText(), numEnderecoTextField.getText());
	
					boolean registroCliente = ClienteDAO.adicionarCliente(cliente);
					informaUsuario(registroCliente, TipoPessoaEnum.Cliente);
					if (registroCliente && inserePessoaCheckBox.isSelected()) {
						inserirPessoaCliente();
					}
				} else if (TipoPessoaComboBox.getSelectedFuncionario().equals(TipoPessoaEnum.Funcionario)) {
					Funcionario funcionario = createFuncionario(primeiroNomeTextField.getText(), ultimoNomeTextField.getText(),
							dataNascimentoTextField.getText(), documentoTextField.getText(), telefoneTextField.getText(), emailTextField.getText(),
							dataCadastroTextField.getText(), enderecoTextField.getText(), numEnderecoTextField.getText());
	
					boolean registroFuncionario = FuncionarioDAO.adicionarFuncionario(funcionario);
					informaUsuario(registroFuncionario, TipoPessoaEnum.Funcionario);
					if (registroFuncionario && inserePessoaCheckBox.isSelected()) {
						inserirPessoaFuncionario();
					}
				} 
	
				limparCampos(primeiroNomeTextField, ultimoNomeTextField, dataNascimentoTextField, documentoTextField, telefoneTextField, 
						emailTextField,	dataCadastroTextField, enderecoTextField, numEnderecoTextField);
			}
		
		});
		add(btnSalvar);

				
	}
	public void limparCampos(JTextField primeiroNomeTextField, JTextField ultimoNomeTextField,
			JTextField dataNascimentoTextField, JTextField documentoTextField, JTextField telefoneTextField, 
			JTextField emailTextField, JTextField dataCadastroTextField, JTextField enderecoTextField, JTextField numEnderecoTextField) {
		primeiroNomeTextField.setText("");
		ultimoNomeTextField.setText("");
		dataNascimentoTextField.setText("");
		documentoTextField.setText("");
		telefoneTextField.setText("");
		emailTextField.setText("");
		dataCadastroTextField.setText("");
		enderecoTextField.setText("");
		numEnderecoTextField.setText("");
	}
	
	
	public void inserirPessoaCliente() {
		Cliente clienteInserido = ClienteDAO.buscarUltimoClienteInserido();
		if (clienteInserido != null) {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(clienteInserido.getId());
			pessoa.setTipoPessoa(TipoPessoaEnum.Cliente.toString());
			PessoaDAO.adicionarPessoa(pessoa);
		}
	}
	
	public void inserirPessoaFuncionario() {
		Funcionario funcionarioInserido = FuncionarioDAO.buscarUltimoFuncionarioInserido();
		if (funcionarioInserido != null) {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(clienteInserido.getId());
			pessoa.setTipoPessoa(TipoPessoaEnum.Funcionario.toString());
			PessoaDAO.adicionarPessoa(pessoa);
		}
	}
	
	private Pessoa createCliente(String primeiroNome, String ultimoNome, Date dataNascimento, String documento, String telefone, String email, 
			Date dataCadastro, String endereco, int numeroEndereco) {
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setPrimeiroNome(primeiroNome);
		pessoa.setUltimoNome(ultimoNome);
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setDocumento(documento);
		pessoa.setTelefone(telefone);
		pessoa.setEmail(email);
		pessoa.setDataCadastro(dataCadastro);
		pessoa.setEndereco(endereco);
		pessoa.setNmrEndereco(numeroEndereco);
		

		return pessoa;
	}
	
	public void inserirPessoa() {
		Pessoa pessoaInserido = PessoaDAO.buscarUltimaPessoaInserido();
		if (pessoaInserido != null) {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(pessoaInserido.getId());
			pessoa.adicionarPessoa(pessoa);
		}
	}
	
	public void informaUsuario(boolean resultado, TipoPessoaEnum tipoPessoaEnum) {
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Registro do tipo " + tipoPessoaEnum + " inserido com sucesso!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Registro do tipo " + tipoPessoaEnum + " não foi inserido.", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
