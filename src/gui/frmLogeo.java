package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import util.ConexionUsuario;
import util.HiloCloseLogin;
import util.Usuario;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmLogeo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwdContrasena;
	public JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogeo frame = new frmLogeo();
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
	public frmLogeo() {
		// Ejecución del SubProceso
		
		HiloCloseLogin HiloCloseLogin = new HiloCloseLogin(this);
		Thread thread = new Thread(HiloCloseLogin, "SubProceso Login");
		thread.start();
		
		setBounds(0, 0, 961, 591);
		setAlwaysOnTop(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 952, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground( new Color(47, 79, 79,129));
		panel_1.setBounds(28, 82, 312, 438);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio de sesion");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(20, 91, 187, 32);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_1.add(lblNewLabel_1);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(20, 125, 164, 5);
		panel_2.setBackground(Color.BLUE);
		panel_1.add(panel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(95, 166, 193, 35);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 144, 75, 66);
		lblNewLabel_2.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/1.icon.png")));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(22, 228, 75, 77);
		lblNewLabel_3.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/2.icon.png")));
		panel_1.add(lblNewLabel_3);
		
		pwdContrasena = new JPasswordField();
		pwdContrasena.setBounds(99, 260, 189, 35);
		panel_1.add(pwdContrasena);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground( new Color(47, 79, 79,119));
		panel_3.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		panel_3.setBounds(52, 345, 219, 51);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblIngresar = new JLabel("INGRESAR");
		lblIngresar.setForeground(Color.WHITE);
		lblIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ingresar();
			}
		});
		lblIngresar.setBackground(new Color(0, 0, 128));
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIngresar.setBounds(-15, 0, 234, 55);
		panel_3.add(lblIngresar);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/2.img.png")));
		lblNewLabel_5.setBounds(10, 10, 111, 86);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("Este formulario se cerrar en 10 segundos");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(34, 415, 254, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 952, 555);
		lblNewLabel.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/1.img.jpg")));
		panel.add(lblNewLabel);
	}  

	protected void ingresar() {
		
		HiloCloseLogin hiloCloseLogin = new HiloCloseLogin(null);
		hiloCloseLogin.cancel();
		  
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(pwdContrasena.getPassword());
		
		ConexionUsuario conex = new ConexionUsuario();
		
		Usuario usuario2 = new Usuario();
		usuario2.setNombre(usuario);
		usuario2.setClave(clave);
		
		Usuario us = conex.obtenerUsuario(usuario2);
		
		if (us!=null) {
			JOptionPane.showMessageDialog(contentPane,"Bienvenido "+ us.getNombre());
			
			// Login correcto
			this.setVisible(false);
			frmPrincipal frmPrincipal = new frmPrincipal();
			frmPrincipal.setVisible(true);
	
			
		} else {

			JOptionPane.showConfirmDialog(contentPane,"Datos invalidos el usuario "+"'"+ txtUsuario.getText()+"' " + "no existe");
		}
	}
}
