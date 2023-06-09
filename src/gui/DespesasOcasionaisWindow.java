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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DespesasOcasionaisWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		panel.add(btnAddFundo);
		
		JButton btnEditFundo = new JButton("Editar Fundo");
		panel.add(btnEditFundo);
		
		JButton btnDelFundo = new JButton("Excluir Fundo");
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
		
		JButton btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 75, 85, 21);
		contentPane.add(btnBack);
	}
}
