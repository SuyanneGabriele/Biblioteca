package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import classes.Acervo;
import classes.Cliente;
import classes.Emprestimo;
import classes.Funcionario;
import classes.Livro;
import classes.Periodico;
import classes.Revista;
import dao.AcervoDAO;
import dao.ClienteDAO;
import dao.EmprestimoDAO;
import dao.FuncionarioDAO;
import dao.LivroDAO;
import dao.PeriodicoDAO;
import dao.RevistaDAO;
import enumeration.StatusEnum;
import enumeration.TipoItemEnum;

public class CadastroEmprestimoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CadastroEmprestimoPanel() throws ParseException {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel cadastroEmprestimoPanel = new JPanel();
		cadastroEmprestimoPanel.setBounds(0, 0, 487, 300);
		add(cadastroEmprestimoPanel);
		cadastroEmprestimoPanel.setLayout(null);

		JPanel tituloPaginaPanel = new JPanel();
		tituloPaginaPanel.setBackground(new Color(0, 128, 255));
		tituloPaginaPanel.setBounds(0, 0, 472, 31);
		cadastroEmprestimoPanel.add(tituloPaginaPanel);

		JLabel cadastroEmprestimoLabel = new JLabel("Realizar empréstimo");
		cadastroEmprestimoLabel.setForeground(new Color(255, 255, 255));
		tituloPaginaPanel.add(cadastroEmprestimoLabel);
		cadastroEmprestimoLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JPanel formularioEdicaoPanel = new JPanel();
		formularioEdicaoPanel.setBackground(new Color(255, 255, 255));
		formularioEdicaoPanel.setBounds(0, 30, 472, 269);
		cadastroEmprestimoPanel.add(formularioEdicaoPanel);
		formularioEdicaoPanel.setLayout(null);

		JComboBox<TipoItemEnum> tipoItemEnumComboBox = new JComboBox<TipoItemEnum>();
		tipoItemEnumComboBox.setModel(new DefaultComboBoxModel<TipoItemEnum>(TipoItemEnum.values()));
		tipoItemEnumComboBox.setBounds(10, 27, 157, 21);
		formularioEdicaoPanel.add(tipoItemEnumComboBox);

		JLabel tipoItemLabel = new JLabel("Tipo do item");
		tipoItemLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tipoItemLabel.setBounds(10, 10, 85, 13);
		formularioEdicaoPanel.add(tipoItemLabel);

		JLabel idItemLabel = new JLabel("Insira o id do item");
		idItemLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		idItemLabel.setBounds(10, 58, 157, 13);
		formularioEdicaoPanel.add(idItemLabel);

		JTextField idItemTextField = new JTextField();
		idItemTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idItemTextField.setColumns(10);
		idItemTextField.setBounds(10, 73, 37, 19);
		formularioEdicaoPanel.add(idItemTextField);

		JLabel dataInicioLabel = new JLabel("Data inicio");
		dataInicioLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dataInicioLabel.setBounds(10, 190, 69, 13);
		formularioEdicaoPanel.add(dataInicioLabel);

		JLabel nomeClienteLabel = new JLabel("Nome cliente");
		nomeClienteLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nomeClienteLabel.setBounds(206, 58, 85, 13);
		formularioEdicaoPanel.add(nomeClienteLabel);

		JTextField nomeClienteTextField = new JTextField();
		nomeClienteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nomeClienteTextField.setColumns(10);
		nomeClienteTextField.setBounds(206, 73, 157, 19);
		formularioEdicaoPanel.add(nomeClienteTextField);

		JLabel idClienteLabel = new JLabel("Id do cliente");
		idClienteLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		idClienteLabel.setBounds(206, 10, 210, 13);
		formularioEdicaoPanel.add(idClienteLabel);

		JTextField idClienteTextField = new JTextField();
		idClienteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idClienteTextField.setColumns(10);
		idClienteTextField.setBounds(206, 25, 157, 19);
		formularioEdicaoPanel.add(idClienteTextField);

		JLabel idAcervoLabel = new JLabel("Id acervo");
		idAcervoLabel.setBounds(10, 102, 85, 13);
		formularioEdicaoPanel.add(idAcervoLabel);
		idAcervoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JTextField idAcervoTextField = new JTextField();
		idAcervoTextField.setBounds(10, 117, 157, 19);
		formularioEdicaoPanel.add(idAcervoTextField);
		idAcervoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idAcervoTextField.setColumns(10);

