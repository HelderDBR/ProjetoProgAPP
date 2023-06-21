package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import entities.*;
import service.CategoriaRendimentoService;
import service.*;
import service.RendimentoService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CriacaoWindow extends JFrame {
	private JLabel lblCategoria;
	private JRadioButton rdbtnOcasional;
	private JRadioButton rdbtnMensal;
	private JPanel panel;
	private JTextField textValor;
	private JTextField textRend;
	private JComboBox comboCat;
	private JPanel contentPane;
	private ButtonGroup btnGropuTipo;
	private JButton btnSend;
	private CategoriaRendimentoService categorias;
	private JSpinner spinnerMes;
	private JTextField txtDigiteOAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriacaoWindow frame = new CriacaoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	
	
	public CriacaoWindow(){
		setResizable(false);
		this.initComponents();
		this.categorias = new CategoriaRendimentoService();
		
		try {
			this.buscarCategorias();
			this.btnSendActionperformed();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"SQLException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"IOException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void buscarCategorias() throws SQLException, IOException {
		List<CategoriaRendimento> categoria = this.categorias.buscarCategoriasRendimento();
		for(CategoriaRendimento categoria1 : categoria) {
			
			this.comboCat.addItem(categoria1);
		}
	}

	private void initComponents() {
		
		
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboCat = new JComboBox();
		comboCat.setBounds(10, 49, 229, 21);
		contentPane.add(comboCat);
		
		textRend = new JTextField();
		textRend.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textRend.getText().equals("Digite o Nome")) {
					textRend.setText("");
				}
			}
			
			public void focusLost(FocusEvent e) {
				if(textRend.getText().equals("")) {
					textRend.setText("Digite o Nome");
				} 
			}
		});
		textRend.setText("Digite o Nome");
		textRend.setToolTipText("Digite o Nome");
		textRend.setBounds(10, 90, 229, 19);
		contentPane.add(textRend);
		textRend.setColumns(10);
		
		textValor = new JTextField();
		textValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textValor.getText().equals("Digite o Valor")) {
					textValor.setText("");
				}
			}
			
			public void focusLost(FocusEvent e) {
				if (textValor.getText().equals("")) {
					textValor.setText("Digite o Valor");					
				}
			}
		});
		textValor.setToolTipText("Digite o Valor");
		textValor.setText("Digite o Valor");
		textValor.setBounds(10, 119, 229, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Tipo");
		panel.setBounds(295, 41, 114, 97);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnMensal = new JRadioButton("Mensal");
		panel.add(rdbtnMensal);
		
		rdbtnOcasional = new JRadioButton("Ocasional");
		panel.add(rdbtnOcasional);
		
		btnGropuTipo = new ButtonGroup();
		btnGropuTipo.add(rdbtnMensal);
		btnGropuTipo.add(rdbtnOcasional);
		
		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		panel.add(spinnerMes);
		
		lblCategoria = new JLabel("Escolha a Categoria");
		lblCategoria.setBounds(10, 26, 399, 13);
		contentPane.add(lblCategoria);
		
		btnSend = new JButton("Enviar");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						btnSendActionperformed();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"SQLException", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"IOException", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				
			}

			
		});
		btnSend.setBounds(154, 190, 85, 21);
		contentPane.add(btnSend);
		
		txtDigiteOAno = new JTextField();
		txtDigiteOAno.setText("Digite o Ano");
		txtDigiteOAno.setBounds(10, 148, 229, 19);
		contentPane.add(txtDigiteOAno);
		txtDigiteOAno.setColumns(10);
	}

	private void btnSendActionperformed() throws SQLException, IOException {
		this.cadastarRendimento();
		
	}
	
	public void cadastarRendimento() throws SQLException, IOException {
		CategoriaRendimento categoria = (CategoriaRendimento) comboCat.getSelectedItem();
		String nome = textRend.getText();
		float valor = (Float.parseFloat(textValor.getText()));
		int mes = 0;
		if(rdbtnMensal.isSelected()) {
			mes = 0;
		}else {
			mes = (int) spinnerMes.getValue();
		}
		int ano = Integer.parseInt(txtDigiteOAno.getText());
		Rendimento rend = new Rendimento(categoria, nome, valor, mes, ano);
		RendimentoService rendimentoService = new RendimentoService();
		rendimentoService.cadastrarRendimento(rend);
		setVisible(false);
	}
}
