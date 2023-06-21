package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.CategoriaDespesa;
import entities.CategoriaRendimento;
import service.CategoriaDespesaService;
import service.CategoriaRendimentoService;

public class ExclusaoCategoriaWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnDone;
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
					ExclusaoCategoriaWindow frame = new ExclusaoCategoriaWindow();
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
	public ExclusaoCategoriaWindow() {
		setResizable(false);
		this.initComponents();
		this.categoriaRendimentoService = new CategoriaRendimentoService();
		this.categoriaDespensaService = new CategoriaDespesaService();
		try {
			buscarCategorias();
			btnDonePressed();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"SQLException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"IOException", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void buscarCategorias() throws SQLException, IOException {
		List<CategoriaDespesa> despesas = this.categoriaDespensaService.buscarCategoriasDespesa();
		List<CategoriaRendimento> rendimentos = this.categoriaRendimentoService.buscarCategoriasRendimento();
		for(CategoriaDespesa despesa : despesas) {
			this.comboChoice.addItem(despesa);
		}
		for (CategoriaRendimento categoriaRendimento : rendimentos) {
			if (rendimentos.equals(comboChoice.getSelectedItem())) {
				
			}else {
				this.comboChoice.addItem(categoriaRendimento);
			}
		}
		
	}

	private void initComponents() {
		setTitle("Exclusão de Categorias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Escolha a Categoria a ser Excluida:");
		lblName.setBounds(10, 10, 281, 13);
		contentPane.add(lblName);
		
		comboChoice = new JComboBox();
		comboChoice.setBounds(10, 33, 281, 21);
		contentPane.add(comboChoice);
		
		btnDone = new JButton("Finalizar");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnDonePressed();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		btnDone.setBounds(100, 144, 85, 21);
		contentPane.add(btnDone);
	}
	
	private void btnDonePressed() throws SQLException, IOException {
		List<CategoriaDespesa> categorias = this.categoriaDespensaService.buscarCategoriasDespesa();
		List<CategoriaRendimento> rendimentos = this.categoriaRendimentoService.buscarCategoriasRendimento();
		
		int choice = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta categoria?", "Confirmação", JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			for (CategoriaRendimento rendimento : rendimentos) {
				if (comboChoice.getSelectedItem().equals(rendimento)) {
					this.categoriaRendimentoService.excluirCategoriaRendimento(rendimento.getCodigo());
				}
			}
			for (CategoriaDespesa despesa : categorias) {
				if (comboChoice.getSelectedItem().equals(despesa)) {
					this.categoriaRendimentoService.excluirCategoriaRendimento(despesa.getCodigo());
				}
			}
			
		}
		this.setVisible(false);
	}
	
	
}