		JLabel dataFimLabel = new JLabel("Data fim");
		dataFimLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dataFimLabel.setBounds(98, 191, 69, 13);
		formularioEdicaoPanel.add(dataFimLabel);

		JLabel tituloLabel = new JLabel("Titulo");
		tituloLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tituloLabel.setBounds(10, 146, 85, 13);
		formularioEdicaoPanel.add(tituloLabel);

		JTextField tituloTextField = new JTextField();
		tituloTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tituloTextField.setColumns(10);
		tituloTextField.setBounds(10, 169, 157, 19);
		formularioEdicaoPanel.add(tituloTextField);

		JLabel nomeFuncionarioLabel = new JLabel("Nome funcionario");
		nomeFuncionarioLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nomeFuncionarioLabel.setBounds(206, 146, 157, 13);
		formularioEdicaoPanel.add(nomeFuncionarioLabel);

		JTextField nomeFuncionarioTextField = new JTextField();
		nomeFuncionarioTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nomeFuncionarioTextField.setColumns(10);
		nomeFuncionarioTextField.setBounds(206, 161, 157, 19);
		formularioEdicaoPanel.add(nomeFuncionarioTextField);

		JLabel idFuncionarioLabel = new JLabel("Id do funcionario");
		idFuncionarioLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		idFuncionarioLabel.setBounds(206, 102, 210, 13);
		formularioEdicaoPanel.add(idFuncionarioLabel);

		JTextField idFuncionarioTextField = new JTextField();
		idFuncionarioTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idFuncionarioTextField.setColumns(10);
		idFuncionarioTextField.setBounds(206, 117, 157, 19);
		formularioEdicaoPanel.add(idFuncionarioTextField);

		JTextField dataInicioTextField = new JTextField();
		dataInicioTextField.setToolTipText("yyyy/mm/dd");
		dataInicioTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dataInicioTextField.setColumns(10);
		dataInicioTextField.setBounds(10, 209, 78, 19);
		formularioEdicaoPanel.add(dataInicioTextField);

		JTextField dataFimTextField = new JTextField();
		dataFimTextField.setToolTipText("yyyy/mm/dd");
		dataFimTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dataFimTextField.setColumns(10);
		dataFimTextField.setBounds(89, 210, 78, 19);
		formularioEdicaoPanel.add(dataFimTextField);

		JButton salvarButton = new JButton("Salvar");
		salvarButton.setBackground(new Color(0, 128, 255));
		salvarButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		salvarButton.setBounds(10, 238, 85, 21);
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idClienteTextField.getText().equals("") || nomeClienteTextField.getText().equals("")
						|| idFuncionarioTextField.getText().equals("") || nomeFuncionarioTextField.getText().equals("")
						|| idItemTextField.getText().equals("") || tituloTextField.getText().equals("")
						|| idAcervoTextField.getText().equals("") || dataInicioTextField.getText().equals("")
						|| dataFimTextField.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Há campos em branco.", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					Emprestimo emprestimo = new Emprestimo();
					Acervo acervo = AcervoDAO.buscarAcervo(Integer.parseInt(idAcervoTextField.getText()));
					emprestimo.setAcervo(acervo);

					ClienteDAO clienteDAO = new ClienteDAO();
					Cliente cliente = clienteDAO.buscarCliente(Integer.parseInt(idClienteTextField.getText()));
					emprestimo.setCliente(cliente);

					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					Funcionario funcionario = funcionarioDAO
							.buscarFuncionario(Integer.parseInt(idFuncionarioTextField.getText()));
					emprestimo.setFuncionario(funcionario);

