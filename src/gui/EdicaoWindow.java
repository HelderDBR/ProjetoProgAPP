package gui;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.CategoriaDespesa;
import entities.CategoriaRendimento;
import service.CategoriaDespesaService;
import service.CategoriaRendimentoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EdicaoWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnDone;
	private JTextField textName;
	private JLabel lblNewLabel;
	private JComboBox comboChoice;
	private JLabel lblName;
	private CategoriaRendimentoService categoriaRendimentoService;
	private CategoriaDespesaService categoriaDespensaService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdicaoWindow frame = new EdicaoWindow();
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
	public EdicaoWindow() {
		setResizable(false);
		this.initComponents();
		this.categoriaRendimentoService = new CategoriaRendimentoService();
		this.categoriaDespensaService = new CategoriaDespesaService();
		try {
			buscarCategorias();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"SQLException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"IOException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void buscarCategorias() throws SQLException, IOException {
		List<CategoriaRendimento> categorias = this.categoriaRendimentoService.buscarCategoriasRendimento();
		List<CategoriaDespesa> despesas = this.categoriaDespensaService.buscarCategoriasDespesa();
		for(CategoriaRendimento categoria : categorias) {
			
			this.comboChoice.addItem(categoria);
		}
		
		for(CategoriaDespesa despesa : despesas) {
			for (int i = 0; i < comboChoice.getItemCount(); i++) {
				if (despesa.getDescricao().equals((String) comboChoice.getSelectedItem())) {
					
				}else{
					this.comboChoice.addItem(despesa);
				}
			}
		}
	}
	
	public void initComponents() {
		setTitle("Edição de Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Escolha a Categoria a ser Editada:");
		lblName.setBounds(10, 10, 281, 13);
		contentPane.add(lblName);
		
		comboChoice = new JComboBox();
		comboChoice.setBounds(10, 33, 281, 21);
		contentPane.add(comboChoice);
		
		textName = new JTextField();
		textName.setBounds(10, 89, 281, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblNewLabel = new JLabel("Digite a nova Categoria:");
		lblNewLabel.setBounds(10, 64, 281, 13);
		contentPane.add(lblNewLabel);
		
		btnDone = new JButton("Finalizar");
		btnDone.setBounds(100, 144, 85, 21);
		contentPane.add(btnDone);
	}
}
