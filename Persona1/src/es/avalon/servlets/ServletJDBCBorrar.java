package es.avalon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.miproyecto.persistencia2.Persona;

@WebServlet("/ServletJDBCBorrar")
public class ServletJDBCBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletJDBCBorrar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		Persona p = new Persona(nombre);
		try {
			p.borrar(nombre);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
		response.sendRedirect("ServletJDBC1");

	}

}