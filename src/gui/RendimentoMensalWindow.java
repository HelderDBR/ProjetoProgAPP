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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Categoria;
import entities.Despesas;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class RendimentoMensalWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblTítulo;
	private JPanel editionPanel;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable tblRend;
	private JButton btnDelCat;
	private JButton btnEditCat;
	private JButton btnAddCat;
	private JButton btnAddRend;
	private JButton btnEditRend;
	private JButton btnDelRend;
	private JButton btnAddDesp;
	private JButton btnEditDesp;
	private JButton btnDelDesp;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JTable tblDesp;
	private JMenuBar menuBar;
	private JButton btnBack;
	private Categoria categorias;
	private Despesas despesa;

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
		setResizable(false);
		this.initComponents();
		
		this.categorias = new Categoria();
		
		this.buscarCategorias();
		this.buscarRendimentos();
		this.buscarDespesas();
	}

	private void buscarDespesas() {
		/*	DefaultTableModel modelo = (DefaultTableModel) tblDesp.getModel();
		 * modelo.fireTableDataChanged();
		 * modelo.setRowCount(0);
		 * 
		 * List<Despesas> despesas = this.despesasService.buscarTodos();
		 * 
		 * for(Despesasa despesa : despesas){
		 * 
		 * modelo.addRow(new Object[]{
		 * despesa.getCategoria();
		 * despesa.getNome();
		 * despesa.getValor();
		 * });
		 * 
		 */
	}

	private void buscarRendimentos() {
		/*	DefaultTableModel modelo = (DefaultTableModel) tblRend.getModel();
		 * modelo.fireTableDataChanged();
		 * modelo.setRowCount(0);
		 * 
		 * List<Rendimento> rendimentos = this.rendimentoService.buscarTodos();
		 * 
		 * for(Rendimento rendimento : rendimentos){
		 * 
		 * modelo.addRow(new Object[]{
		 * rendimento.getCategoria();
		 * rendimento.getNome();
		 * rendimento.getValor();
		 * });
		 * 
		 */
		
	}

	private void buscarCategorias() {
		/*List<Categoria> categoria = this.categorias;
		for(Categoria categoria1 : categoria) {
			
			this.comboCat.addItem(categoria1);
		}*/
	}
	
	public void initComponents() {
		setTitle("Rendimento e Despesas Mensais");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1070, 700);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTítulo = new JLabel("Rendimentos e Despesas Mensais:");
		lblTítulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTítulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTítulo.setBounds(9, 10, 510, 92);
		contentPane.add(lblTítulo);
		
		editionPanel = new JPanel();
		editionPanel.setBorder(new TitledBorder(null, "Edi\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		editionPanel.setBounds(536, 10, 497, 133);
		contentPane.add(editionPanel);
		editionPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAddCat = new JButton("Cadastrar Categoria");
		btnAddCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				String nome = JOptionPane.showInputDialog(null, "Digite o Nome da Categoria", "Cadastro de Categoria", JOptionPane.QUESTION_MESSAGE);
				System.out.println("Categoria: " + nome);
				//Manda nome para a função de criar Categoria nova
			}
		});
		editionPanel.add(btnAddCat);
		
		btnEditCat = new JButton("Editar Categoria");
		editionPanel.add(btnEditCat);
		
		btnDelCat = new JButton("Excluir Categoria");
		btnDelCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editionPanel.add(btnDelCat);
		
		btnAddRend = new JButton("Cadastrar Rendimento");
		btnAddRend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CriacaoWindow().setVisible(true);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "SQLException", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "IOException", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		editionPanel.add(btnAddRend);
		
		btnEditRend = new JButton("Editar Rendimento");
		editionPanel.add(btnEditRend);
		
		btnDelRend = new JButton("Excluir Rendimento");
		editionPanel.add(btnDelRend);
		
		btnAddDesp = new JButton("Cadastrar Despesa");
		btnAddDesp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CriacaoWindow().setVisible(true);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "SQLException", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "IOException", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		editionPanel.add(btnAddDesp);
		
		btnEditDesp = new JButton("Editar Despesa");
		editionPanel.add(btnEditDesp);
		
		btnDelDesp = new JButton("Excluir Despesa");
		editionPanel.add(btnDelDesp);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rendimentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 162, 510, 469);
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		tblRend = new JTable();
		tblRend.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Rendimento", "Mensal", "Ocasional", "Total Ano"
			}
		));
		scrollPane.setViewportView(tblRend);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Despesas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(536, 162, 510, 469);
		contentPane.add(panel_1);
		
		scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblDesp = new JTable();
		tblDesp.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Despesa", "Mensal", "Ocasional", "Total Ano"
			}
		));
		scrollPane_1.setViewportView(tblDesp);
		panel_1.setLayout(gl_panel_1);
		
		btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow().setVisible(true);
				setVisible(false);
				
			}
		});
		btnBack.setBounds(19, 126, 85, 21);
		contentPane.add(btnBack);
	}
	
}
