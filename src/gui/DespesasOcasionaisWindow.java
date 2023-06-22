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
import service.FundoDespesasOcasionaisService;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class DespesasOcasionaisWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private FundoDespesasOcasionaisService despesasOcasionais;
	private FundoDespesasOcasionais fundoDespesas;
	private int ano;
	private int mes;
	private JSpinner spinnerAno;
	private JSpinner spinnerMes;
	private JButton btnRefresh;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DespesasOcasionaisWindow frame = new DespesasOcasionaisWindow();
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
	public DespesasOcasionaisWindow() {
		this.initComponents();
		
		mes = (int) spinnerMes.getValue();
		ano = (int) spinnerAno.getValue();
		
		this.despesasOcasionais = new FundoDespesasOcasionaisService();
		
		try {
			this.buscarDespesas(mes, ano);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buscarDespesas(int mes, int ano) throws SQLException, IOException {
		List<FundoDespesasOcasionais> despesas = this.despesasOcasionais.buscarFundoDespesasOcasionais();
		
		DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
		
		for (FundoDespesasOcasionais fundoDespesasOcasionais : despesas) {
			if (fundoDespesasOcasionais.getAno()==ano) {
				
			if (fundoDespesasOcasionais.getMes()==0) {
				modelo.addRow(new Object[] {
						fundoDespesasOcasionais.getNome(),
						fundoDespesasOcasionais.getValor(),
						"",
						(fundoDespesasOcasionais.getValor())*12
				});
			} else if(fundoDespesasOcasionais.getMes() == mes){
				modelo.addRow(new Object[] {
						fundoDespesasOcasionais.getNome(),
						"",
						fundoDespesasOcasionais.getValor(),
						fundoDespesasOcasionais.getValor()
				});
			}
		}
		}		
	}

	private void initComponents() {
		setTitle("Fundo de Despesas Ocasionais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInvestimentosALongo = new JLabel("Fundo de Despesas Ocasionais");
		lblInvestimentosALongo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvestimentosALongo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblInvestimentosALongo.setBounds(138, 10, 466, 52);
		contentPane.add(lblInvestimentosALongo);
		
		JPanel panel = new JPanel();
		panel.setBounds(614, 10, 216, 86);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAddFundo = new JButton("Cadastrar Novo Fundo");
		btnAddFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CriacaoFundoWindow().setVisible(true);
			}
		});
		panel.add(btnAddFundo);
		
		JButton btnEditFundo = new JButton("Editar Fundo");
		btnEditFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EdicaoFundoWindow().setVisible(true);
			}
		});
		panel.add(btnEditFundo);
		
		JButton btnDelFundo = new JButton("Excluir Fundo");
		btnDelFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExclusaoFundoWindow().setVisible(true);
			}
		});
		panel.add(btnDelFundo);
		
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
				"Fundo Ocasional", "Mensal", "Ocasional", "Total Anual"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(173);
		table.getColumnModel().getColumn(1).setPreferredWidth(152);
		table.getColumnModel().getColumn(2).setPreferredWidth(159);
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 75, 85, 21);
		contentPane.add(btnBack);
		
		btnRefresh = new JButton("Atualizar");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = (int) spinnerMes.getValue();
				ano = (int) spinnerAno.getValue();
				try {
					buscarDespesas(mes, ano);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(10, 41, 85, 21);
		contentPane.add(btnRefresh);
		
		JLabel lblNewLabel = new JLabel("Digite o Mes:");
		lblNewLabel.setBounds(105, 83, 75, 13);
		contentPane.add(lblNewLabel);
		
		spinnerMes = new JSpinner();
		spinnerMes.setBounds(183, 80, 55, 20);
		contentPane.add(spinnerMes);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o Ano:");
		lblNewLabel_1.setBounds(248, 83, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		spinnerAno = new JSpinner();
		spinnerAno.setBounds(330, 80, 55, 20);
		contentPane.add(spinnerAno);
	}
}
