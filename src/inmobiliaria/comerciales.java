package inmobiliaria;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class comerciales extends JFrame {
	// variables
	public static JPanel contentPane;
	public static JTextField textFielddni;
	public static JTextField textFieldapellidos;
	public static JTextField textFieldnombre;
	public static JTextField textFielddireccion;
	public static JTextField textFieldcp;
	public static JTextField textFieldpoblacion;
	public static JTextField textFieldprovincia;
	public static JButton btnNewButtonsalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comerciales frame = new comerciales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. crear panel/ventana de propietarios
	 */
	public comerciales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// BEGIN: dni
		JLabel lblNewLabeldni = new JLabel("dni");
		lblNewLabeldni.setBounds(29, 11, 68, 14);
		contentPane.add(lblNewLabeldni);

		textFielddni = new JTextField();
		textFielddni.setBounds(85, 8, 143, 20);
		contentPane.add(textFielddni);
		textFielddni.setColumns(10);
		// END: dni

		// BEGIN:apellidos
		JLabel lblNewLabelapellidos = new JLabel("apellidos");
		lblNewLabelapellidos.setBounds(21, 49, 46, 14);
		contentPane.add(lblNewLabelapellidos);

		textFieldapellidos = new JTextField();
		textFieldapellidos.setBounds(85, 46, 254, 20);
		contentPane.add(textFieldapellidos);
		textFieldapellidos.setColumns(10);
		// END: apellidos

		// BEGIN: nombre
		JLabel lblNewLabelnombre = new JLabel("nombre");
		lblNewLabelnombre.setBounds(21, 89, 46, 14);
		contentPane.add(lblNewLabelnombre);

		textFieldnombre = new JTextField();
		textFieldnombre.setBounds(85, 86, 254, 20);
		contentPane.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		// END: nombre

		// BEGIN: direccion
		JLabel lblNewLabeldireccion = new JLabel("direccion");
		lblNewLabeldireccion.setBounds(21, 128, 46, 14);
		contentPane.add(lblNewLabeldireccion);

		textFielddireccion = new JTextField();
		textFielddireccion.setBounds(84, 125, 255, 20);
		contentPane.add(textFielddireccion);
		textFielddireccion.setColumns(10);
		// END: direccion

		// BEGIN: cp
		JLabel lblNewLabelcp = new JLabel("cp");
		lblNewLabelcp.setBounds(21, 168, 46, 14);
		contentPane.add(lblNewLabelcp);

		textFieldcp = new JTextField();
		textFieldcp.setBounds(85, 165, 143, 20);
		contentPane.add(textFieldcp);
		textFieldcp.setColumns(10);
		// END: cp

		// BEGIN: poblacion
		JLabel lblNewLabelpoblacion = new JLabel("poblacion");
		lblNewLabelpoblacion.setBounds(21, 206, 56, 14);
		contentPane.add(lblNewLabelpoblacion);

		textFieldpoblacion = new JTextField();
		textFieldpoblacion.setBounds(85, 203, 143, 20);
		contentPane.add(textFieldpoblacion);
		textFieldpoblacion.setColumns(10);
		// END: poblacion

		// BEGIN: provincia
		JLabel lblNewLabelprovincia = new JLabel("provincia");
		lblNewLabelprovincia.setBounds(21, 231, 46, 14);
		contentPane.add(lblNewLabelprovincia);

		textFieldprovincia = new JTextField();
		textFieldprovincia.setBounds(85, 228, 143, 20);
		contentPane.add(textFieldprovincia);
		textFieldprovincia.setColumns(10);
		// END: provincia

		// BEGIN: boton insertar
		JButton btnNewButtoninsertar = new JButton("insertar");
		btnNewButtoninsertar.setBounds(311, 202, 89, 23);
		contentPane.add(btnNewButtoninsertar);
		btnNewButtoninsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// grabado de datos en BBDD pasa por fichero insertardatos.java
				insertarcomerciales insertarcomerciales = new insertarcomerciales();
				insertarcomerciales.MySQLInsert();
			}

		});
		// END:boton insertar

		btnNewButtonsalir = new JButton("salir");
		btnNewButtonsalir.setBounds(303, 227, 89, 23);
		contentPane.add(btnNewButtonsalir);

	}
}
