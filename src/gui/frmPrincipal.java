package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mantenimiento.GestionEstado;
import mantenimiento.GestionReporte;
import mantenimiento.GestionVehiculo;
import mantenimiento.GestionUsuario;
import model.EstadoEntity;
import model.ReporteEntity;
import model.VehiculoEntity;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;
import util.MySqlConexion;
import util.ReporteRepositorio;
import model.UsuarioEntity;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Object pnlPrincipal_2;
	private JPanel contentPane;
	private JTextField txtPlacaIngreso;
	private JTextField txtPlacaSalida;
	private JTextField txtUsuarioU;
	private JTextField txtClaveU;
	private JTextField txtNombreU;
	private JTable tblUsuario;
	private JComboBox<String> cboEstadoU;
	private JScrollPane scpUsuario;
	private JButton btnBuscar_Ingreso;
	private JButton btnRegistrar_Cliente;
	private JRadioButton rbdVehiculo;
	private JRadioButton rdbMoto;
	private JButton btnRetirar;

	// ListaGlobal
	int filaSeleccionada = -1;
	LocalDateTime fecha = null;
	public static final String DEST = "proyecto/hello_world.pdf";
	private JPanel jpanelReporte;

	DefaultTableModel modeloUsuario = new DefaultTableModel();
	ArrayList<EstadoEntity> lisEstado = new ArrayList<EstadoEntity>();
	ArrayList<VehiculoEntity> lisVehiculo = new ArrayList<VehiculoEntity>();

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1196, 648);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		Panel pnlPrincipal_1 = new Panel();
		pnlPrincipal_1.setBackground(new Color(51, 51, 51));
		pnlPrincipal_1.setBounds(10, 0, 490, 620);
		contentPane.add(pnlPrincipal_1);
		pnlPrincipal_1.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/3.img.png")));
		lblLogo.setBounds(98, 10, 275, 295);
		pnlPrincipal_1.add(lblLogo);

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

		JButton btnIngresarV = new JButton("Ingresar");
		btnIngresarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String placa = txtPlacaIngreso.getText();

				String tipo = "";

				if (rbdVehiculo.isSelected()) {
					tipo = rbdVehiculo.getText().toString();

				} else if (rdbMoto.isSelected()) {
					tipo = rdbMoto.getText().toString();
				}

				LocalDateTime fecha = LocalDateTime.now();
				java.sql.Timestamp d = java.sql.Timestamp.valueOf(fecha);

				VehiculoEntity Servicio = new VehiculoEntity();
				Servicio.setPlaca(placa);
				Servicio.setTipo(tipo);
				Servicio.setFechaIngreso(d);
				Servicio.setFechaSalida(null);

				GestionVehiculo gs = new GestionVehiculo();
				int resultado = gs.registrarServicio(Servicio);

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, "Registro correcto");
				} else {
					JOptionPane.showMessageDialog(null, "Registro incorrecto");
				}

				String dest = "C:/reportes/ticket.pdf";
				try {

					PdfWriter writer = new PdfWriter(dest);
					PdfDocument pdfDoc = new PdfDocument(writer);
					Document document = new Document(pdfDoc, PageSize.A5);
					pdfDoc.addNewPage();

					Paragraph emp = new Paragraph("PARQUEADERO AUTOCONFIA SAC");
					Paragraph dir = new Paragraph("AV. PERU CALLE 10 MZ:D LTE: 24");
					Paragraph s = new Paragraph("----------------------------------------------------------------");

					emp.setBorder(Border.NO_BORDER);
					emp.setBold();

					Paragraph para1 = new Paragraph(
							"Placa de " + tipo.toLowerCase() + ": " + txtPlacaIngreso.getText());
					Paragraph para2 = new Paragraph("Hora de ingreso: " + d);
					Paragraph pie = new Paragraph("----------------------------------------------------------------");
					Paragraph atencion = new Paragraph("HORARIO DE ATENCION:");
					Paragraph ate1 = new Paragraph("Lunes a Sabado: 9:00 am a 7:00 pm");
					Paragraph ate2 = new Paragraph("Domingo: 9:00 am a 2:00 pm");
					document.add(emp);
					document.add(dir);
					document.add(s);
					document.add(para1);
					document.add(para2);
					document.add(pie);
					document.add(atencion);
					document.add(ate1);
					document.add(ate2);
					document.close();
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
				try {

					if ((new File("c:\\reportes/ticket.pdf")).exists()) {

						Process p = Runtime.getRuntime()
								.exec("rundll32 url.dll,FileProtocolHandler c:\\reportes/ticket.pdf");
						p.waitFor();

					} else {

						System.out.println("File is not exists");

					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		btnIngresarV.setBounds(208, 462, 228, 50);
		panel_1.add(btnIngresarV);

		rbdVehiculo = new JRadioButton("Vehiculo");
		rbdVehiculo.setForeground(SystemColor.desktop);
		rbdVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		rbdVehiculo.setBounds(186, 396, 133, 21);
		panel_1.add(rbdVehiculo);

		rdbMoto = new JRadioButton("Moto");
		rdbMoto.setForeground(SystemColor.desktop);
		rdbMoto.setBounds(336, 396, 133, 21);
		panel_1.add(rdbMoto);

		JLabel lblTipoDeVehicuo = new JLabel("Tipo de vehicuo");
		lblTipoDeVehicuo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDeVehicuo.setBounds(264, 333, 139, 39);
		panel_1.add(lblTipoDeVehicuo);

		txtPlacaIngreso = new JTextField();
		txtPlacaIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlacaIngreso.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtPlacaIngreso.setColumns(10);
		txtPlacaIngreso.setBounds(186, 176, 250, 74);
		panel_1.add(txtPlacaIngreso);

		btnBuscar_Ingreso = new JButton("Buscar");
		btnBuscar_Ingreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String placa = txtPlacaIngreso.getText();

				if (placa.isEmpty()) {
					aviso("El campo placa está vacío");
				}

			}
		});
		btnBuscar_Ingreso.setBounds(482, 174, 146, 74);
		panel_1.add(btnBuscar_Ingreso);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(247, 126, 123, 39);
		panel_1.add(lblPlaca);

		JLabel lblTitulo_Ingreso = new JLabel("Modulo de ingreso de vehiculos al parqueadero");
		lblTitulo_Ingreso.setForeground(new Color(255, 204, 51));
		lblTitulo_Ingreso.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblTitulo_Ingreso.setBounds(10, 10, 562, 67);
		panel_1.add(lblTitulo_Ingreso);

		btnRegistrar_Cliente = new JButton("Registrar");
		btnRegistrar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (arg0.getSource() == btnRegistrar_Cliente) {
					/*
					 * Inicializo y muestro la segunda pantalla con los argumentos this (JFrame) y
					 * true (modal)
					 */
					IngresoClientes secundaria = new IngresoClientes();
					secundaria.setVisible(true);
				}
			}
		});
		btnRegistrar_Cliente.setBounds(482, 281, 146, 74);
		panel_1.add(btnRegistrar_Cliente);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 695, 610);
		panel_2.setBackground(new Color(0, 153, 153));
		pnlPrincipal_2.add(panel_2);
		panel_2.setLayout(null);

		txtPlacaSalida = new JTextField();
		txtPlacaSalida.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlacaSalida.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtPlacaSalida.setColumns(10);
		txtPlacaSalida.setBounds(172, 199, 283, 74);
		panel_2.add(txtPlacaSalida);

		btnRetirar = new JButton("Retirar");
		btnRetirar.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {

				LocalDateTime fecha1 = LocalDateTime.now();
				java.sql.Timestamp fechaSalida = java.sql.Timestamp.valueOf(fecha1);

				Connection cn = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;

				try {
					int resultado = 0;
					Double valorAPagar = 0.0;

					cn = MySqlConexion.getConexion();

					String mysql = "CALL usp_buscar_vehiculo('" + txtPlacaSalida.getText() + "')";
					pstm = cn.prepareStatement(mysql);
					rs = pstm.executeQuery();
					while (rs.next()) {
						String horaIngreso = rs.getString(1);
						java.sql.Timestamp fechaI = java.sql.Timestamp.valueOf(horaIngreso);
						java.sql.Timestamp date = java.sql.Timestamp.valueOf(fecha1);
						int minuntosACobrar = (int) ((date.getTime() - fechaI.getTime()) / 60000); //Tarifa por minuto
						if (rs.getString(2).equals("Vehiculo")) {
							valorAPagar = minuntosACobrar * 3.20;
						} else if (rs.getString(2).equals("Moto")) {
							valorAPagar = minuntosACobrar * 2.15;
						}
					}
					try {

						String upd = "CALL usp_update_tb_vehiculo('" + fechaSalida + "','No Disponible','" + valorAPagar
								+ "','" + txtPlacaSalida.getText() + "')";
						pstm = cn.prepareStatement(upd);
						resultado = pstm.executeUpdate();

						int mensaje = JOptionPane.showConfirmDialog(null,
								"Valor a pagar:  S/ " + valorAPagar + "\nDesea Imprimir Recibo", "Salida de vehiculo",
								JOptionPane.YES_NO_OPTION);

						if (mensaje == JOptionPane.YES_OPTION) {

							String dest = "C:/reportes/ticketSalida.pdf";
							try {

								PdfWriter writer = new PdfWriter(dest);
								PdfDocument pdfDoc = new PdfDocument(writer);
								Document document = new Document(pdfDoc, PageSize.A5);
								pdfDoc.addNewPage();

								Paragraph emp = new Paragraph("PARQUEADERO AUTOCONFIA SAC");
								Paragraph dir = new Paragraph("AV. PERU CALLE 10 MZ:D LTE: 24");
								Paragraph s = new Paragraph(
										"----------------------------------------------------------------");
								emp.setBorder(Border.NO_BORDER);
								emp.setBold();

								Paragraph para1 = new Paragraph("Placa de vehiculo: " + txtPlacaSalida.getText());
								Paragraph para2 = new Paragraph("Hora de salida: " + fechaSalida);
								Paragraph para3 = new Paragraph("Total a pagar S/ : " + valorAPagar);

								Paragraph pie = new Paragraph(
										"----------------------------------------------------------------");
								Paragraph desp = new Paragraph("Gracias por su preferencia. !Vuelva pronto!)");
								Paragraph atencion = new Paragraph("HORARIO DE ATENCION:");
								Paragraph ate1 = new Paragraph("Lunes a Sabado: 9:00 am a 7:00 pm");
								Paragraph ate2 = new Paragraph("Domingo: 9:00 am a 2:00 pm");
								document.add(emp);
								document.add(dir);
								document.add(s);
								document.add(para1);
								document.add(para2);
								document.add(para3);
								document.add(pie);
								document.add(desp);
								document.add(atencion);
								document.add(ate1);
								document.add(ate2);
								document.close();
							} catch (FileNotFoundException e1) {

								e1.printStackTrace();
							}
							try {

								if ((new File("c:\\reportes/ticketSalida.pdf")).exists()) {

									Process p = Runtime.getRuntime()
											.exec("rundll32 url.dll,FileProtocolHandler c:\\reportes/ticketSalida.pdf");
									p.waitFor();

								} else {

									System.out.println("File is not exists");

								}

							} catch (Exception ex) {
								ex.printStackTrace();
							}

						} else {
							JOptionPane.showMessageDialog(null, "Gracias por su servicios.");
							System.exit(0);
						}

					}

					catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Error conexión ");

					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,
							"El vehiculo no se encuentra en el parqueadero, por favor revise la placa ingresada");

				}
			}
		});
		btnRetirar.setBounds(208, 347, 216, 50);
		panel_2.add(btnRetirar);

		JButton btnBuscarS = new JButton("Buscar");
		btnBuscarS.setBounds(518, 104, 146, 65);
		panel_2.add(btnBuscarS);

		JLabel lblPlacaS = new JLabel("Placa");
		lblPlacaS.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPlacaS.setBounds(270, 104, 104, 39);
		panel_2.add(lblPlacaS);

		JLabel lblTituloS = new JLabel("Modulo de retiro al parqueadero");
		lblTituloS.setForeground(new Color(255, 204, 51));
		lblTituloS.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTituloS.setBounds(10, 10, 433, 57);
		panel_2.add(lblTituloS);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(0, 153, 153));
		panel_3.setBounds(0, 0, 695, 610);
		pnlPrincipal_2.add(panel_3);
		panel_3.setLayout(null);

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GestionReporte REPORTE = new GestionReporte();
				List<ReporteEntity> listReporte = REPORTE.listarReporteVehiculo();

				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listReporte);

				String file = ReporteRepositorio.REPORTE_CLIENTE;

				JasperPrint jasperPrint = GeneradorReporte.generarReporte(file, dataSource, null);

				JRViewer jrViewer = new JRViewer(jasperPrint);

				jrViewer.setPreferredSize(jpanelReporte.getSize());
				jpanelReporte.removeAll();
				jpanelReporte.add(jrViewer);
				jpanelReporte.repaint();
				jpanelReporte.revalidate();

			}
		});
		btnGenerar.setBackground(SystemColor.control);
		btnGenerar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerar.setBounds(556, 11, 105, 30);
		panel_3.add(btnGenerar);

		JLabel lblTitulo = new JLabel("Reporte");
		lblTitulo.setForeground(new Color(255, 204, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTitulo.setBounds(22, 10, 186, 25);
		panel_3.add(lblTitulo);

		jpanelReporte = new JPanel();
		jpanelReporte.setBounds(32, 47, 636, 539);
		panel_3.add(jpanelReporte);

		Panel panel_4 = new Panel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 153, 153));
		panel_4.setBounds(0, 0, 695, 610);
		pnlPrincipal_2.add(panel_4);

		JLabel lblTituloU = new JLabel("Mantenimiento usuarios");
		lblTituloU.setForeground(new Color(255, 204, 0));
		lblTituloU.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTituloU.setBounds(22, 25, 286, 25);
		panel_4.add(lblTituloU);

		scpUsuario = new JScrollPane();
		scpUsuario.setBounds(35, 234, 575, 268);
		panel_4.add(scpUsuario);

		tblUsuario = new JTable();
		tblUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				filaSeleccionada = tblUsuario.getSelectedRow();

				String nombre = tblUsuario.getValueAt(filaSeleccionada, 1).toString();
				String usuario = tblUsuario.getValueAt(filaSeleccionada, 2).toString();
				String clave = tblUsuario.getValueAt(filaSeleccionada, 3).toString();
				cboEstadoU.setSelectedItem(tblUsuario.getValueAt(filaSeleccionada, 4).toString());

				txtNombreU.setText(nombre);
				txtUsuarioU.setText(usuario);
				txtClaveU.setText(clave);

			}
		});
		scpUsuario.setViewportView(tblUsuario);

		// Le asignamos el modelo o estructura que debe tener la tabla
		tblUsuario.setModel(modeloUsuario);

		txtUsuarioU = new JTextField();
		txtUsuarioU.setColumns(10);
		txtUsuarioU.setBounds(162, 111, 448, 22);
		panel_4.add(txtUsuarioU);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblUsuario.setBounds(35, 114, 105, 13);
		panel_4.add(lblUsuario);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblClave.setBounds(35, 143, 80, 13);
		panel_4.add(lblClave);

		txtClaveU = new JTextField();
		txtClaveU.setColumns(10);
		txtClaveU.setBounds(162, 140, 448, 22);
		panel_4.add(txtClaveU);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblEstado.setBounds(35, 172, 128, 18);
		panel_4.add(lblEstado);

		cboEstadoU = new JComboBox<String>();
		cboEstadoU.setBounds(162, 173, 448, 23);
		panel_4.add(cboEstadoU);

		JLabel lblNombreU = new JLabel("Nombre");
		lblNombreU.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNombreU.setBounds(35, 85, 105, 13);
		panel_4.add(lblNombreU);

		txtNombreU = new JTextField();
		txtNombreU.setColumns(10);
		txtNombreU.setBounds(162, 82, 448, 22);
		panel_4.add(txtNombreU);

		JButton btnRegistrarU = new JButton("Registrar");
		btnRegistrarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = txtNombreU.getText();
				String usuario = txtUsuarioU.getText();
				String clave = txtClaveU.getText();

				int posicionComBox = cboEstadoU.getSelectedIndex();
				EstadoEntity estado = lisEstado.get(posicionComBox);

				int id_estado = estado.getIdEstado();

				UsuarioEntity Usuario = new UsuarioEntity();

				Usuario.setNombre(nombre);
				Usuario.setUsuario(usuario);
				Usuario.setClave(clave);
				Usuario.setIdEstado(id_estado);

				GestionUsuario gu = new GestionUsuario();
				int resultado = gu.registrarUsuario(Usuario);

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, "Registro correcto");
				} else {
					JOptionPane.showMessageDialog(null, "Registro incorrecto");
				}

				modeloUsuario.setRowCount(0);
				// limpiarCampos();
				listarUsuarios();

			}
		});
		btnRegistrarU.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrarU.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRegistrarU.setFocusPainted(false);
		btnRegistrarU.setBounds(219, 527, 117, 52);
		panel_4.add(btnRegistrarU);

		JButton btnEditarU = new JButton("Editar");
		btnEditarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (filaSeleccionada >= 0) {

					String nombre = txtNombreU.getText();
					String usuario = txtUsuarioU.getText();
					String clave = txtClaveU.getText();

					int posicionComBox = cboEstadoU.getSelectedIndex();
					EstadoEntity estado = lisEstado.get(posicionComBox);

					int id_estado = estado.getIdEstado();

					UsuarioEntity Usuario = new UsuarioEntity();

					int id = Integer.parseInt(tblUsuario.getValueAt(filaSeleccionada, 0).toString());

					Usuario.setIdUsuario(id);
					Usuario.setNombre(nombre);
					Usuario.setUsuario(usuario);
					Usuario.setClave(clave);
					Usuario.setIdEstado(id_estado);

					GestionUsuario gl = new GestionUsuario();
					int resultado = gl.editarUsuario(Usuario);

					if (resultado == 1) {
						JOptionPane.showMessageDialog(null, "Actualización correcta");
					} else {
						JOptionPane.showMessageDialog(null, "Actualización incorrecta");
					}

					modeloUsuario.setRowCount(0);

					limpiarCampos();
					listarEstado();
					listarUsuarios();

				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
				}

			}
		});
		btnEditarU.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarU.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEditarU.setFocusPainted(false);
		btnEditarU.setBounds(356, 527, 111, 52);
		panel_4.add(btnEditarU);

		JButton btnEliminarU = new JButton("Eliminar");
		btnEliminarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (modeloUsuario.getRowCount() > 0) {
					if (filaSeleccionada >= 0) {

						int id_usuario = Integer.parseInt(tblUsuario.getValueAt(filaSeleccionada, 0).toString());

						GestionUsuario gu = new GestionUsuario();
						int resultado = gu.eliminarUsuario(id_usuario);
						if (resultado == 1) {
							JOptionPane.showMessageDialog(null, "Eliminación correcta");
						} else {
							JOptionPane.showMessageDialog(null, "Eliminación incorrecta");
						}

						modeloUsuario.setRowCount(0);
						limpiarCampos();
						listarUsuarios();

					} else {
						JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
					}
				} else {
					JOptionPane.showMessageDialog(null, "La tabla no tiene registros");
				}

			}
		});
		btnEliminarU.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminarU.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEliminarU.setFocusPainted(false);
		btnEliminarU.setBounds(488, 527, 117, 52);
		panel_4.add(btnEliminarU);

		JButton btnIngresar = new JButton("Ingresar \r\nVehiculos");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPrincipal_2.removeAll();
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();
				pnlPrincipal_2.revalidate();
				pnlPrincipal_2.add(panel_1);
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();
			}
		});
		btnIngresar.setBounds(88, 315, 142, 62);
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
		btnSalida.setBounds(266, 315, 142, 62);
		pnlPrincipal_1.add(btnSalida);

		JLabel lblCopy = new JLabel("Copyright 2022");
		lblCopy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCopy.setForeground(new Color(255, 255, 255));
		lblCopy.setBounds(212, 563, 130, 40);
		pnlPrincipal_1.add(lblCopy);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(88, 491, 142, 62);
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
		btnReportes.setBounds(88, 403, 142, 62);
		pnlPrincipal_1.add(btnReportes);

		JButton btnMantenimiento = new JButton("Mantenimiento");
		btnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPrincipal_2.removeAll();
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();

				pnlPrincipal_2.add(panel_4);
				pnlPrincipal_2.repaint();
				pnlPrincipal_2.revalidate();
			}
		});
		btnMantenimiento.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMantenimiento.setBounds(266, 403, 142, 62);
		pnlPrincipal_1.add(btnMantenimiento);

		modeloUsuario.addColumn("IdUsuario");
		modeloUsuario.addColumn("Nombre");
		modeloUsuario.addColumn("Usuario");
		modeloUsuario.addColumn("Clave");
		modeloUsuario.addColumn("Estado");

		// listar Usuarios
		listarUsuarios();

		// listar Estados
		listarEstado();

		// limpiar
		pnlPrincipal_2.removeAll();
	}

	public void listarUsuarios() {

		GestionUsuario gu = new GestionUsuario();
		ArrayList<UsuarioEntity> listadoUsuarios = gu.listadoUsuarios();

		for (int i = 0; i < listadoUsuarios.size(); i++) {

			UsuarioEntity usuarios = listadoUsuarios.get(i);

			int id = usuarios.getIdUsuario();

			String nombre = usuarios.getNombre();
			String usuario = usuarios.getUsuario();
			String clave = usuarios.getClave();
			String estado = usuarios.getEstado();

			Object datos[] = { id, nombre, usuario, clave, estado };
			modeloUsuario.addRow(datos);

		}

	}

	public void limpiarCampos() {

		txtNombreU.setText("");
		txtUsuarioU.setText("");
		txtClaveU.setText("");
		cboEstadoU.setSelectedIndex(0);

	}

	public void listarEstado() {

		GestionEstado gestionEstado = new GestionEstado();
		lisEstado = gestionEstado.listarEstado();

		for (int i = 0; i < lisEstado.size(); i++) {

			String nombreEstado = lisEstado.get(i).getDesEstado();
			cboEstadoU.addItem(nombreEstado);

		}
	}

	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Aviso", 2);
	}
}
