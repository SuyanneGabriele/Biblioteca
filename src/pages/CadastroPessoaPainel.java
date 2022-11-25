package pages;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import classes.Livro;
import classes.Periodico;
import classes.Pessoa;
import classes.Revista;
import dao.LivroDAO;
import dao.PeriodicoDAO;
import dao.RevistaDAO;
import enumeration.TipoItemEnum;

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
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSalvar.setBounds(10, 312, 85, 21);
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (tipoItemComboBox.getSelectedItem().equals(TipoItemEnum.LIVRO)) {
					Livro livro = createLivro(tituloTextField.getText(), autorLabel.getText(),
							edicaoTextField.getText(), editoraTextField.getText(),
							Integer.parseInt(tempoReservaTextField.getText()),
							Integer.parseInt(anoLancamentoTextField.getText()));

					boolean registroInserido = LivroDAO.adicionarLivro(livro);
					informaUsuario(registroInserido, TipoItemEnum.LIVRO);
					if (registroInserido && insereAcervoCheckBox.isSelected()) {
						inserirLivroAcervo();
					}
				} else if (tipoItemComboBox.getSelectedItem().equals(TipoItemEnum.REVISTA)) {
					Revista revista = createRevista(tituloTextField.getText(), autorLabel.getText(),
							edicaoTextField.getText(), editoraTextField.getText(),
							Integer.parseInt(tempoReservaTextField.getText()),
							Integer.parseInt(anoLancamentoTextField.getText()));

					boolean registroInserido = RevistaDAO.adicionarRevista(revista);
					informaUsuario(registroInserido, TipoItemEnum.REVISTA);
					if (registroInserido && insereAcervoCheckBox.isSelected()) {
						inserirRevistaAcervo();
					}
				} else if (tipoItemComboBox.getSelectedItem().equals(TipoItemEnum.PERIODICO)) {
					Periodico periodico = createPeriodico(tituloTextField.getText(), autorLabel.getText(),
							edicaoTextField.getText(), editoraTextField.getText(),
							Integer.parseInt(tempoReservaTextField.getText()),
							Integer.parseInt(anoLancamentoTextField.getText()));

					boolean registroInserido = PeriodicoDAO.adicionarPeriodico(periodico);
					informaUsuario(registroInserido, TipoItemEnum.PERIODICO);
					if (registroInserido && insereAcervoCheckBox.isSelected()) {
						inserirPeriodicoAcervo();
					}
				}

				limparCampos(tituloTextField, anoLancamentoTextField, tempoReservaTextField, autorTextField,
						editoraTextField, //
						edicaoTextField);
			}
		});
		add(btnSalvar);
		
	}
	
	
	
	
	private Pessoa createPessoa(String primeiroNome, String ultimoNome, Date dataNascimento, String documento, String telefone, String email, 
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

}
