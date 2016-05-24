package py.edu.facitec.l3.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionManager {
         private static final String Driver="org.postgresql.Driver";
         private static final String URL="jdbc:postgresql://localhost:5432/bd_proveedor";
         private static final String USER="postgres";
         private static final String PASSWORD="herme66288";
         public static Connection conexion;
         public static java.sql.Statement sentencia;
         
         public static Connection abrirConexion(){
        	 try {
				Class.forName(Driver);
				System.out.println("Succeso en el Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Error en el Driver");
				e.printStackTrace();
			}
        	 try {
				conexion=DriverManager.getConnection(URL, USER, PASSWORD);
				sentencia=conexion.createStatement();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return conexion;
         }
         
         public static void cerrarConexion(){
        	 if(conexion !=null){
        		 try {
					conexion.close();
					sentencia.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
         }
}
