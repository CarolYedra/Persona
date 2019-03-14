package es.avalon.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.Persona;

@WebServlet("/ServletJDBCSalvar")
public class ServletJDBCSalvar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Persona p = Persona.muestraUnElemento(request.getParameter("nombreOriginal"));
		try {
			p.borrar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Persona p1 = new Persona(request.getParameter("nombre"), request.getParameter("apellido"),
				Integer.parseInt(request.getParameter("edad")));
		p1.insertar();
		response.sendRedirect("ServletJDBC1");

	}

}