package inmobiliaria;

import javax.swing.JOptionPane;
import java.sql.*;

//definicion de la clase
public class insertarcompradores {

	// funcion principal de arranque: insertar datos
	public static void main(String[] args) throws SQLException {
		insertarcompradores insert = new insertarcompradores();
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
			st.executeUpdate("INSERT INTO compradores (" + "`codcompradores`, " + "`dni`, " + "`nombre`, " + "`apellidos`, "
					+ "`direccion`, " + "`cp`, " + "`poblacion`, " + "`provincia`" + ") " + "VALUES (NULL, '"
					+ compradores.textFielddni.getText() + "', '" + compradores.textFieldnombre.getText() + "', '"
					+ compradores.textFieldapellidos.getText() + "', '" + compradores.textFielddireccion.getText()
					+ "', '" + compradores.textFieldcp.getText() + "', '" + compradores.textFieldpoblacion.getText()
					+ "', '" + compradores.textFieldprovincia.getText() + "')");
			ResultSet rs = st.executeQuery("SELECT * FROM compradores");
			if (rs != null) {
				System.out.println("El listado de viviendas es el siguiente:");

				while (rs.next()) {
					System.out.println("  codcompradores: " + rs.getObject("codcompradores"));

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
