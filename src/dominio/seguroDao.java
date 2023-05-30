package dominio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class seguroDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";


	public int agregarSeguro(Seguro seg)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into seguros (descripcion,idTipo,costoContratacion,costoAsegurado) values ('"+seg.getDescripcion()+"',"+seg.getIdTipo().getId()+","+ seg.getCostoContratacion()+","+ seg.getCostoAsegurado()+");";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	
	}
	
	public ArrayList<Seguro> obtenerSeguros() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/segurosgroup","root","root");
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idSeguro,descripcion,idTipo,costoContratacion,costoAsegurado FROM seguros");
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setId(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setCostoContratacion(rs.getDouble("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getDouble("costoAsegurado"));
				tipoSeguroDao tsDao = new tipoSeguroDao(); 
				tipoSeguro ts= tsDao.obtenerUnTipoSeguro(rs.getInt("idTipo"));
				seguroRs.setIdTipo(ts);
				
				lista.add(seguroRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}

	
	
	
	
	//Lista de seguros de un solo tipo 
	public ArrayList<Seguro> obtenerSegurosPorTipo(String idtipo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			String query = "Select idSeguro,descripcion,idTipo,costoContratacion,costoAsegurado FROM seguros where idTipo = "+idtipo;
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setId(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setCostoContratacion(rs.getDouble("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getDouble("costoAsegurado"));
				tipoSeguroDao tsDao = new tipoSeguroDao(); 
				tipoSeguro ts= tsDao.obtenerUnTipoSeguro(rs.getInt("idTipo"));
				seguroRs.setIdTipo(ts);
				
				lista.add(seguroRs);
			}
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			
		}
		
		return lista;
	}
	
	/* 
	 DELIMITER $$
	 CREATE PROCEDURE `crearUsuario`(IN Unombre varchar(45), IN Uapellido varchar(45))
	 BEGIN
	 INSERT INTO usuario(nombre,apellido) VALUES (Unombre,Uapellido);
	 END
	 $$ DELIMITER ;
	*/
	
	
}
