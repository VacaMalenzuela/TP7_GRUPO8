package dominio;

public class Seguro {
	
	private int Id;
	private String Descripcion; 
	private int IdTipo; 
	private double CostoContratacion; 
	private double CostoAsegurado;
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
	public int getIdTipo() {
		return IdTipo;
	}
	public void setIdTipo(int idTipo) {
		IdTipo = idTipo;
	}
	public double getCostoContratacion() {
		return CostoContratacion;
	}
	public void setCostoContratacion(double costoContratacion) {
		CostoContratacion = costoContratacion;
	}
	public double getCostoAsegurado() {
		return CostoAsegurado;
	}
	public void setCostoAsegurado(double costoAsegurado) {
		CostoAsegurado = costoAsegurado;
	}

}
