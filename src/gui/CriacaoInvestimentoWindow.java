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
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private InvestimentoService investimentoService;
	private Investimento investimento;
	private JButton btnNewButton;

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
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Digite o Nome:");
		lblNewLabel.setBounds(10, 10, 96, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 33, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Digite o Valor:");
		lblNewLabel_1.setBounds(10, 62, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 85, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Digite o Mês:");
		lblNewLabel_2.setBounds(128, 10, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Digite o Ano:");
		lblNewLabel_3.setBounds(128, 62, 78, 13);
		contentPane.add(lblNewLabel_3);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		spinner.setBounds(216, 7, 45, 20);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(2023, 2000, 2050, 1));
		spinner_1.setBounds(216, 59, 45, 20);
		contentPane.add(spinner_1);
		
		btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(73, 135, 85, 21);
		contentPane.add(btnNewButton);
	}

	protected void btnDoneActionPressed() throws SQLException, IOException {
		Investimento invest = new Investimento();
		
		invest.setAno((int) spinner_1.getValue());
		invest.setMes((int) spinner.getValue());
		invest.setNome(textField.getName());
		invest.setValor(Float.parseFloat(textField_1.getText()));
		
		this.investimentoService.cadastrarInvestimento(invest);
		setVisible(false);
	}
}
