package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Articulos;
import py.edu.facitec.l3.model.Funcionario;
import py.edu.facitec.l3.util.ConexionManager;

public class ArticuloDao {
	public static Articulos buscarArticuloId(int codigo){
	  	   String sql="SELECT descripcion, preciounitario, stock  FROM bd_articulos where id="+codigo+";";
	  	   
	  	  ConexionManager.abrirConexion();
	  	 Articulos articulos=null;
	  	  try {
				ResultSet rs=ConexionManager.sentencia.executeQuery(sql);
				
				if(rs.next()){
					articulos=new Articulos();
					articulos.setDescripcion(rs.getString("descripcion"));
					articulos.setPreciounitario(rs.getInt("preciounitario"));
					articulos.setStock(rs.getInt("stock"));
					
					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	  	  ConexionManager.cerrarConexion();
	  	  return articulos;
	  	  
	     
}
}
