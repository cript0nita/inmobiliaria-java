package inmobiliaria;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class visitas extends JFrame {

	public static JPanel contentPane;
	public static JTextField textFieldfecha;
	public static JTextField textFieldcomercial;
	private List<Integer> listaIdsPropietarios;
	private List<Integer> listaIdsComerciales;
	private List<Integer> listaIdsViviendas;
	private List<Integer> listaIdsCompradores;
	public static int comercial;
	public static int propietario;
	public static int vivienda;
	public static int comprador;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visitas frame = new visitas();
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
	public visitas() {

		conexion conex = new conexion();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// BEGIN: fecha visita
		JLabel lblNewLabelfechavisita = new JLabel("fecha visita");
		lblNewLabelfechavisita.setBounds(27, 11, 55, 14);
		contentPane.add(lblNewLabelfechavisita);

		textFieldfecha = new JTextField();
		textFieldfecha.setBounds(121, 8, 133, 20);
		contentPane.add(textFieldfecha);
		textFieldfecha.setColumns(10);
		// END: fecha visita

		// BEGIN: propietario
		JLabel lblpropietario = new JLabel("propietario");
		lblpropietario.setBounds(27, 147, 79, 17);
		contentPane.add(lblpropietario);

		JComboBox comboBoxpropietario = new JComboBox();
		comboBoxpropietario.setBounds(121, 145, 133, 20);
		contentPane.add(comboBoxpropietario);

		listaIdsPropietarios = new ArrayList<Integer>();
		try {
			// Connection conexion
			// =DriverManager.getConnection("jdbc:mysql://localhost/inmobiliaria2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			// "root", "");//-> segun tu bd
			// Statement st =conexion.createStatement();

			Statement st = conex.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT codprop, nombre, apellidos FROM propietarios");

			while (rs.next()) {
				comboBoxpropietario.addItem((rs.getString("nombre") + " " + rs.getString("apellidos")));// ->un campo a
																										// mostrar en el
																										// combo
				listaIdsPropietarios.add(rs.getInt("codprop"));// ->añado el id a una lista auxiliar
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// END: propietario

		// BEGIN: vivienda
		JLabel lblvivienda = new JLabel("Vivienda");
		lblvivienda.setBounds(27, 52, 79, 17);
		contentPane.add(lblvivienda);

		JComboBox comboBoxvivienda = new JComboBox();
		comboBoxvivienda.setBounds(121, 50, 133, 20);
		contentPane.add(comboBoxvivienda);

		listaIdsViviendas = new ArrayList<Integer>();
		try {
			// Connection conexion
			// =DriverManager.getConnection("jdbc:mysql://localhost/inmobiliaria2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			// "root", "");//-> segun tu bd
			// Statement st =conexion.createStatement();

			Statement st = conex.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM viviendas");

			while (rs.next()) {
				comboBoxvivienda.addItem((rs.getString("direccion") + " " + rs.getString("tamano")));// ->un campo a
																										// mostrar en el
																										// combo
				listaIdsViviendas.add(rs.getInt("codigovivienda"));// ->añado el id a una lista auxiliar
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// END: vivienda
		
		// BEGIN: compradores
		JLabel lblcompradores = new JLabel("compradores");
		lblcompradores.setBounds(29, 96, 86, 20);
		contentPane.add(lblcompradores);

		JComboBox comboBoxcompradores = new JComboBox();
		comboBoxcompradores.setBounds(121, 96, 133, 20);
		contentPane.add(comboBoxcompradores);

		listaIdsCompradores = new ArrayList<Integer>();
		try {
			// Connection conexion
			// =DriverManager.getConnection("jdbc:mysql://localhost/inmobiliaria2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			// "root", "");//-> segun tu bd
			// Statement st =conexion.createStatement();

			Statement st = conex.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT codcompradores, nombre, apellidos FROM compradores");

			while (rs.next()) {
				comboBoxcompradores.addItem((rs.getString("nombre") + " " + rs.getString("apellidos")));// ->un campo a
																										// mostrar en el
																										// combo
				listaIdsCompradores.add(rs.getInt("codcompradores"));// ->añado el id a una lista auxiliar
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// END: compradores
		
		// BEGIN: Codigo comercial
		JLabel lblcomercial = new JLabel("comercial");
		lblcomercial.setBounds(27, 185, 46, 14);
		contentPane.add(lblcomercial);

		JComboBox comboBoxcomercial = new JComboBox();
		comboBoxcomercial.setBounds(121, 176, 133, 23);
		contentPane.add(comboBoxcomercial);

		listaIdsComerciales = new ArrayList<Integer>();
		try {
			// Connection conexion
			// =DriverManager.getConnection("jdbc:mysql://localhost/inmobiliaria2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			// "root", "");//-> segun tu bd
			// Statement st =conexion.createStatement();

			Statement st = conex.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT codcom, nombre, apellidos FROM comercial");

			while (rs.next()) {
				comboBoxcomercial.addItem((rs.getString("nombre") + " " + rs.getString("apellidos")));// ->un campo a
																										// mostrar en el
																										// combo
				listaIdsComerciales.add(rs.getInt("codcom"));// ->añado el id a una lista auxiliar
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// END: codigo comercial
		
		// BEGIN: boton insertar
		JButton btnNewButtoninsertar = new JButton("insertar");
		btnNewButtoninsertar.setBounds(311, 202, 89, 23);
		contentPane.add(btnNewButtoninsertar);
		btnNewButtoninsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indiceComercial = comboBoxcomercial.getSelectedIndex(); //->cuando pulse el boton el indice del combo coincidira con el indice de la array list auxiliar
				comercial = listaIdsComerciales.get(indiceComercial);
				
				int indicePropietario = comboBoxpropietario.getSelectedIndex(); //->cuando pulse el boton el indice del combo coincidira con el indice de la array list auxiliar
				propietario = listaIdsPropietarios.get(indicePropietario);
				
				int indiceVivienda = comboBoxvivienda.getSelectedIndex(); //->cuando pulse el boton el indice del combo coincidira con el indice de la array list auxiliar
				vivienda = listaIdsViviendas.get(indiceVivienda);

				int indiceComprador = comboBoxcompradores.getSelectedIndex(); //->cuando pulse el boton el indice del combo coincidira con el indice de la array list auxiliar
				comprador = listaIdsCompradores.get(indiceComprador);
				
				// grabado de datos en BBDD pasa por fichero insertardatos.java
				insertarvisitas insertarvisitas = new insertarvisitas();
				insertarvisitas.MySQLInsert();
			}

		});
		// END:boton insertar

		// BEGIN:boton salir
		JButton btnNewButtonsalir = new JButton("salir");
		btnNewButtonsalir.setBounds(311, 227, 89, 23);
		contentPane.add(btnNewButtonsalir);
		btnNewButtonsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// END:boton salir
	}
}
