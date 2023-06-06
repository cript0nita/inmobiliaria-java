package inmobiliaria;

import javax.swing.JOptionPane;
import java.sql.*;

//definicion de la clase
public class insertarvisitas {

	// funcion principal de arranque: insertar datos
	public static void main(String[] args) throws SQLException {
		insertarvisitas insert = new insertarvisitas();
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
			st.executeUpdate("INSERT INTO visitas (`codvisita`, `fechavisita`, `propietario`, `comercial`, `vivienda`, `comprador`) " 
			+ "VALUES (NULL, '"+ visitas.textFieldfecha.getText() +"', '"+ visitas.propietario +"', '"+ visitas.comercial +"', '"+ visitas.vivienda +"', '"+ visitas.comprador +"')");
			ResultSet rs = st.executeQuery("SELECT * FROM visitas");
			if (rs != null) {
				System.out.println("El listado de viviendas es el siguiente:");

				while (rs.next()) {
					System.out.println("  codvisita: " + rs.getObject("codvisita"));

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
