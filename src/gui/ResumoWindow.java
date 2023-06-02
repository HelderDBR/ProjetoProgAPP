package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ResumoWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumoWindow frame = new ResumoWindow();
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
	public ResumoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Resumo");
		lblNewLabel.setBounds(396, 11, 45, 13);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(6, 74, 813, 340);
		contentPane.add(panel);
		
		textArea = new JTextArea();
		panel.add(textArea);
		
		btnNewButton = new JButton("Exportar Resumo");
		btnNewButton.setBounds(43, 26, 149, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBounds(727, 43, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
