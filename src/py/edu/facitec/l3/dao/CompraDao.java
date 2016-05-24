package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Proveedor;
import py.edu.facitec.l3.util.ConexionManager;



public class CompraDao {
	
	
	 public static Proveedor buscarProveedorId(int codigo){
  	   String sql="select nombrecompania,direccion from bd_proveedor where codigo="+codigo+";";
  	   
  	  ConexionManager.abrirConexion();
  	 Proveedor proveedor=null;
  	  try {
			ResultSet rs=ConexionManager.sentencia.executeQuery(sql);
			
			if(rs.next()){
				proveedor=new Proveedor();
				proveedor.setNombreCompañia(rs.getString("nombrecompania"));
				proveedor.setDireccion(rs.getString("direccion"));
				
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
  	  ConexionManager.cerrarConexion();
  	  return proveedor;
  	  
  	  
     }
     

}
