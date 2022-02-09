package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.JComboBox;

public class frmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
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
	public frmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1196, 648);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		Panel pnlPrincipal_1 = new Panel();
		pnlPrincipal_1.setBackground(new Color(51, 51, 51));
		pnlPrincipal_1.setBounds(0, 0, 490, 620);
		contentPane.add(pnlPrincipal_1);
		pnlPrincipal_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/3.img.png")));
		lblNewLabel.setBounds(98, 10, 275, 295);
		pnlPrincipal_1.add(lblNewLabel);

		Panel pnlPrincipal_2 = new Panel();
		pnlPrincipal_2.setBackground(Color.DARK_GRAY);
		pnlPrincipal_2.setBounds(492, 0, 705, 620);
		contentPane.add(pnlPrincipal_2);
		pnlPrincipal_2.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 695, 610);
		pnlPrincipal_2.add(panel_1);
		panel_1.setBackground(new Color(0, 153, 153));
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 695, 610);
		panel_2.setBackground(new Color(0, 102, 153));
		pnlPrincipal_2.add(panel_2);
		panel_2.setLayout(null);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(153, 204, 204));
		panel_3.setBounds(0, 0, 695, 610);
		pnlPrincipal_2.add(panel_3);
		panel_3.setLayout(null);

		JButton btnIngresar = new JButton("Ingresar \r\nVehiculos");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPrincipal_2.removeAll();
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();

				pnlPrincipal_2.add(panel_1);
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();
			}
		});
		btnIngresar.setBounds(81, 315, 149, 79);
		pnlPrincipal_1.add(btnIngresar);

		JButton btnSalida = new JButton("Salida Vehiculos");
		btnSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPrincipal_2.removeAll();
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();

				pnlPrincipal_2.add(panel_2);
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();
			}
		});
		btnSalida.setBounds(266, 315, 142, 79);
		pnlPrincipal_1.add(btnSalida);

		JLabel lblNewLabel_1 = new JLabel("Copyright 2022 Grupo 3 - LPG1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(140, 563, 275, 32);
		pnlPrincipal_1.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setBounds(208, 486, 228, 50);
		panel_1.add(btnNewButton_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(186, 420, 133, 21);
		panel_1.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(336, 420, 133, 21);
		panel_1.add(rdbtnNewRadioButton_1);

		JLabel lblTipoDeVehicuo = new JLabel("Tipo de vehicuo");
		lblTipoDeVehicuo.setBounds(264, 357, 139, 39);
		panel_1.add(lblTipoDeVehicuo);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(186, 290, 250, 57);
		panel_1.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 174, 250, 74);
		panel_1.add(textField_1);

		JButton btnNewButton_1_1 = new JButton("Buscar");
		btnNewButton_1_1.setBounds(482, 174, 146, 74);
		panel_1.add(btnNewButton_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(482, 100, 139, 50);
		panel_1.add(textField_2);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(288, 124, 47, 39);
		panel_1.add(lblPlaca);

		JLabel lblCapacidadDisponible = new JLabel("Capacidad Disponible");
		lblCapacidadDisponible.setBounds(482, 65, 139, 39);
		panel_1.add(lblCapacidadDisponible);

		JLabel lblNewLabel_2 = new JLabel("Modulo de ingreso de vehiculos al parqueadero");
		lblNewLabel_2.setForeground(new Color(255, 204, 51));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(10, 10, 562, 67);
		panel_1.add(lblNewLabel_2);

		JButton btnNewButton_1_2 = new JButton("Retirar");
		btnNewButton_1_2.setBounds(179, 463, 228, 50);
		panel_2.add(btnNewButton_1_2);

		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1_1.setBounds(307, 397, 133, 21);
		panel_2.add(rdbtnNewRadioButton_1_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(157, 397, 133, 21);
		panel_2.add(rdbtnNewRadioButton_2);

		JLabel lblTipoDeVehicuo_1 = new JLabel("Tipo de vehicuo");
		lblTipoDeVehicuo_1.setBounds(235, 334, 139, 39);
		panel_2.add(lblTipoDeVehicuo_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(157, 267, 250, 57);
		panel_2.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(157, 151, 250, 74);
		panel_2.add(textField_4);

		JButton btnNewButton_1_1_1 = new JButton("Buscar");
		btnNewButton_1_1_1.setBounds(453, 151, 146, 74);
		panel_2.add(btnNewButton_1_1_1);

		JLabel lblPlaca_1 = new JLabel("Placa");
		lblPlaca_1.setBounds(259, 101, 47, 39);
		panel_2.add(lblPlaca_1);

		JLabel lblNewLabel_2_1 = new JLabel("Modulo de retiro al parqueadero");
		lblNewLabel_2_1.setForeground(new Color(255, 204, 51));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(10, 10, 433, 57);
		panel_2.add(lblNewLabel_2_1);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(557, 45, 105, 38);
		panel_3.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Generar");
		btnNewButton_2.setBounds(425, 549, 105, 38);
		panel_3.add(btnNewButton_2);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(557, 549, 105, 38);
		panel_3.add(btnLimpiar);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(35, 58, 91, 25);
		panel_3.add(lblNewLabel_3);

		textField_5 = new JTextField();
		textField_5.setBounds(94, 55, 137, 28);
		panel_3.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Tipo reporte");
		lblNewLabel_3_1.setBounds(241, 58, 91, 25);
		panel_3.add(lblNewLabel_3_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(320, 58, 186, 25);
		panel_3.add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("Reportes");
		lblNewLabel_4.setForeground(new Color(255, 204, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_4.setBounds(22, 10, 186, 25);
		panel_3.add(lblNewLabel_4);

		TextArea textArea = new TextArea();
		textArea.setBounds(35, 105, 627, 418);
		panel_3.add(textArea);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(266, 419, 142, 79);
		pnlPrincipal_1.add(btnSalir);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPrincipal_2.removeAll();
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();

				pnlPrincipal_2.add(panel_3);
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();
			}
		});
		btnReportes.setBounds(81, 419, 149, 79);
		pnlPrincipal_1.add(btnReportes);
	}
}
