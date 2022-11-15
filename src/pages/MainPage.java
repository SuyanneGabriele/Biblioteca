package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 553);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 128, 255));
		menuBar.setBackground(new Color(0, 128, 255));
		setJMenuBar(menuBar);
		
		JMenuItem menuItemLivro = new JMenuItem("Livro");
		menuItemLivro.setForeground(new Color(255, 255, 255));
		menuItemLivro.setBackground(new Color(100, 149, 237));
		menuBar.add(menuItemLivro);
		
		JMenuItem menuItemCliente = new JMenuItem("Cliente");
		menuItemCliente.setBackground(new Color(100, 149, 237));
		menuItemCliente.setForeground(new Color(255, 255, 255));
		menuBar.add(menuItemCliente);
		
		JMenuItem menuItemAcervo = new JMenuItem("Acervo");
		menuItemAcervo.setForeground(new Color(255, 255, 255));
		menuItemAcervo.setBackground(new Color(100, 149, 237));
		menuBar.add(menuItemAcervo);
		
		JMenuItem menuItemEmprestimo = new JMenuItem("Empréstimo");
		menuItemEmprestimo.setForeground(new Color(255, 255, 255));
		menuItemEmprestimo.setBackground(new Color(100, 149, 237));
		menuBar.add(menuItemEmprestimo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
