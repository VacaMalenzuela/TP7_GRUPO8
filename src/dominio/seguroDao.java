package dominio;

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
			String query = "Insert into seguros (descripcion,idTipo,costoContratacion,costoAsegurado) values ('"+seg.getDescripcion()+"',"+seg.getIdTipo()+","+ seg.getCostoContratacion()+","+ seg.getCostoAsegurado()+");";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	
	}
	
	public ArrayList<Seguro> obtenerSeguros() {

		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idSeguro,descripcion,idTipo,costoContratacion,costoAsegurado FROM seguros");
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setId(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setCostoContratacion(rs.getDouble("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getDouble("costoAsegurado"));
				
				lista.add(seguroRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}

	
	
	public Seguro obtenerUnSeguro(int id)
	{

		Seguro seguro = new Seguro();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("Select * from seguros where idSeguro = ?");
			miSentencia.setInt(1, id); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			seguro.setId(resultado.getInt(1));
			seguro.setDescripcion(resultado.getString(2));
			seguro.setIdTipo(resultado.getInt(3));
			seguro.setCostoContratacion(resultado.getDouble(4));
			seguro.setCostoAsegurado(resultado.getDouble(5));
		    
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		return seguro;
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
