package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.ResumoAnual;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ResumoAnualWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private ResumoAnual resumoAnual;
	private int ano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumoAnualWindow frame = new ResumoAnualWindow();
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
	public ResumoAnualWindow() {
		this.initComponents();
		ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Ano a ser Resumido.", "Pedir Ano", JOptionPane.QUESTION_MESSAGE));
		
		try {
			this.buscarLinhas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buscarLinhas() throws SQLException, IOException {
		ResumoAnual resumo = new ResumoAnual();
		resumo.CriarResumoAnual(ano);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
		
		modelo.addRow(new Object[] {
				"Rendimento",
				resumo.getRendimentoMensal(),
				resumo.getRendimentoOcasional(),
				resumo.getRendimentoAnual()
		});
		modelo.addRow(new Object[] {
				"Investimento a Longo Prazo",
				resumo.getInvestimentoMensal(),
				resumo.getInvestimentoOcasional(),
				resumo.getInvestimentoAnual()
		});
		modelo.addRow(new Object[] {
				"Fundo para Despesas Ocasionais",
				resumo.getFundoMensal(),
				resumo.getFundoOcasional(),
				resumo.getFundoAnual()
		});
		modelo.addRow(new Object[] {
				"Total Disponível para Despesas Durante o Ano",
				"",
				"",
				resumo.getTotalDisponivel()
		});
		modelo.addRow(new Object[] {
				"Total Despesas Mensais Orçadas (12 meses)",
				"",
				"",
				resumo.getTotalDespesasMensal()
		});
		modelo.addRow(new Object[] {
				"Total Despesas Ocasionais para o Ano",
				"",
				"",
				resumo.getTotalDespesasOcasional()
		});
		modelo.addRow(new Object[] {
				"Valor Total Restante ao Final do Ano",
				"",
				"",
				resumo.getTotal()
		});
		
	}

	private void initComponents() {
		setResizable(false);
		setTitle("Resumo Anual");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Resumo Anual");
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
				"Descrição", "Mensal (x12)", "Ocasional", "Total Anual"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(247);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(134);
		table.getColumnModel().getColumn(3).setPreferredWidth(136);
		scrollPane.setViewportView(table);
		
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
