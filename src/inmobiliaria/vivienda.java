package inmobiliaria;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane; 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vivienda extends JFrame {
	
	// variables
	public static JPanel contentPane;
	public static JTextField textFielddireccion;
	public static JComboBox comboBoxtipo;
	public static String tipo;
	public static JComboBox comboBoxzona;
	public static String zona;
	public static JComboBox comboBoxhabitaciones;
	public static String habitaciones;
	public static JCheckBox chckbxpiscina;
	public static JCheckBox chckbxgaraje;
	public static JCheckBox chckbxjardin;
	public static JTextField textFieldprecio;
	public static JTextField textFieldtamano;
	public static JTextField textFieldobservaciones;
	//public static JTextField textFieldpropietario;
	public static int comercial;
	public static int propietario;
	//public static JTextField textFieldcodcom;
	public static String mensaje;
	public static int precio;
	public static int tamano;
	private List<Integer> listaIdsPropietarios;
	private List<Integer> listaIdsComerciales;
	
	/**
	 * Lanza la aplicacion.
	 * Funcion de arranque.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vivienda frame = new vivienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame. Crear panel/ventana del formulario
	 */
	public vivienda() {
		
		conexion conex = new conexion();
			
		//BEGIN: ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//END:ventana
		
		//BEGIN:tipo
		JLabel lbltipo = new JLabel("tipo");
		lbltipo.setBounds(20, 11, 46, 14);
		contentPane.add(lbltipo);
		
		JComboBox comboBoxtipo = new JComboBox();
		comboBoxtipo.setBounds(83, 9, 79, 18);
		comboBoxtipo.setModel(new DefaultComboBoxModel(new String[] {"vivienda", "oficina", "local"}));
		contentPane.add(comboBoxtipo);
		//END:tipo
		
		//BEGIN:zona
		JLabel lblzona = new JLabel("zona");
		lblzona.setBounds(230, 11, 46, 14);
		contentPane.add(lblzona);
		
		JComboBox comboBoxzona = new JComboBox();
		comboBoxzona.setBounds(296, 7, 103, 23);
		comboBoxzona.setModel(new DefaultComboBoxModel(new String[] {"centro ciudad", "albayzin", "chana", "zaidin"}));
		contentPane.add(comboBoxzona);
		//END: zona
		
		//BEGIN:direccion
		JLabel lbldireccion = new JLabel("direccion");
		lbldireccion.setBounds(20, 36, 46, 14);
		contentPane.add(lbldireccion);
		
		textFielddireccion = new JTextField();
		textFielddireccion.setBounds(86, 38, 313, 20);
		contentPane.add(textFielddireccion);
		textFielddireccion.setColumns(10);
		//END: direccion
		
		// BEGIN: habitaciones
		JLabel lblhabitaciones = new JLabel("habitaciones");
		lblhabitaciones.setBounds(20, 67, 66, 19);
		contentPane.add(lblhabitaciones);
		
		JComboBox comboBoxhabitaciones = new JComboBox();
		comboBoxhabitaciones.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxhabitaciones.setBounds(86, 67, 76, 22);
		contentPane.add(comboBoxhabitaciones);
		// END: habitaciones
		
		//BEGIN: precio
		JLabel lblprecio = new JLabel("precio");
		lblprecio.setBounds(20, 101, 46, 14);
		contentPane.add(lblprecio);
		
		textFieldprecio = new JTextField();
		textFieldprecio.setBounds(76, 98, 86, 20);
		contentPane.add(textFieldprecio);
		textFieldprecio.setColumns(10);
		textFieldprecio.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
				}
			}
		});
		//END:precio
		
		//BEGIN:tamaño
		JLabel lbltamano = new JLabel("tamaño");
		lbltamano.setBounds(257, 72, 46, 14);
		contentPane.add(lbltamano);
		
		textFieldtamano = new JTextField();
		textFieldtamano.setBounds(313, 69, 86, 20);
		contentPane.add(textFieldtamano);
		textFieldtamano.setColumns(10);
		textFieldtamano.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
				}
			}
		});
		//END:tamaño
		
		//BEGIN:extras
		JLabel lblextras = new JLabel("extras");
		lblextras.setBounds(20, 126, 46, 14);
		contentPane.add(lblextras);
		
		JCheckBox chckbxpiscina = new JCheckBox("piscina");
		chckbxpiscina.setBounds(72, 122, 97, 23);
		contentPane.add(chckbxpiscina);
		
		JCheckBox chckbxgaraje = new JCheckBox("garaje");
		chckbxgaraje.setBounds(179, 122, 97, 23);
		contentPane.add(chckbxgaraje);
		
		JCheckBox chckbxjardin = new JCheckBox("jardin");
		chckbxjardin.setBounds(292, 122, 97, 23);
		contentPane.add(chckbxjardin);
		//END: extras
		
		//BEGIN: observaciones
		JLabel lblobservaciones = new JLabel("observaciones");
		lblobservaciones.setBounds(20, 151, 93, 18);
		contentPane.add(lblobservaciones);
		
		textFieldobservaciones = new JTextField();
		textFieldobservaciones.setBounds(111, 146, 289, 23);
		contentPane.add(textFieldobservaciones);
		textFieldobservaciones.setColumns(10);
		//END: observaciones
		
		//BEGIN: propietario
		JLabel lblpropietario = new JLabel("propietario");
		lblpropietario.setBounds(20, 178, 79, 17);
		contentPane.add(lblpropietario);
		
		JComboBox comboBoxpropietario = new JComboBox();
		comboBoxpropietario.setBounds(121, 176, 86, 20);
		contentPane.add(comboBoxpropietario);
		
		listaIdsPropietarios =new ArrayList<Integer>();
		try {	
			//Connection conexion =DriverManager.getConnection("jdbc:mysql://localhost/inmobiliaria2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");//-> segun tu bd
			//Statement st =conexion.createStatement();
			
			Statement st = conex.MySQLConnect().createStatement();
			ResultSet rs=st.executeQuery("SELECT codprop, nombre, apellidos FROM propietarios");
			
			while(rs.next()){
				comboBoxpropietario.addItem((rs.getString("nombre")+" "+rs.getString("apellidos")));//->un campo a mostrar en el combo
				listaIdsPropietarios.add(rs.getInt("codprop"));//->añado el id a una lista auxiliar
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//END: propietario
		
		//BEGIN: Codigo comercial
		JLabel lblcodcom = new JLabel("codcom");
		lblcodcom.setBounds(20, 227, 46, 14);
		contentPane.add(lblcodcom);
		
		JComboBox comboBoxcomercial = new JComboBox();
		comboBoxcomercial.setBounds(121, 224, 86, 20);
		contentPane.add(comboBoxcomercial);
		
		listaIdsComerciales = new ArrayList<Integer>();
		try {
			//Connection conexion =DriverManager.getConnection("jdbc:mysql://localhost/inmobiliaria2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");//-> segun tu bd
			//Statement st =conexion.createStatement();
			
			Statement st = conex.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT codcom, nombre, apellidos FROM comercial");
			
			while(rs.next()) {
				comboBoxcomercial.addItem((rs.getString("nombre")+" "+rs.getString("apellidos")));//->un campo a mostrar en el combo
				listaIdsComerciales.add(rs.getInt("codcom"));//->añado el id a una lista auxiliar
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//END: codigo comercial
		
		//BEGIN: boton insertar
		JButton btnNewButtoninsertar = new JButton("insertar");
		btnNewButtoninsertar.setBounds(311, 202, 89, 23);
		contentPane.add(btnNewButtoninsertar);
		btnNewButtoninsertar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				//validacion del formulario
				if (textFielddireccion.getText().length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "El campo Dirección no puede estar vacío");
				} else if (textFieldprecio.getText().length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "El campo Precio no puede estar vacío");
				} else if (textFieldtamano.getText().length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "El campo Tamaño no puede estar vacío");
				} 
				
				mensaje = "";
				if (chckbxpiscina.isSelected() == true || chckbxjardin.isSelected() == true || chckbxgaraje.isSelected() == true) {
					if (chckbxpiscina.isSelected()) {
						mensaje += "Piscina,";
					}
					if (chckbxjardin.isSelected()) {			
						mensaje += "Jardin,";
					}
					if (chckbxgaraje.isSelected()) {					
						mensaje += "Garaje,";
					}
					//borra el ultimo caracter del string, la coma 
					//"Piscina,Jardin," => "Piscina,Jardin" 
					mensaje = mensaje.substring(0, mensaje.length() -1);
				}
				
				//transformacion combobox seleccionado en texto
				tipo = comboBoxtipo.getSelectedItem().toString();
				zona = comboBoxzona.getSelectedItem().toString();
				habitaciones = comboBoxhabitaciones.getSelectedItem().toString();
				
				int indiceComercial = comboBoxcomercial.getSelectedIndex(); //->cuando pulse el boton el indice del combo coincidira con el indice de la array list auxiliar
				comercial = listaIdsComerciales.get(indiceComercial);
				
				int indicePropietario = comboBoxpropietario.getSelectedIndex(); //->cuando pulse el boton el indice del combo coincidira con el indice de la array list auxiliar
				propietario = listaIdsPropietarios.get(indicePropietario);
								
				//grabado de datos en BBDD pasa por fichero insertardatos.java
				insertardatos insertardatos = new insertardatos();
				insertardatos.MySQLInsert();
			}

		});
		//END:boton insertar
		
		//BEGIN:boton salir
		JButton btnNewButtonsalir = new JButton("salir");
		btnNewButtonsalir.setBounds(311, 227, 89, 23);
		contentPane.add(btnNewButtonsalir);
		btnNewButtonsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
			}
		});
		//END:boton salir
	}
}
	