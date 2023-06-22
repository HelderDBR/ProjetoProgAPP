package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnConsultarMes;
	private JButton btnConsultarInvestimento;
	private JButton btnConsultarDespesasOcasionais;
	private JButton btnResumoMensal;
	private JButton btnResumoAnual;
	private JLabel lblNewLabel;
	private int mes;
	private int ano;

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
		setTitle("Menu - Controle Financeiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 94, 416, 559);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnConsultarMes = new JButton("Consultar Mês");
		btnConsultarMes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnConsultarMes);
		
		btnConsultarInvestimento = new JButton("Consultar Investimento");
		btnConsultarInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InvestimentoLongoWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnConsultarInvestimento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnConsultarInvestimento);
		
		btnConsultarDespesasOcasionais = new JButton("Consultar Despesas Ocasionais");
		btnConsultarDespesasOcasionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DespesasOcasionaisWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnConsultarDespesasOcasionais.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnConsultarDespesasOcasionais);
		
		btnResumoMensal = new JButton("Resumo Mensal");
		btnResumoMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = (int) JOptionPane.showInputDialog(null,"","", JOptionPane.INFORMATION_MESSAGE);
				new ResumoMensalWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnResumoMensal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnResumoMensal);
		
		btnResumoAnual = new JButton("Resumo Anual");
		btnResumoAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResumoAnualWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnResumoAnual.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnResumoAnual);
		
		lblNewLabel = new JLabel("Menu Inicial");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(10, 10, 416, 74);
		contentPane.add(lblNewLabel);
		btnConsultarMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new RendimentoMensalWindow().setVisible(true);
				setVisible(false);
			}
		});
	}
}
