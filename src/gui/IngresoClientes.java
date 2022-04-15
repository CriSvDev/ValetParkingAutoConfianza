package gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.ClienteEntity;
import model.VehiculoEntity;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IngresoClientes extends JDialog {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDoi;
	private JTextField txtTelefono;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtPlaca;
	private JTextField txtEmpresa;
	private JComboBox<String> cboTipo;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IngresoClientes() {
		setBounds(100, 100, 732, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		txtDoi = new JTextField();
		txtDoi.setBounds(149, 155, 176, 35);
		contentPanel.add(txtDoi);
		txtDoi.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(149, 206, 176, 35);
		txtTelefono.setColumns(10);
		contentPanel.add(txtTelefono);
		
		JLabel lblNewLabel = new JLabel("DOI");
		lblNewLabel.setBounds(22, 160, 83, 24);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(22, 211, 83, 24);
		contentPanel.add(lblTelefono);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String doi = txtDoi.getText();
				int telefono = Integer.parseInt(txtTelefono.getText());
				String empresa = txtEmpresa.getText();
				
				String placa = txtPlaca.getText();
				String tipo = String.valueOf(cboTipo.getSelectedItem());
				
			
				VehiculoEntity Vehiculo = new VehiculoEntity();
				Vehiculo.setPlaca(placa);
				Vehiculo.setTipo(tipo);
			
				ClienteEntity Cliente = new ClienteEntity();
				Cliente.setNombre(nombre);
				Cliente.setApellido(apellido);
				Cliente.setDoi(doi);
				Cliente.setTelefono(telefono);
				Cliente.setEmpresa(empresa);

					
			}
		});
		btnRegistrar.setBounds(562, 262, 105, 51);
		contentPanel.add(btnRegistrar);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ficha de registro nuevos clientes:");
		lblNewLabel_2_1.setBounds(22, 10, 280, 24);
		contentPanel.add(lblNewLabel_2_1);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(149, 110, 176, 35);
		txtApellido.setColumns(10);
		contentPanel.add(txtApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(22, 115, 83, 24);
		contentPanel.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(149, 65, 176, 35);
		txtNombre.setColumns(10);
		contentPanel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 70, 83, 24);
		contentPanel.add(lblNombre);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(493, 110, 176, 35);
		txtPlaca.setColumns(10);
		contentPanel.add(txtPlaca);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(366, 115, 83, 24);
		contentPanel.add(lblPlaca);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(493, 60, 176, 35);
		txtEmpresa.setColumns(10);
		contentPanel.add(txtEmpresa);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(366, 65, 83, 24);
		contentPanel.add(lblEmpresa);
		
		JLabel lblTipo = new JLabel("Tipo Veh.");
		lblTipo.setBounds(366, 160, 83, 24);
		contentPanel.add(lblTipo);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Vehiculo", "Moto"}));
		cboTipo.setBounds(493, 155, 176, 30);
		contentPanel.add(cboTipo);
	}
}
