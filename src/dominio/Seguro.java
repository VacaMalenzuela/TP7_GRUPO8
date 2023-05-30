package dominio;

public class Seguro {
	private int Id;
	private String Descripcion; 
	private tipoSeguro tSeguro; 
	private double CostoContratacion; 
	private double CostoAsegurado;
	
	public Seguro(){}

	
	
	
	
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
	public tipoSeguro getIdTipo() {
		return tSeguro;
	}
	public void setIdTipo(tipoSeguro idTipo) {
		tSeguro = idTipo;
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

	
	@Override
	public String toString() {
		return "Seguro [Id=" + Id + ", Descripcion=" + Descripcion + ", tSeguro=" + tSeguro.getDescripcion() + ", CostoContratacion="
				+ CostoContratacion + ", CostoAsegurado=" + CostoAsegurado + "]";
	}
		
	
}
