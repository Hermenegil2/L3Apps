package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Funcionario;
import py.edu.facitec.l3.model.Proveedor;
import py.edu.facitec.l3.util.ConexionManager;

public class FuncionarioDao {
	 public static Funcionario buscarFuncionarioId(int codigo){
	  	   String sql="SELECT  nombre, apellido FROM bd_funcionario where id="+codigo+";";
	  	   
	  	  ConexionManager.abrirConexion();
	  	 Funcionario funcionario=null;
	  	  try {
				ResultSet rs=ConexionManager.sentencia.executeQuery(sql);
				
				if(rs.next()){
					funcionario=new Funcionario();
					funcionario.setNombre(rs.getString("nombre"));
					funcionario.setApellido(rs.getString("apellido"));
					
					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	  	  ConexionManager.cerrarConexion();
	  	  return funcionario;
	  	  
	     }
}
