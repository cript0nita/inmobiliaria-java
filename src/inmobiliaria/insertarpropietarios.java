package inmobiliaria;

import javax.swing.JOptionPane;
import java.sql.*;

//definicion de la clase
public class insertarpropietarios {
	
	//funcion principal de arranque: insertar datos
    public static void main(String[] args) throws SQLException {
        insertarpropietarios insert = new insertarpropietarios();
        insert.MySQLInsert();
    }
    
    Statement comando = null;
        
    public Statement MySQLInsert() {
        try {
            System.out.println("INICIO DE EJECUCIÓN.");
            Class.forName("com.mysql.cj.jdbc.Driver");
            
    		conexion conex = new conexion();
    		
            Statement st = conex.MySQLConnect().createStatement();
            //SENTENCIA INSERT: insercion de valores en BBDD
            st.executeUpdate("INSERT INTO propietarios (`codprop`, `dni`, `nombre`, `apellidos`, `direccion`, `cp`, `poblacion`, `provincia`) "
            		+ "VALUES (NULL, '" + propietarios.textFielddni.getText() + "', '" + propietarios.textFieldnombre.getText() + "', '"+ propietarios.textFieldapellidos.getText()+"', '"+propietarios.textFielddireccion.getText()+"', '"+propietarios.textFieldcp.getText()+"', '"+propietarios.textFieldpoblacion.getText()+"', '"+propietarios.textFieldprovincia.getText()+"')");
            ResultSet rs = st.executeQuery("SELECT * FROM propietarios");
            if (rs != null) {
                System.out.println("El listado de viviendas es el siguiente:");
 
                while (rs.next()) {
                    System.out.println("  codprop: " + rs.getObject("codprop"));
                   
                }
                rs.close();
            }
            st.close();
 
        }
        catch(SQLException s)
        {
            System.out.println("Error: SQL.");
            System.out.println("SQLException: " + s.getMessage());
        }
        catch(Exception s)
        {
            System.out.println("Error: Varios.");
            System.out.println("Exception: " + s.getMessage());
        }
        System.out.println("FIN DE EJECUCIÓN.");
        return comando;
    }
}
