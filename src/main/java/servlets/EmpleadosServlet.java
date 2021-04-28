package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import modelos.Departamentos;
import modelos.Empleados;
import java.util.*;
import daos.EmpleadoDAO;
import utilidades.HibernateUtil;

/**
 * Servlet implementation class EmpleadosServlet
 */
@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Session s;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		s = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append("Servlet Empleados");
		List<Empleados> empl = EmpleadoDAO.getAllEmployees(s);
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Empleados</title>");
		writer.println("</head>");
		
		writer.println("<body>");
			writer.println("<h2>EMPLEADOS</h2>");
			
			writer.println("<table style='border: 1px black solid'>");
			writer.println("<tr style='border: 1px black solid'>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Codigo");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Nombre");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Apellido 1");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Apellido 2");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Lugar de Nacimiento");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Fecha de Nacimiento");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Direccion");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Telefono");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Puesto");
			writer.println("</th>");
			writer.println("<th style='border: 1px black solid'>");
				writer.println("Codigo departamento");
			writer.println("</th>");
			writer.println("</tr>");
			Iterator<Empleados> it = empl.iterator();
			while(it.hasNext()) {
				Empleados emplead = it.next();
				writer.println("<tr style='border: 1px black solid'>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getCodigo());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getNombre());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getApellido1());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getApellido2());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getLugar_nacimiento());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getFecha_nacimiento());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getDireccion());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getTelefono());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getPuesto());
				writer.println("</td>");
				writer.println("<td style='border: 1px black solid'>");
					writer.println(emplead.getCod_departamento());
				writer.println("</td>");
				writer.println("</tr>");
			}
			
		writer.println("</table>");
		writer.println("</body>");
		
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
