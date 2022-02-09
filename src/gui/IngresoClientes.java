package gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class IngresoClientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IngresoClientes dialog = new IngresoClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IngresoClientes() {
		setBounds(100, 100, 600, 409);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(104, 76, 176, 35);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 121, 176, 35);
		contentPanel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Placa");
		lblNewLabel.setBounds(22, 87, 83, 24);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(22, 132, 83, 24);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vigencia in");
		lblNewLabel_2.setBounds(22, 177, 83, 24);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Vigencia Fina");
		lblNewLabel_3.setBounds(22, 222, 83, 24);
		contentPanel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(423, 83, 105, 51);
		contentPanel.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(423, 158, 105, 51);
		contentPanel.add(btnSalir);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ficha de registro nuevos clientes:");
		lblNewLabel_2_1.setBounds(22, 10, 280, 24);
		contentPanel.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(104, 263, 176, 35);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tarifa Mensual");
		lblNewLabel_3_1.setBounds(22, 268, 83, 24);
		contentPanel.add(lblNewLabel_3_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(104, 166, 177, 30);
		contentPanel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(103, 216, 177, 30);
		contentPanel.add(dateChooser_1);
	}
}
