package py.edu.facitec.l3.model;

public class Funcionario {
		private int id;
		private int cedula;
		private String nombre;
		private String apellido;
		private String direccion;
		private int celular;
		
		
		public Funcionario() {
			super();
			id=0;
			cedula=0;
			nombre="";
			apellido="";
			direccion="";
			celular=0;
		}


		public Funcionario(int id, int cedula, String nombre, String apellido,
				String direccion, int celular) {
			super();
			this.id = id;
			this.cedula = cedula;
			this.nombre = nombre;
			this.apellido = apellido;
			this.direccion = direccion;
			this.celular = celular;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getCedula() {
			return cedula;
		}


		public void setCedula(int cedula) {
			this.cedula = cedula;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public int getCelular() {
			return celular;
		}


		public void setCelular(int celular) {
			this.celular = celular;
		}
		
}
