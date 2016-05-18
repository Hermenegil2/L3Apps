package py.edu.facitec.l3.model;

/**
 * 
 * @author Hermenegildo Alvarenga
 *
 */
public class Proveedor {
	private int codigo;
	private String nombreCompañia;
	private String nombreContacto;
	private String direccion;
	private int ciudad;
	private int telefono;
	private int celular;
	private String email;
	private int ruc_o_cedula;
	private int cargo;
	private int pais;
	
	public Proveedor() {
		super();
		codigo=0;
		nombreCompañia="";
		nombreContacto="";
		direccion="";
		ciudad=0;
		telefono=0;
		celular=0;
		email="";
		ruc_o_cedula=0;
		cargo=0;
		pais=0;
	}

	public Proveedor(int codigo, String nombreCompañia, String nombreContacto,
			String direccion, int ciudad, int telefono, int celular,
			String email, int ruc_o_cedula, int cargo, int pais) {
		super();
		this.codigo = codigo;
		this.nombreCompañia = nombreCompañia;
		this.nombreContacto = nombreContacto;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.celular = celular;
		this.email = email;
		this.ruc_o_cedula = ruc_o_cedula;
		this.cargo = cargo;
		this.pais = pais;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreCompañia() {
		return nombreCompañia;
	}

	public void setNombreCompañia(String nombreCompañia) {
		this.nombreCompañia = nombreCompañia;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRuc_o_cedula() {
		return ruc_o_cedula;
	}

	public void setRuc_o_cedula(int ruc_o_cedula) {
		this.ruc_o_cedula = ruc_o_cedula;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}
	
	
	
	
}
