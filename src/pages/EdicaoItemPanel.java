package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import classes.Livro;
import classes.Periodico;
import classes.Revista;
import dao.LivroDAO;
import dao.PeriodicoDAO;
import dao.RevistaDAO;
import enumeration.TipoItemEnum;

public class EdicaoItemPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public EdicaoItemPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel edicaoItemPanel = new JPanel();
		edicaoItemPanel.setBounds(0, 0, 472, 252);
		add(edicaoItemPanel);
		edicaoItemPanel.setLayout(null);

		JPanel tituloPaginaPanel = new JPanel();
		tituloPaginaPanel.setBackground(new Color(0, 128, 255));
		tituloPaginaPanel.setBounds(0, 0, 472, 31);
		edicaoItemPanel.add(tituloPaginaPanel);

		JLabel edicaoItemLabel = new JLabel("Edição de Item");
		edicaoItemLabel.setForeground(new Color(255, 255, 255));
		tituloPaginaPanel.add(edicaoItemLabel);
		edicaoItemLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JPanel formularioEdicaoPanel = new JPanel();
		formularioEdicaoPanel.setBackground(new Color(255, 255, 255));
		formularioEdicaoPanel.setBounds(0, 30, 472, 222);
		edicaoItemPanel.add(formularioEdicaoPanel);
		formularioEdicaoPanel.setLayout(null);

		JComboBox<TipoItemEnum> tipoItemEnumComboBox = new JComboBox<TipoItemEnum>();
		tipoItemEnumComboBox.setModel(new DefaultComboBoxModel<TipoItemEnum>(TipoItemEnum.values()));
		tipoItemEnumComboBox.setBounds(10, 27, 157, 21);
		formularioEdicaoPanel.add(tipoItemEnumComboBox);

		JLabel tipoItemLabel = new JLabel("Tipo do item");
		tipoItemLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tipoItemLabel.setBounds(10, 10, 85, 13);
		formularioEdicaoPanel.add(tipoItemLabel);

		JLabel tituloLabel = new JLabel("Titulo");
		tituloLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tituloLabel.setBounds(10, 58, 85, 13);
		formularioEdicaoPanel.add(tituloLabel);

		JTextField tituloTextField = new JTextField();
		tituloTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tituloTextField.setBounds(10, 73, 157, 19);
		formularioEdicaoPanel.add(tituloTextField);
		tituloTextField.setColumns(10);

		JLabel anoLancamentoLabel = new JLabel("Ano lançamento");
		anoLancamentoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		anoLancamentoLabel.setBounds(10, 102, 157, 13);
		formularioEdicaoPanel.add(anoLancamentoLabel);

		JTextField anoLancamentoTextField = new JTextField();
		anoLancamentoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		anoLancamentoTextField.setColumns(10);
		anoLancamentoTextField.setBounds(10, 117, 157, 19);
		formularioEdicaoPanel.add(anoLancamentoTextField);

		JLabel tempoReservaLabel = new JLabel("Tempo reserva em dias");
		tempoReservaLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tempoReservaLabel.setBounds(10, 146, 157, 13);
		formularioEdicaoPanel.add(tempoReservaLabel);

		JTextField tempoReservaTextField = new JTextField();
		tempoReservaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tempoReservaTextField.setColumns(10);
		tempoReservaTextField.setBounds(10, 161, 157, 19);
		formularioEdicaoPanel.add(tempoReservaTextField);

		JLabel autorLabel = new JLabel("Autor");
		autorLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		autorLabel.setBounds(206, 58, 85, 13);
		formularioEdicaoPanel.add(autorLabel);

		JTextField autorTextField = new JTextField();
		autorTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		autorTextField.setColumns(10);
		autorTextField.setBounds(206, 73, 157, 19);
		formularioEdicaoPanel.add(autorTextField);

		JLabel editoraLabel = new JLabel("Editora");
		editoraLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		editoraLabel.setBounds(206, 102, 85, 13);
		formularioEdicaoPanel.add(editoraLabel);

		JTextField editoraTextField = new JTextField();
		editoraTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		editoraTextField.setColumns(10);
		editoraTextField.setBounds(206, 117, 157, 19);
		formularioEdicaoPanel.add(editoraTextField);

		JLabel edicaoLabel = new JLabel("Edição");
		edicaoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		edicaoLabel.setBounds(206, 146, 85, 13);
		formularioEdicaoPanel.add(edicaoLabel);

		JTextField edicaoTextField = new JTextField();
		edicaoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		edicaoTextField.setColumns(10);
		edicaoTextField.setBounds(206, 161, 157, 19);
		formularioEdicaoPanel.add(edicaoTextField);

		JLabel idItemLabel = new JLabel("Insira o id do item a ser editado");
		idItemLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		idItemLabel.setBounds(206, 10, 210, 13);
		formularioEdicaoPanel.add(idItemLabel);

		JTextField idItemTextField = new JTextField();
		idItemTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idItemTextField.setColumns(10);
		idItemTextField.setBounds(206, 25, 157, 19);
		formularioEdicaoPanel.add(idItemTextField);

		JButton salvarButton = new JButton("Salvar");
		salvarButton.setBackground(new Color(0, 128, 255));
		salvarButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		salvarButton.setBounds(10, 191, 85, 21);
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tituloTextField.getText().equals("") || autorLabel.getText().equals("") || //
						edicaoTextField.getText().equals("") || editoraTextField.getText().equals("") || //
						tempoReservaTextField.getText().equals("") || anoLancamentoTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Há campos em branco.", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.LIVRO)) {
						Livro livro = createLivro(tituloTextField.getText(), autorLabel.getText(),
								edicaoTextField.getText(), editoraTextField.getText(),
								Integer.parseInt(tempoReservaTextField.getText()),
								Integer.parseInt(anoLancamentoTextField.getText()));

						boolean registroEditado = LivroDAO.editarLivro(livro);
						informaUsuario(registroEditado, TipoItemEnum.LIVRO);
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.REVISTA)) {
						Revista revista = createRevista(tituloTextField.getText(), autorLabel.getText(),
								edicaoTextField.getText(), editoraTextField.getText(),
								Integer.parseInt(tempoReservaTextField.getText()),
								Integer.parseInt(anoLancamentoTextField.getText()));

						boolean registroEditado = RevistaDAO.editarRevista(revista);
						informaUsuario(registroEditado, TipoItemEnum.REVISTA);
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.PERIODICO)) {
						Periodico periodico = createPeriodico(tituloTextField.getText(), autorLabel.getText(),
								edicaoTextField.getText(), editoraTextField.getText(),
								Integer.parseInt(tempoReservaTextField.getText()),
								Integer.parseInt(anoLancamentoTextField.getText()));

						boolean registroEditado = PeriodicoDAO.editarPeriodico(periodico);
						informaUsuario(registroEditado, TipoItemEnum.PERIODICO);
					}

					limparCampos(tituloTextField, anoLancamentoTextField, tempoReservaTextField, autorTextField,
							editoraTextField, //
							edicaoTextField, idItemTextField);
				}
			}
		});
		formularioEdicaoPanel.add(salvarButton);

		JButton removerDoAcervoButton = new JButton("Remover do acervo");
		removerDoAcervoButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		removerDoAcervoButton.setBackground(new Color(255, 0, 0));
		removerDoAcervoButton.setBounds(206, 191, 163, 21);
		removerDoAcervoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!idItemTextField.getText().equals("")) {
					validateIdItemTextField(idItemTextField);
				} else {
					if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.LIVRO)) {
						Livro livro = LivroDAO.buscarLivro(Integer.parseInt(idItemTextField.getText()));
						boolean registroEditado = LivroDAO.editarLivro(livro);
						informaUsuario(registroEditado, TipoItemEnum.LIVRO);
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.REVISTA)) {
						Revista revista = createRevista(tituloTextField.getText(), autorLabel.getText(),
								edicaoTextField.getText(), editoraTextField.getText(),
								Integer.parseInt(tempoReservaTextField.getText()),
								Integer.parseInt(anoLancamentoTextField.getText()));

						boolean registroEditado = RevistaDAO.editarRevista(revista);
						informaUsuario(registroEditado, TipoItemEnum.REVISTA);
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.PERIODICO)) {
						Periodico periodico = createPeriodico(tituloTextField.getText(), autorLabel.getText(),
								edicaoTextField.getText(), editoraTextField.getText(),
								Integer.parseInt(tempoReservaTextField.getText()),
								Integer.parseInt(anoLancamentoTextField.getText()));

						boolean registroEditado = PeriodicoDAO.editarPeriodico(periodico);
						informaUsuario(registroEditado, TipoItemEnum.PERIODICO);
					}

					limparCampos(tituloTextField, anoLancamentoTextField, tempoReservaTextField, autorTextField,
							editoraTextField, //
							edicaoTextField, idItemTextField);
				}
			}

		});
		formularioEdicaoPanel.add(removerDoAcervoButton);

		JButton apagarItem = new JButton("Excluir");
		apagarItem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		apagarItem.setBackground(new Color(255, 0, 0));
		apagarItem.setBounds(105, 191, 85, 21);
		apagarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idItemTextField.getText().equals("")) {
					validateIdItemTextField(idItemTextField);
				} else {
					if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.LIVRO)) {
						informaUsuario(LivroDAO.deletarLivro(Integer.parseInt(idItemTextField.getText())),
								TipoItemEnum.LIVRO);
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.REVISTA)) {
						informaUsuario(RevistaDAO.deletarRevista(Integer.parseInt(idItemTextField.getText())),
								TipoItemEnum.REVISTA);
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.PERIODICO)) {
						informaUsuario(PeriodicoDAO.deletarPeriodico(Integer.parseInt(idItemTextField.getText())),
								TipoItemEnum.PERIODICO);
					}

				}
			}
		});
		formularioEdicaoPanel.add(apagarItem);

		JButton buscarItemButton = new JButton("Buscar");
		buscarItemButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buscarItemButton.setBackground(new Color(0, 128, 255));
		buscarItemButton.setBounds(376, 26, 85, 21);
		buscarItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idItemTextField.getText().equals("")) {
					validateIdItemTextField(idItemTextField);
				} else {

					if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.LIVRO)) {
						Livro livro = LivroDAO.buscarLivro(Integer.parseInt(idItemTextField.getText()));

						if (livro != null) {
							tituloTextField.setText(livro.getTitulo());
							autorTextField.setText(livro.getAutor());
							edicaoTextField.setText(livro.getEdicao());
							editoraTextField.setText(livro.getEditora());
							tempoReservaTextField.setText(String.valueOf(livro.getTempoReservaDias()));
							anoLancamentoTextField.setText(String.valueOf(livro.getAnoLancamento()));
						}
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.REVISTA)) {
						Revista revista = RevistaDAO.buscarRevista(Integer.parseInt(idItemTextField.getText()));

						if (revista != null) {
							tituloTextField.setText(revista.getTitulo());
							autorTextField.setText(revista.getAutor());
							edicaoTextField.setText(revista.getEdicao());
							editoraTextField.setText(revista.getEditora());
							tempoReservaTextField.setText(String.valueOf(revista.getTempoReservaDias()));
							anoLancamentoTextField.setText(String.valueOf(revista.getAnoLancamento()));
						}
					} else if (tipoItemEnumComboBox.getSelectedItem().equals(TipoItemEnum.PERIODICO)) {
						Periodico periodico = PeriodicoDAO.buscarPeriodico(Integer.parseInt(idItemTextField.getText()));

						if (periodico != null) {
							tituloTextField.setText(periodico.getTitulo());
							autorTextField.setText(periodico.getAutor());
							edicaoTextField.setText(periodico.getEdicao());
							editoraTextField.setText(periodico.getEditora());
							tempoReservaTextField.setText(String.valueOf(periodico.getTempoReservaDias()));
							anoLancamentoTextField.setText(String.valueOf(periodico.getAnoLancamento()));
						}
					}

				}
			}
		});
		formularioEdicaoPanel.add(buscarItemButton);
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

	private Revista createRevista(String titulo, String autor, String edicao, String editora, int tempoReserva,
			int anoLancamento) {
		Revista revista = new Revista();
		revista.setTitulo(titulo);
		revista.setAutor(autor);
		revista.setEdicao(edicao);
		revista.setEditora(editora);
		revista.setTempoReservaDias(tempoReserva);
		revista.setAnoLancamento(anoLancamento);

		return revista;
	}

	private Livro createLivro(String titulo, String autor, String edicao, String editora, int tempoReserva,
			int anoLancamento) {
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEdicao(edicao);
		livro.setEditora(editora);
		livro.setTempoReservaDias(tempoReserva);
		livro.setAnoLancamento(anoLancamento);

		return livro;
	}

	private Periodico createPeriodico(String titulo, String autor, String edicao, String editora, int tempoReserva,
			int anoLancamento) {
		Periodico periodico = new Periodico();
		periodico.setTitulo(titulo);
		periodico.setAutor(autor);
		periodico.setEdicao(edicao);
		periodico.setEditora(editora);
		periodico.setTempoReservaDias(tempoReserva);
		periodico.setAnoLancamento(anoLancamento);

		return periodico;
	}
}