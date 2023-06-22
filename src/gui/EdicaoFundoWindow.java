package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.FundoDespesasOcasionais;
import entities.Investimento;
import service.FundoDespesasOcasionaisService;
import service.InvestimentoService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class EdicaoFundoWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textValue;
	private JLabel lblName;
	private JLabel lblValue;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JSpinner spinnerMes;
	private JSpinner spinnerAno;
	private FundoDespesasOcasionaisService fundoService;
	private FundoDespesasOcasionais fundo;
	private JButton btnSend;
	private JComboBox comboBox;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdicaoFundoWindow frame = new EdicaoFundoWindow();
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
	public EdicaoFundoWindow() {
		setTitle("Cadastro de Investimento");
		this.setResizable(false);
		this.initComponents();
		this.fundoService = new FundoDespesasOcasionaisService();
		
		try {
			this.buscarInvestimentos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void buscarInvestimentos() throws SQLException, IOException {
		List<FundoDespesasOcasionais> fundos = this.fundoService.buscarFundoDespesasOcasionais();
		
		for (FundoDespesasOcasionais fundo : fundos) {
				comboBox.addItem(fundo);
		}
		
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Digite o Nome:");
		lblName.setBounds(10, 62, 96, 13);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setText("Nome");
		textName.setBounds(10, 85, 96, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblValue = new JLabel("Digite o Valor:");
		lblValue.setBounds(10, 114, 96, 13);
		contentPane.add(lblValue);
		
		textValue = new JTextField();
		textValue.setText("1500");
		textValue.setBounds(10, 137, 96, 19);
		contentPane.add(textValue);
		textValue.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Digite o Mês:");
		lblNewLabel_2.setBounds(116, 62, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Digite o Ano:");
		lblNewLabel_3.setBounds(116, 88, 78, 13);
		contentPane.add(lblNewLabel_3);
		
		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		spinnerMes.setBounds(204, 59, 68, 20);
		contentPane.add(spinnerMes);
		
		spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerNumberModel(2023, 2000, 2050, 1));
		spinnerAno.setBounds(204, 85, 68, 20);
		contentPane.add(spinnerAno);
		
		btnSend = new JButton("Finalizar");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnDoneActionPressed();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSend.setBounds(121, 188, 85, 21);
		contentPane.add(btnSend);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 33, 133, 21);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("Escolha o Investimento a ser Editado:");
		lblNewLabel.setBounds(10, 10, 184, 13);
		contentPane.add(lblNewLabel);
	}

	protected void btnDoneActionPressed() throws SQLException, IOException {
		FundoDespesasOcasionais invest = (FundoDespesasOcasionais) comboBox.getSelectedItem();
		
		invest.setAno((int) spinnerAno.getValue());
		invest.setMes((int) spinnerMes.getValue());
		invest.setNome(textName.getText());
		invest.setValor(Float.parseFloat(textValue.getText()));
		
		this.fundoService.editarFundoDespesasOcasionais(invest);
		setVisible(false);
	}
}
