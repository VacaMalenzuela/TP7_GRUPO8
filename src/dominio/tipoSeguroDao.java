package dominio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class tipoSeguroDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	public tipoSeguro obtenerUnTipoSeguro(int id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tipoSeguro seg = new tipoSeguro();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("Select * from tiposeguros where idTipo = ?");
			miSentencia.setInt(1, id); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			seg.setId(resultado.getInt(1));
			seg.setDescripcion(resultado.getString(2));
		    
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida perrrooo");
		}
		finally
		{
		}
		return seg;
	}

}
