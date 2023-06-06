package inmobiliaria;

import javax.swing.JOptionPane;
import java.sql.*;

//definicion de la clase
public class insertardatos {
	
	//funcion principal de arranque: insertar datos
    public static void main(String[] args) throws SQLException {
        insertardatos insert = new insertardatos();
        insert.MySQLInsert();
    }
    
    Statement comando = null;
        
    public Statement MySQLInsert() {
        try {
            System.out.println("INICIO DE EJECUCIÓN.");
            Class.forName("com.mysql.cj.jdbc.Driver");
            
    		conexion conex = new conexion();
    		//st es una variable de tipo estado y ejecuta un update
            Statement st = conex.MySQLConnect().createStatement();
            //SENTENCIA INSERT: insercion de valores en BBDD
            st.executeUpdate("INSERT INTO viviendas (`codigovivienda`, `tipo`, `zona`, `direccion`, `habitaciones`, `precio`, `tamano`, `extras`, `observaciones`, `codprop`, `codcom`) "
            		+ "VALUES (NULL, '" + vivienda.tipo + "', '" + vivienda.zona + "', '"+vivienda.textFielddireccion.getText()+"', '"+vivienda.habitaciones+"', '"+vivienda.textFieldprecio.getText()+"', '"+vivienda.textFieldtamano.getText()+"', '"+vivienda.mensaje+"', '"+vivienda.textFieldobservaciones.getText()+"', '"+ vivienda.propietario +"', '"+ vivienda.comercial+"')");
            ResultSet rs = st.executeQuery("SELECT * FROM viviendas");
            if (rs != null) {
                System.out.println("El listado de viviendas es el siguiente:");
 
                while (rs.next()) {
                    System.out.println("  codigovivienda: " + rs.getObject("codigovivienda"));
                    System.out.println("  tipo: " + rs.getObject("tipo"));
                    System.out.println("  zona: " + rs.getObject("zona"));
                    System.out.println("  direccion: " + rs.getObject("direccion"));                    
                    System.out.println("  habitaciones: " + rs.getObject("habitaciones"));
                    System.out.println("  precio: " + rs.getObject("precio"));                    
                    System.out.println("  tamaño: " + rs.getObject("tamano")); 
                    System.out.println("  extras: " + rs.getObject("extras")); 
                    System.out.println("  observaciones: " + rs.getObject("observaciones"));
                    System.out.println("  propiterario: " + rs.getObject("codprop"));
                    System.out.println("  codcom: " + rs.getObject("codcom"));
                    System.out.println("- ");
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
