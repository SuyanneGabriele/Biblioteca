package pages;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import classes.Acervo;
import classes.Livro;
import classes.Periodico;
import classes.Revista;
import dao.AcervoDAO;
import dao.LivroDAO;
import dao.PeriodicoDAO;
import dao.RevistaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enumeration.TipoItemEnum;
import javax.swing.JCheckBox;

public class CadastroItemPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CadastroItemPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel tituloLabel = new JLabel("Titulo");
		tituloLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tituloLabel.setBounds(10, 10, 45, 13);
		add(tituloLabel);

		JTextField tituloTextField = new JTextField();
		tituloTextField.setBounds(10, 31, 360, 19);
		add(tituloTextField);
		tituloTextField.setColumns(10);

		JTextField autorTextField = new JTextField();
		autorTextField.setColumns(10);
		autorTextField.setBounds(10, 80, 360, 19);
		add(autorTextField);

		JLabel autorLabel = new JLabel("Autor");
		autorLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		autorLabel.setBounds(10, 60, 45, 13);
		add(autorLabel);

		JLabel anoLancamentoLabel = new JLabel("Ano do lançamento");
		anoLancamentoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		anoLancamentoLabel.setBounds(227, 119, 143, 13);
		add(anoLancamentoLabel);

		JTextField anoLancamentoTextField = new JTextField();
		anoLancamentoTextField.setColumns(10);
		anoLancamentoTextField.setBounds(227, 142, 63, 19);
		add(anoLancamentoTextField);

		JLabel editoraLabel = new JLabel("Editora");
		editoraLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		editoraLabel.setBounds(10, 119, 119, 13);
		add(editoraLabel);

		JTextField editoraTextField = new JTextField();
		editoraTextField.setColumns(10);
		editoraTextField.setBounds(10, 142, 185, 19);
		add(editoraTextField);

		JLabel edicaoLabel = new JLabel("Edição");
		edicaoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		edicaoLabel.setBounds(10, 183, 119, 13);
		add(edicaoLabel);

		JTextField edicaoTextField = new JTextField();
		edicaoTextField.setColumns(10);
		edicaoTextField.setBounds(10, 206, 185, 19);
		add(edicaoTextField);

		JLabel tempoParaReservaLabel = new JLabel("Tempo para reserva(em dias)");
		tempoParaReservaLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tempoParaReservaLabel.setBounds(224, 183, 216, 13);
		add(tempoParaReservaLabel);

		JTextField tempoReservaTextField = new JTextField();
		tempoReservaTextField.setColumns(10);
		tempoReservaTextField.setBounds(227, 206, 63, 19);
		add(tempoReservaTextField);

		JComboBox<TipoItemEnum> tipoItemComboBox = new JComboBox<TipoItemEnum>();
		tipoItemComboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tipoItemComboBox.setModel(new DefaultComboBoxModel<TipoItemEnum>(TipoItemEnum.values()));
		tipoItemComboBox.setBounds(10, 269, 185, 21);
		add(tipoItemComboBox);

		JLabel tipoDadoLabel = new JLabel("Tipo de dado");
		tipoDadoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tipoDadoLabel.setBounds(10, 246, 119, 13);
		add(tipoDadoLabel);

		JCheckBox insereAcervoCheckBox = new JCheckBox("Inserir no acervo");
		insereAcervoCheckBox.setBackground(new Color(255, 255, 255));
		insereAcervoCheckBox.setBounds(227, 270, 143, 21);
		add(insereAcervoCheckBox);

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

	public void limparCampos(JTextField tituloTextField, JTextField anoLancamentoTextField,
			JTextField tempoReservaTextField, JTextField autorTextField, JTextField editoraTextField, //
			JTextField edicaoTextField) {
		tituloTextField.setText("");
		anoLancamentoTextField.setText("");
		tempoReservaTextField.setText("");
		autorTextField.setText("");
		editoraTextField.setText("");
		edicaoTextField.setText("");
	}

	public void inserirLivroAcervo() {
		Livro livroInserido = LivroDAO.buscarUltimoLivroInserido();
		if (livroInserido != null) {
			Acervo acervo = new Acervo();
			acervo.setIdItem(livroInserido.getId());
			acervo.setTipoItem(TipoItemEnum.LIVRO.toString());
			AcervoDAO.adicionarAcervo(acervo);
		}
	}

	public void inserirRevistaAcervo() {
		Revista revistaInserido = RevistaDAO.buscarUltimaRevistaInserida();
		if (revistaInserido != null) {
			Acervo acervo = new Acervo();
			acervo.setIdItem(revistaInserido.getId());
			acervo.setTipoItem(TipoItemEnum.REVISTA.toString());
			AcervoDAO.adicionarAcervo(acervo);
		}
	}

	public void inserirPeriodicoAcervo() {
		Periodico periodicoInserido = PeriodicoDAO.buscarUltimoPeriodicoInserido();
		if (periodicoInserido != null) {
			Acervo acervo = new Acervo();
			acervo.setIdItem(periodicoInserido.getId());
			acervo.setTipoItem(TipoItemEnum.PERIODICO.toString());
			AcervoDAO.adicionarAcervo(acervo);
		}
	}

	public void informaUsuario(boolean resultado, TipoItemEnum tipoItemEnum) {
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Registro do tipo " + tipoItemEnum + " inserido com sucesso!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Registro do tipo " + tipoItemEnum + " não foi inserido.", "Aviso",
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
