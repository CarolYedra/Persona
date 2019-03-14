package es.avalon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.Persona;

@WebServlet("/ServletJDBCBorrar")
public class ServletJDBCBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletJDBCBorrar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		persistencia.Persona p = new Persona(nombre);
		try {
			p.borrar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ServletJDBC1");

	}

}