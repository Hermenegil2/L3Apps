/**
 * 
 */
/**
 * @author Hermenegildo Alvarenga
 *
 */
package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import py.edu.facitec.l3.model.Proveedor;
import py.edu.facitec.l3.util.ConexionManager;

public class ProveedorDao{
	
	public static void registrarProveedor(Proveedor proveedor){
		String sql="INSERT INTO bd_proveedor(codigo, nombrecompania, nombrecontacto, "
				+ "direccion, ciudad, telefono,celular, email, ruc_cedula, cargo, pais)"
				+ " VALUES ("+proveedor.getCodigo()+",'"+proveedor.getNombreCompañia()+"'"
			    + ",'"+proveedor.getNombreContacto()+"','"+proveedor.getDireccion()+"'"
			    + ","+proveedor.getCiudad()+","+proveedor.getTelefono()+","+proveedor.getCelular()+""
			    + ", '"+proveedor.getEmail()+"',"+proveedor.getRuc_o_cedula()+","+proveedor.getCargo()+", "+proveedor.getPais()+");";
		System.out.println(sql);
		ConexionManager.abrirConexion();
		try {
			ConexionManager.sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	
	public static ArrayList<Proveedor> listarProveedor(){
		ArrayList<Proveedor>lista=new ArrayList<>();
		String sql="SELECT * FROM bd_proveedor";
		ConexionManager.abrirConexion();
	    Proveedor proveedor=null;
	    try {
			ResultSet rs=ConexionManager.sentencia.executeQuery(sql);
			while(rs.next()){
				proveedor=new Proveedor();
				proveedor.setCodigo(rs.getInt("codigo"));
				proveedor.setNombreCompañia(rs.getString("nombreCompania"));
				proveedor.setNombreContacto(rs.getString("nombreContacto"));
				proveedor.setDireccion(rs.getString("direccion"));
				proveedor.setCiudad(rs.getInt("ciudad"));
				proveedor.setTelefono(rs.getInt("telefono"));
				proveedor.setCelular(rs.getInt("celular"));
				proveedor.setEmail(rs.getString("email"));
				proveedor.setRuc_o_cedula(rs.getInt("ruc_cedula"));
				proveedor.setCargo(rs.getInt("cargo"));
				proveedor.setPais(rs.getInt("pais"));
				lista.add(proveedor);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ConexionManager.cerrarConexion();
	    return lista;
	}
	public static void modificarProveedor(Proveedor proveedor){
		String sql="UPDATE bd_proveedor SET nombrecompania='"+proveedor.getNombreCompañia()+"', "
				+ "nombrecontacto='"+proveedor.getNombreContacto()+"',"
				+ " direccion='"+proveedor.getDireccion()+"', ciudad="+proveedor.getCiudad()+","
				+ " telefono="+proveedor.getTelefono()+", celular="+proveedor.getCelular()+","
				+ " email='"+proveedor.getEmail()+"', ruc_cedula="+proveedor.getRuc_o_cedula()+", "
				+ "cargo="+proveedor.getCargo()+", pais="+proveedor.getPais()+" WHERE codigo="+proveedor.getCodigo()+"";
				
	System.out.println(sql);
	ConexionManager.abrirConexion();
	try {
		ConexionManager.sentencia.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ConexionManager.cerrarConexion();
	}
	
	public static Proveedor obtenerUltimoId(){
		String sql="select max(codigo)+1 as id from bd_proveedor";
		System.out.println(sql);
		ConexionManager.abrirConexion();
		Proveedor proveedor=null;
		try {
			ResultSet rs=ConexionManager.sentencia.executeQuery(sql);
			if(rs.next()){
				proveedor=new Proveedor();
				proveedor.setCodigoo(rs.getString("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
		return proveedor;
	}
	
}