					try {
						emprestimo.setDataInicio(converteDataTextToMysql(dataInicioTextField.getText()));
						emprestimo.setDataFim(converteDataTextToMysql(dataFimTextField.getText()));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					emprestimo.setStatus(StatusEnum.NO_PRAZO);

					EmprestimoDAO.adicionarEmprestimo(emprestimo);
				}
			}
		});
		formularioEdicaoPanel.add(salvarButton);

		JButton buscarClienteButton = new JButton("Buscar");
		buscarClienteButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buscarClienteButton.setBackground(new Color(0, 128, 255));
		buscarClienteButton.setBounds(376, 26, 85, 21);
		buscarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idClienteTextField.getText().equals("")) {
					validateIdItemTextField(idClienteTextField);
				} else {
					ClienteDAO clienteDAO = new ClienteDAO();
					Cliente cliente = clienteDAO.buscarCliente(Integer.parseInt(idClienteTextField.getText()));

					if (cliente != null) {
						nomeClienteTextField.setText(cliente.getNome());
					} else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		formularioEdicaoPanel.add(buscarClienteButton);

		JButton buscarItemButton = new JButton("Buscar");
		buscarItemButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buscarItemButton.setBackground(new Color(0, 128, 255));
		buscarItemButton.setBounds(53, 72, 85, 21);
		buscarItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idItemTextField.getText().equals("")) {
					validateIdItemTextField(idItemTextField);
				} else {

					if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.LIVRO)) {
						Livro livro = LivroDAO.buscarLivro(Integer.parseInt(idItemTextField.getText()));
						if (livro != null) {
							Acervo acervo = AcervoDAO.buscarAcervoPorIdItemETipoDeItem(
									Integer.parseInt(idItemTextField.getText()), TipoItemEnum.LIVRO.toString());
							if (acervo == null) {
								JOptionPane.showMessageDialog(null, "Id do acervo não encontrado para esse item.", "Aviso",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								idAcervoTextField.setText(String.valueOf(acervo.getId()));
								tituloTextField.setText(livro.getTitulo());
							}
						}
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.REVISTA)) {
						Revista revista = RevistaDAO.buscarRevista(Integer.parseInt(idItemTextField.getText()));
						if (revista != null) {
							Acervo acervo = AcervoDAO.buscarAcervoPorIdItemETipoDeItem(
									Integer.parseInt(idItemTextField.getText()), TipoItemEnum.REVISTA.toString());
							if (acervo == null) {
								JOptionPane.showMessageDialog(null, "Id do acervo não encontrado para esse item.", "Aviso",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								idAcervoTextField.setText(String.valueOf(acervo.getId()));
								tituloTextField.setText(revista.getTitulo());
							}
						}
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.PERIODICO)) {
						Periodico periodico = PeriodicoDAO.buscarPeriodico(Integer.parseInt(idItemTextField.getText()));
						if (periodico != null) {
							Acervo acervo = AcervoDAO.buscarAcervoPorIdItemETipoDeItem(
									Integer.parseInt(idItemTextField.getText()), TipoItemEnum.PERIODICO.toString());
							if (acervo == null) {
								JOptionPane.showMessageDialog(null, "Id do acervo não encontrado para esse item.", "Aviso",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								idAcervoTextField.setText(String.valueOf(acervo.getId()));
								tituloTextField.setText(periodico.getTitulo());
							}
						}
					}
				}
			}
		});
		formularioEdicaoPanel.add(buscarItemButton);

		JButton buscarFuncionarioButton = new JButton("Buscar");
		buscarFuncionarioButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buscarFuncionarioButton.setBackground(new Color(0, 128, 255));
		buscarFuncionarioButton.setBounds(376, 114, 85, 21);
		buscarFuncionarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idFuncionarioTextField.getText().equals("")) {
					validateIdItemTextField(idClienteTextField);
				} else {
					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					Funcionario funcionario = funcionarioDAO
							.buscarFuncionario(Integer.parseInt(idFuncionarioTextField.getText()));
					if (funcionario != null) {
						nomeFuncionarioTextField.setText(funcionario.getNome());
					} else {
						JOptionPane.showMessageDialog(null, "Funcionario não encontrado.", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		formularioEdicaoPanel.add(buscarFuncionarioButton);
	}

	public void validateIdItemTextField(JTextField idItemTextField) {
		JOptionPane.showMessageDialog(null, "Nenhum item foi selecionado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	public void limparCampos(JTextField tituloTextField, JTextField anoLancamentoTextField,
			JTextField tempoReservaTextField, JTextField autorTextField, JTextField editoraTextField, //
			JTextField edicaoTextField, JTextField idItemTextField) {
		tituloTextField.setText("");
		anoLancamentoTextField.setText("");
		tempoReservaTextField.setText("");
		autorTextField.setText("");
		editoraTextField.setText("");
		edicaoTextField.setText("");
		idItemTextField.setText("");
	}

	public void informaUsuario(boolean resultado, TipoItemEnum tipoItemEnum) {
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Registro do tipo " + tipoItemEnum + " editado com sucesso!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Registro do tipo " + tipoItemEnum + " não foi editado.", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void informaUsuarioExclusao(boolean resultado, TipoItemEnum tipoItemEnum) {
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Registro do tipo " + tipoItemEnum + " excluido com sucesso!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro do tipo " + tipoItemEnum + ".",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public Date converteDataTextToMysql(String data) throws ParseException {
		return Date.valueOf(data);
	}
}
