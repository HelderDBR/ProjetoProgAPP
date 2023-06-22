package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

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
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CriacaoFundoWindow extends JFrame {
	private JRadioButton rdbtnOcasional;
	private JRadioButton rdbtnMensal;
	private JPanel panel;
	private JTextField textValor;
	private JTextField textInvest;
	private JPanel contentPane;
	private ButtonGroup btnGropuTipo;
	private JButton btnSend;
	private JSpinner spinnerMes;
	private JTextField txtDigiteOAno;
	private MaskFormatter mascaraAno;
	private FundoDespesasOcasionaisService fundoService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriacaoFundoWindow frame = new CriacaoFundoWindow();
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
	
	
	public CriacaoFundoWindow(){
		setResizable(false);
		this.criarMascaraAno();
		this.initComponents();
		this.fundoService = new FundoDespesasOcasionaisService();
		
	}

	private void criarMascaraAno() {
		
		try {
			this.mascaraAno = new MaskFormatter("####");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"ParseException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private void initComponents() {
		
		
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textInvest = new JTextField();
		textInvest.setText("Digite o Nome do investimento");
		textInvest.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textInvest.getText().equals("Digite o Nome")) {
					textInvest.setText("");
				}
			}
			
			public void focusLost(FocusEvent e) {
				if(textInvest.getText().equals("")) {
					textInvest.setText("Digite o Nome");
				} 
			}
		});
		textInvest.setToolTipText("Digite o Nome");
		textInvest.setBounds(10, 23, 229, 19);
		contentPane.add(textInvest);
		textInvest.setColumns(10);
		
		textValor = new JTextField();
		textValor.setText("Digite o Valor do Fundo de Despesas");
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
		textValor.setBounds(10, 52, 229, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Tipo");
		panel.setBounds(312, 23, 114, 97);
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
		btnSend.setBounds(154, 140, 85, 21);
		contentPane.add(btnSend);
		
		txtDigiteOAno = new JFormattedTextField(mascaraAno);
		txtDigiteOAno.setText("2023");
		txtDigiteOAno.setToolTipText("Digite o Ano");
		txtDigiteOAno.setBounds(10, 88, 229, 19);
		contentPane.add(txtDigiteOAno);
		txtDigiteOAno.setColumns(10);
		
		new ButtonGroup();
	}

	private void btnSendActionperformed() throws SQLException, IOException {
		cadastarFundo();
		
	}

	public void cadastarFundo() throws SQLException, IOException {
		FundoDespesasOcasionais fund = new FundoDespesasOcasionais();
		
		fund.setNome(textInvest.getText());
		fund.setValor((Float.parseFloat(textValor.getText())));
		if(rdbtnMensal.isSelected()) {
			fund.setMes(0);
		}else {
			fund.setMes((int) spinnerMes.getValue());
		}
		fund.setAno((Integer.parseInt(txtDigiteOAno.getText())));
		
		fundoService.cadastrarFundoDespesasOcasionais(fund);
		setVisible(false);
	}
}
