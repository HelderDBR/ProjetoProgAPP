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
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CriacaoWindow extends JFrame {
	private JLabel lblCategoria;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JPanel panel;
	private JTextField textValor;
	private JTextField textRend;
	private JComboBox comboCat;
	private JPanel contentPane;
	private ButtonGroup btnGropuTipo;

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
	 */
	public CriacaoWindow() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboCat = new JComboBox();
		comboCat.setBounds(10, 49, 416, 21);
		contentPane.add(comboCat);
		
		textRend = new JTextField();
		textRend.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textRend.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				if(textRend.getText().equals("")) {
					textRend.setText("Digite o Nome do Rendimento");
				} else {
					
				}
				
			}
		});
		textRend.setText("Digite o Nome do Rendimento");
		textRend.setToolTipText("Digite o Nome do Rendimento");
		textRend.setBounds(10, 120, 229, 19);
		contentPane.add(textRend);
		textRend.setColumns(10);
		
		textValor = new JTextField();
		textValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textValor.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				textValor.setText("Digite o Valor do Rendimento");
			}
		});
		textValor.setToolTipText("Digite o Valor do Rendimento");
		textValor.setText("Digite o Valor do Rendimento");
		textValor.setBounds(10, 185, 229, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Tipo");
		panel.setBounds(295, 107, 114, 97);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnNewRadioButton = new JRadioButton("Mensal");
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Ocasional");
		panel.add(rdbtnNewRadioButton_1);
		
		btnGropuTipo = new ButtonGroup();
		btnGropuTipo.add(rdbtnNewRadioButton);
		btnGropuTipo.add(rdbtnNewRadioButton_1);
		
		lblCategoria = new JLabel("Escolha a Categoria");
		lblCategoria.setBounds(10, 26, 399, 13);
		contentPane.add(lblCategoria);
	}
}
