package inmobiliaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class login extends JFrame {

	public JPanel contentPane;
	public static JTextField txtIusuario;
	public static JTextField txtcontrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcontrasena = new JLabel("contrasena");
		lblcontrasena.setBounds(86, 94, 77, 14);
		contentPane.add(lblcontrasena);
		
		JLabel lblusuario = new JLabel("usuario");
		lblusuario.setBounds(86, 45, 46, 14);
		contentPane.add(lblusuario);
		
		txtIusuario = new JTextField();
		txtIusuario.setBounds(142, 42, 129, 17);
		contentPane.add(txtIusuario);
		txtIusuario.setColumns(10);
		
		txtcontrasena = new JTextField();
		txtcontrasena.setBounds(161, 91, 123, 20);
		contentPane.add(txtcontrasena);
		txtcontrasena.setColumns(10);
		
		final usuario data= new usuario ();
		
		final menuprincipal formmenuprincipal= new menuprincipal ();
		
		JButton btnlogin = new JButton("login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (data.ProbarUsuario()==1)
				{
					JOptionPane.showMessageDialog(rootPane, "USUARIO CORRECTO");

					formmenuprincipal.setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(rootPane, "Error, usuario o contraseña incorrectos");	
				}
			}
			
		});
		btnlogin.setBounds(74, 138, 89, 23);
		contentPane.add(btnlogin);
		
		JButton btnexit = new JButton("exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);	
			}
		});
		btnexit.setBounds(74, 201, 89, 23);
		contentPane.add(btnexit);
	}
}
