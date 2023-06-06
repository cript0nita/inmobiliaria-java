package inmobiliaria;

import javax.swing.JOptionPane;
import java.sql.*;

public class conexion {
	 
	public static void main(String[] args) {
		conexion db = new conexion();
	    db.MySQLConnect();
	}
	 
	Connection conexion = null;
	Statement comando = null;
	ResultSet registro;

	public Connection MySQLConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String nombre_bbdd = "inmobiliaria2";
			String servidor = "jdbc:mysql://localhost/"+ nombre_bbdd +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String usuario = "root";
			String pass = "";
			conexion = DriverManager.getConnection(servidor, usuario, pass);
           
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} finally {
			return conexion;
       }
   }
}
