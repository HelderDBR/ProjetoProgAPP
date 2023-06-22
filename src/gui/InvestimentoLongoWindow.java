package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.FundoDespesasOcasionais;
import entities.Investimento;
import service.InvestimentoService;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InvestimentoLongoWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private InvestimentoService investimentoService;
	private JSpinner spinnerMes;
	private JSpinner spinnerAno;
	private int mes;
	private int ano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvestimentoLongoWindow frame = new InvestimentoLongoWindow();
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
	public InvestimentoLongoWindow() {
		this.initComponents();
		
		this.investimentoService = new InvestimentoService();
		mes = (int) spinnerMes.getValue();
		ano = (int) spinnerAno.getValue();
		
		try {
			this.buscarInvestimentos(mes, ano);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buscarInvestimentos(int mes, int ano) throws SQLException, IOException {
		List<Investimento> investimentos = this.investimentoService.buscarInvestimento();
		
		DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
		
		for (Investimento investimento : investimentos) {
			if (investimento.getAno() == ano) {
			if (investimento.getMes() == 0) {
				modelo.addRow(new Object[] {
						investimento.getNome(),
						investimento.getValor(),
						"",
						(investimento.getValor())*12
				});
			} else if (investimento.getMes() == mes){
				modelo.addRow(new Object[] {
						investimento.getNome(),
						"",
						investimento.getValor(),
						investimento.getValor()
				});
			}
		}
	}
	}

	private void initComponents() {
		setTitle("Investimentos a Longo Prazo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInvestimentosALongo = new JLabel("Investimentos a Longo Prazo");
		lblInvestimentosALongo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvestimentosALongo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblInvestimentosALongo.setBounds(138, 0, 466, 52);
		contentPane.add(lblInvestimentosALongo);
		
		JPanel panel = new JPanel();
		panel.setBounds(614, 10, 216, 86);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAddInves = new JButton("Cadastrar Investimento");
		btnAddInves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CriacaoInvestimentoWindow().setVisible(true);
			}
		});
		panel.add(btnAddInves);
		
		JButton btnEditInves = new JButton("Editar Investimento");
		btnEditInves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EdicaoInvestimentoWindow().setVisible(true);
			}
		});
		panel.add(btnEditInves);
		
		JButton btnDelInves = new JButton("Excluir Investimento");
		btnDelInves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExclusaoInvestimentoWindow().setVisible(true);
			}
		});
		panel.add(btnDelInves);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBounds(10, 106, 820, 299);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 793, 320);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Investimento", "Mensal", "Ocasional", "Total Anual"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(173);
		table.getColumnModel().getColumn(1).setPreferredWidth(152);
		table.getColumnModel().getColumn(2).setPreferredWidth(159);
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 75, 85, 21);
		contentPane.add(btnBack);
		
		JButton btnRefresh = new JButton("Atualizar");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				mes = (int) spinnerMes.getValue();
				ano = (int) spinnerAno.getValue();
				buscarInvestimentos(mes, ano);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnRefresh.setBounds(10, 47, 85, 21);
		contentPane.add(btnRefresh);
		
		JLabel lblNewLabel = new JLabel("Digite o Mes:");
		lblNewLabel.setBounds(105, 79, 75, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o Ano:");
		lblNewLabel_1.setBounds(234, 79, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMes.setBounds(169, 76, 55, 20);
		contentPane.add(spinnerMes);
		
		spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerNumberModel(2023, 2000, 20050, 1));
		spinnerAno.setBounds(311, 76, 55, 20);
		contentPane.add(spinnerAno);
	}
}
