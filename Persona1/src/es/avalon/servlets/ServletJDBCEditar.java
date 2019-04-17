package es.avalon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.miproyecto.persistencia2.Persona;

@WebServlet("/ServletJDBCEditar")
public class ServletJDBCEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletJDBCEditar() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		Persona p;
		try {
			p = Persona.buscarUno(nombre);
		PrintWriter pw = response.getWriter();
		pw.println("<html><body><form action='ServletJDBCSalvar' method='post'>");
		pw.println("<p>Nombre:<input type='text' name='nombre' value='" + p.getNombre() + "'/></p>");
		pw.println("<input type='hidden' name='nombreOriginal' value='" + p.getNombre() + "'/>");
		pw.println("<p>Apellido:<input type='text' name='apellido' value='" + p.getApellido() + "'/></p>");
		pw.println("<p>Edad:<input type='text' name='edad' value='" + p.getEdad() + "'/></p>");
		pw.println("<input type='submit' value='salvar'/> </form></body></html>");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}