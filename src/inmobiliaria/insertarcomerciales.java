package inmobiliaria;

import javax.swing.JOptionPane;
import java.sql.*;

//definicion de la clase
public class insertarcomerciales {

	// funcion principal de arranque: insertar datos
	public static void main(String[] args) throws SQLException {
		insertarcomerciales insert = new insertarcomerciales();
		insert.MySQLInsert();
	}

	Statement comando = null;

	public Statement MySQLInsert() {
		try {
			System.out.println("INICIO DE EJECUCIÓN.");
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexion conex = new conexion();

			Statement st = conex.MySQLConnect().createStatement();
			// SENTENCIA INSERT: insercion de valores en BBDD
			st.executeUpdate("INSERT INTO comercial (" + "`codcom`, " + "`dni`, " + "`nombre`, " + "`apellidos`, "
					+ "`direccion`, " + "`cp`, " + "`poblacion`, " + "`provincia`" + ") " + "VALUES (NULL, '"
					+ comerciales.textFielddni.getText() + "', '" + comerciales.textFieldnombre.getText() + "', '"
					+ comerciales.textFieldapellidos.getText() + "', '" + comerciales.textFielddireccion.getText()
					+ "', '" + comerciales.textFieldcp.getText() + "', '" + comerciales.textFieldpoblacion.getText()
					+ "', '" + comerciales.textFieldprovincia.getText() + "')");
			ResultSet rs = st.executeQuery("SELECT * FROM comercial");
			if (rs != null) {
				System.out.println("El listado de viviendas es el siguiente:");

				while (rs.next()) {
					System.out.println("  codcom: " + rs.getObject("codcom"));

				}
				rs.close();
			}
			st.close();

		} catch (SQLException s) {
			System.out.println("Error: SQL.");
			System.out.println("SQLException: " + s.getMessage());
		} catch (Exception s) {
			System.out.println("Error: Varios.");
			System.out.println("Exception: " + s.getMessage());
		}
		System.out.println("FIN DE EJECUCIÓN.");
		return comando;
	}
}
