package es.avalon.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.Persona;

@WebServlet("/ServletJDBC1")
public class ServletJDBC1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Persona> lista = Persona.buscarTodos();
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");

		for (Persona p : lista) {
			pw.println("<p>" + p.getNombre() + " " + p.getApellido() + " " + p.getEdad() + " "
					+ "<a href='ServletJDBCBorrar?nombre=" + p.getNombre() + "'>borrar</a>" + " "
					+ "<a href='ServletJDBCEditar?nombre=" + p.getNombre() + "'>Editar</a>" + "</p>");
		}
		pw.println("<a href='Formulario.html'>ir alformulario</a>");
		pw.println("</html></body>");
	}

}