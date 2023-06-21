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

public class CriacaoRendimentoWindow extends JFrame {
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
	private CategoriaRendimentoService categoriaRendimentoService;
	private CategoriaDespesaService categoriaDespensaService;
	private JSpinner spinnerMes;
	private JTextField txtDigiteOAno;
	private RendimentoService rendimentoService;
	private DespesasService despesasService;
	private ButtonGroup btnGrupo2;
	private MaskFormatter mascaraAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriacaoRendimentoWindow frame = new CriacaoRendimentoWindow();
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
	
	
	public CriacaoRendimentoWindow(){
		setResizable(false);
		this.criarMascaraAno();
		this.initComponents();
		this.categoriaRendimentoService = new CategoriaRendimentoService();
		this.rendimentoService = new RendimentoService();
		
		try {
			this.buscarCategorias();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"SQLException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"IOException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void criarMascaraAno() {
		
		try {
			this.mascaraAno = new MaskFormatter("####");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"ParseException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	private void buscarCategorias() throws SQLException, IOException {
		List<CategoriaRendimento> categorias = this.categoriaRendimentoService.buscarCategoriasRendimento();
		for(CategoriaRendimento categoria : categorias) {
			
			this.comboCat.addItem(categoria.getDescricao());
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
		textValor.setBounds(10, 119, 229, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Tipo");
		panel.setBounds(293, 26, 114, 97);
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
		
		txtDigiteOAno = new JFormattedTextField(mascaraAno);
		txtDigiteOAno.setToolTipText("Digite o Ano");
		txtDigiteOAno.setBounds(10, 148, 229, 19);
		contentPane.add(txtDigiteOAno);
		txtDigiteOAno.setColumns(10);
		
		btnGrupo2 = new ButtonGroup();
	}

	private void btnSendActionperformed() throws SQLException, IOException {
		cadastarRendimento();
		
	}

	public void cadastarRendimento() throws SQLException, IOException {
		Rendimento rend = new Rendimento();
		
		rend.setCategoriaRendimento((CategoriaRendimento) comboCat.getSelectedItem());
		rend.setNome(textRend.getText());
		//rend.setValor((Float.parseFloat(textValor.getText())));
		if(rdbtnMensal.isSelected()) {
			rend.setMes(0);
		}else {
			rend.setMes((int) spinnerMes.getValue());
		}
		rend.setAno((Integer.parseInt(txtDigiteOAno.getText())));
		
		rendimentoService.cadastrarRendimento(rend);
		setVisible(false);
	}
}
