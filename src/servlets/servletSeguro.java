package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.seguroDao;


@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas=0;
		try {
			if(request.getParameter("btnAceptar") != null){
				int valorComboBox = Integer.parseInt(request.getParameter("tipoSeguro"));
				double valorCosto = Double.parseDouble(request.getParameter("txtCostoContratacion"));
				double valorMaximoAsegurado = Double.parseDouble(request.getParameter("txtCostoMaximoAsegurado"));
				Seguro seg = new Seguro(); 
				seg.setDescripcion(request.getParameter("txtDescripcion"));
				seg.setIdTipo(valorComboBox);
				seg.setCostoContratacion(valorCosto);
				seg.setCostoAsegurado(valorMaximoAsegurado);
				seguroDao segDao = new seguroDao(); 
				filas = segDao.agregarSeguro(seg);
				request.setAttribute("cantFilas", filas);
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
				rd.forward(request, response);
		}
		}catch(Exception ex) { 
			filas=0;
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
