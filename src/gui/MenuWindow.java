package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnConsultarRendimento;
	private JButton btnConsultarDespesasOcasionais;
	private JButton btnResumoMensal;
	private JButton btnResumoAnual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow frame = new MenuWindow();
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
	public MenuWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Consultar Mês");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(81, 97, 246, 65);
		contentPane.add(btnNewButton);
		
		btnConsultarRendimento = new JButton("Consultar Rendimento");
		btnConsultarRendimento.setBounds(81, 180, 246, 65);
		contentPane.add(btnConsultarRendimento);
		
		btnConsultarDespesasOcasionais = new JButton("Consultar Despesas Ocasionais");
		btnConsultarDespesasOcasionais.setBounds(81, 265, 246, 65);
		contentPane.add(btnConsultarDespesasOcasionais);
		
		btnResumoMensal = new JButton("Resumo Mensal");
		btnResumoMensal.setBounds(81, 353, 246, 65);
		contentPane.add(btnResumoMensal);
		
		btnResumoAnual = new JButton("Resumo Anual");
		btnResumoAnual.setBounds(81, 439, 246, 65);
		contentPane.add(btnResumoAnual);
	}
}
