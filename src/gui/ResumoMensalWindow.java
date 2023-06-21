package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.ResumoMensal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResumoMensalWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnExport;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private ResumoMensal resumoMensal;
	private int mes;
	private int ano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumoMensalWindow frame = new ResumoMensalWindow();
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
	public ResumoMensalWindow() {
		this.initComponents();
		
		
		
		this.buscarLinhas();
		
	}
	
	private void buscarLinhas() {
		ResumoMensal resumo = new ResumoMensal();
		resumo.criarResumoMensal(, );
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
	
		modelo.addRow(new Object[] {
				"Rendimento",
				resumo.getRendimento()
		});
		modelo.addRow(new Object[] {
				"Investimento a Longo Prazo",
				resumo.getInvestimentosLongoPrazo()
		});
		modelo.addRow(new Object[] {
				"Fundo para Despesas Ocasionais",
				resumo.getFundoDespesasOcasionais()
		});
		modelo.addRow(new Object[] {
				"Valor Total Disponível por Mês para Despesas",
				resumo.getTotalDisponivel()
		});
		modelo.addRow(new Object[] {
				"Valor Total das Despesas Orçadas para o Mês",
				resumo.getTotalDespesas()
		});
		modelo.addRow(new Object[] {
				"Valor Total",
				resumo.getTotal()
		});
		
	}

	private void initComponents() {
		setTitle("Resumo Mensal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Resumo Mensal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(253, 1, 308, 52);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(6, 74, 813, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 793, 320);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(416);
		table.getColumnModel().getColumn(1).setPreferredWidth(218);
		scrollPane.setViewportView(table);
		
		btnExport = new JButton("Exportar Resumo");
		btnExport.setBounds(642, 43, 177, 21);
		contentPane.add(btnExport);
		
		btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 43, 85, 21);
		contentPane.add(btnBack);
	}
}
