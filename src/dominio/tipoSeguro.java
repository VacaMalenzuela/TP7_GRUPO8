package dominio;

public class tipoSeguro {
	@Override
	public String toString() {
		return "tipoSeguro [Id=" + Id + ", Descripcion=" + Descripcion + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	private int Id; 
	private String Descripcion;

}
