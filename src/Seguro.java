
public class Seguro {
	int Id;
	String Descripcion;
	String TipoSeguro;
	float CostoContratacion;
	float CostoMax;
	
	public Seguro(int id, String descripcion, String tipoSeguro, float costoContratacion, float costoMax) {
		Id = id;
		Descripcion = descripcion;
		TipoSeguro = tipoSeguro;
		CostoContratacion = costoContratacion;
		CostoMax = costoMax;
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
	public String getTipoSeguro() {
		return TipoSeguro;
	}
	public void setTipoSeguro(String tipoSeguro) {
		TipoSeguro = tipoSeguro;
	}
	public float getCostoContratacion() {
		return CostoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		CostoContratacion = costoContratacion;
	}
	public float getCostoMax() {
		return CostoMax;
	}
	public void setCostoMax(float costoMax) {
		CostoMax = costoMax;
	}
	
	
}
