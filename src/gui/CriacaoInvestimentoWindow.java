package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Investimento;
import service.InvestimentoService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CriacaoInvestimentoWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textValue;
	private JLabel lblName;
	private JLabel lblValue;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JSpinner spinnerMes;
	private JSpinner spinnerAno;
	private InvestimentoService investimentoService;
	private Investimento investimento;
	private JButton btnSend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriacaoInvestimentoWindow frame = new CriacaoInvestimentoWindow();
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
	public CriacaoInvestimentoWindow() {
		setTitle("Cadastro de Investimento");
		this.setResizable(false);
		this.initComponents();
		
		this.investimentoService = new InvestimentoService();
		this.investimento = new Investimento();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Digite o Nome:");
		lblName.setBounds(10, 10, 96, 13);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setBounds(10, 33, 96, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblValue = new JLabel("Digite o Valor:");
		lblValue.setBounds(10, 62, 96, 13);
		contentPane.add(lblValue);
		
		textValue = new JTextField();
		textValue.setBounds(10, 85, 96, 19);
		contentPane.add(textValue);
		textValue.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Digite o Mês:");
		lblNewLabel_2.setBounds(128, 10, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Digite o Ano:");
		lblNewLabel_3.setBounds(128, 62, 78, 13);
		contentPane.add(lblNewLabel_3);
		
		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		spinnerMes.setBounds(216, 7, 45, 20);
		contentPane.add(spinnerMes);
		
		spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerNumberModel(2023, 2000, 2050, 1));
		spinnerAno.setBounds(216, 59, 45, 20);
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
		btnSend.setBounds(73, 135, 85, 21);
		contentPane.add(btnSend);
	}

	protected void btnDoneActionPressed() throws SQLException, IOException {
		Investimento invest = new Investimento();
		
		invest.setAno((int) spinnerAno.getValue());
		invest.setMes((int) spinnerMes.getValue());
		invest.setNome(textName.getName());
		invest.setValor(Float.parseFloat(textValue.getText()));
		
		this.investimentoService.cadastrarInvestimento(invest);
		setVisible(false);
	}
}
