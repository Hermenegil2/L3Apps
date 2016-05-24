package py.edu.facitec.l3.model;

public class Articulos {
           private int id;
           private int cantidad;
           private String descripcion;
           private int preciounitario;
           private int stock;
           private int total;
           
		public Articulos() {
			super();
			id=0;
			cantidad=0;
			descripcion="";
			preciounitario=0;
			stock=0;
			total=0;
		}

		public Articulos(int id, int cantidad, String descripcion,
				int preciounitario, int stock, int total) {
			super();
			this.id = id;
			this.cantidad = cantidad;
			this.descripcion = descripcion;
			this.preciounitario = preciounitario;
			this.stock = stock;
			this.total = total;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getPreciounitario() {
			return preciounitario;
		}

		public void setPreciounitario(int preciounitario) {
			this.preciounitario = preciounitario;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		@Override
		public String toString() {
			return "Articulos [id=" + id + ", cantidad=" + cantidad
					+ ", descripcion=" + descripcion + ", preciounitario="
					+ preciounitario + ", stock=" + stock + ", total=" + total
					+ "]";
		}
           
           
           
}
