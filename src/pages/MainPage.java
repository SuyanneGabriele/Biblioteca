package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel cabecalhoPanel;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPage() {
		setTitle("Biblioteca OnLine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 728, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 43, 709, 405);

		contentPane.add(tabbedPane);
		tabbedPane.addTab("Cadastro de Item", new CadastroItemPanel());
		tabbedPane.addTab("Edição de Item", new EdicaoItemPanel());

		cabecalhoPanel = new JPanel();
		cabecalhoPanel.setBackground(new Color(0, 128, 255));
		cabecalhoPanel.setBounds(0, 0, 714, 43);
		contentPane.add(cabecalhoPanel);

		lblNewLabel_1 = new JLabel("Biblioteca");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cabecalhoPanel.add(lblNewLabel_1);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
