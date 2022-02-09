package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmLogeo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
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
		setBounds(0, 0, 952, 565);
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
		panel_1.setBackground( new Color(47, 79, 79,235));
		panel_1.setBounds(28, 82, 340, 418);
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
		
		textField = new JTextField();
		textField.setBounds(95, 166, 193, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 144, 75, 66);
		lblNewLabel_2.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/1.icon.png")));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(22, 228, 75, 77);
		lblNewLabel_3.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/2.icon.png")));
		panel_1.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(99, 260, 189, 35);
		panel_1.add(passwordField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground( new Color(47, 79, 79,235));
		panel_3.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		panel_3.setBounds(34, 363, 265, 45);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("INGRESAR");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmPrincipal p = new frmPrincipal();
				p.setVisible(true);
				dispose();	
			}
		});
		lblNewLabel_4.setBackground(new Color(0, 0, 128));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(0, 0, 265, 45);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/2.img.png")));
		lblNewLabel_5.setBounds(10, 10, 111, 86);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 952, 565);
		lblNewLabel.setIcon(new ImageIcon(frmLogeo.class.getResource("/img/1.img.jpg")));
		panel.add(lblNewLabel);
	}
		
}
