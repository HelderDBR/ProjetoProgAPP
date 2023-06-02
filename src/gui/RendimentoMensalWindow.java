package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class RendimentoMensalWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton_5;
	private JButton btnNewButton_4;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RendimentoMensalWindow frame = new RendimentoMensalWindow();
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
	public RendimentoMensalWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 662);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Categoria");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Categoria");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Editar Categoria");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Excluir Categoria");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Mês");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 49));
		lblNewLabel.setBounds(221, 0, 576, 77);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Cadastrar Categoria");
		btnNewButton.setBounds(22, 44, 186, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cadastrar Categoria");
		btnNewButton_1.setBounds(22, 80, 186, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Cadastrar Categoria");
		btnNewButton_2.setBounds(21, 111, 186, 21);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Cadastrar Categoria");
		btnNewButton_3.setBounds(830, 48, 186, 21);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Cadastrar Categoria");
		btnNewButton_4.setBounds(829, 77, 186, 21);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Cadastrar Categoria");
		btnNewButton_5.setBounds(828, 109, 186, 21);
		contentPane.add(btnNewButton_5);
		
		panel = new JPanel();
		panel.setBounds(9, 150, 516, 467);
		contentPane.add(panel);
		
		textArea = new JTextArea();
		panel.add(textArea);
		
		panel_1 = new JPanel();
		panel_1.setBounds(538, 151, 488, 466);
		contentPane.add(panel_1);
		
		textArea_1 = new JTextArea();
		panel_1.add(textArea_1);
	}
}
