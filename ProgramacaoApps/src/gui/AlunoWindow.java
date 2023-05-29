package gui;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

public class AlunoWindow extends JFrame {
	private JTextField txtRegistroAcademico;
	private JTextField txtNome;
	private JRadioButton rbMasculino;
	private JTable table;
	private MaskFormatter mascaraData;
	private JTextField txtDataIngresso;
	private JTextField textField;
	private ButtonGroup btnGroupSexo;
	
	public AlunoWindow() {
		this.criarMascaraData();
		this.initComponent();
	}

	private void criarMascaraData() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		} catch(ParseException e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoWindow frame = new AlunoWindow();
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
	public void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRegistroAcademico = new JTextField();
		txtRegistroAcademico.setBounds(130, 8, 115, 20);
		contentPane.add(txtRegistroAcademico);
		txtRegistroAcademico.setColumns(10);
		
		JLabel lblRegistroAcademico = new JLabel("Registro Acadêmico");
		lblRegistroAcademico.setBounds(20, 11, 105, 14);
		contentPane.add(lblRegistroAcademico);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 36, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setText("");
		txtNome.setBounds(61, 33, 352, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel painelSexo = new JPanel();
		painelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelSexo.setBounds(20, 61, 128, 99);
		contentPane.add(painelSexo);
		painelSexo.setLayout(null);
		
		JRadioButton rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(20, 17, 67, 23);
		rbFeminino.setVerticalAlignment(SwingConstants.TOP);
		painelSexo.add(rbFeminino);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(20, 39, 71, 23);
		rbMasculino.setVerticalAlignment(SwingConstants.TOP);
		painelSexo.add(rbMasculino);
		
		JRadioButton rbNaoInformar = new JRadioButton("Não informar");
		rbNaoInformar.setBounds(20, 62, 87, 23);
		painelSexo.add(rbNaoInformar);
		rbNaoInformar.setVerticalAlignment(SwingConstants.TOP);
		
		
		btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rbMasculino);
		btnGroupSexo.add(rbFeminino);
		btnGroupSexo.add(rbNaoInformar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 170, 404, 98);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"RA", "Nome", "Sexo", "Curso", "Data do ingresso", "Período", "Coeficiente"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(158, 64, 46, 14);
		contentPane.add(lblCurso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(201, 60, 212, 22);
		contentPane.add(comboBox);
		
		JLabel lblDataIngresso = new JLabel("Data de Ingresso");
		lblDataIngresso.setBounds(158, 100, 88, 14);
		contentPane.add(lblDataIngresso);
		
		txtDataIngresso = new JFormattedTextField(mascaraData);
		txtDataIngresso.setBounds(248, 98, 67, 20);
		contentPane.add(txtDataIngresso);
		txtDataIngresso.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(330, 100, 40, 14);
		contentPane.add(lblPeriodo);
		
		JSpinner spinnerPeriodo = new JSpinner();
		spinnerPeriodo.setBounds(373, 98, 40, 20);
		contentPane.add(spinnerPeriodo);
		
		JLabel lblCoeficiente = new JLabel("Coeficiente");
		lblCoeficiente.setBounds(158, 134, 60, 14);
		contentPane.add(lblCoeficiente);
		
		textField = new JTextField();
		textField.setBounds(217, 131, 75, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
