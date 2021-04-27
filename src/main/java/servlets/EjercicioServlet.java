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
import org.hibernate.SessionFactory;

import daos.*;
import utilidades.*;
import java.util.*;
import modelos.*;

/**
 * Servlet implementation class EjercicioServlet
 */
@WebServlet("/EjercicioServlet")
public class EjercicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjercicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		List<Departamentos> dept = DepartamentosDAO.getAllDepartments(s);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//response.getWriter().append(dept.get(0).toString());
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Ejercicio Servlet</title>");
		writer.println("</head>");
		
		writer.println("<body>");
			writer.println("<table style='border: 1px black solid'>");
				writer.println("<tr style='border: 1px black solid'>");
				writer.println("<th style='border: 1px black solid'>");
					writer.println("Codigo");
				writer.println("</th>");
				writer.println("<th style='border: 1px black solid'>");
					writer.println("Nombre");
				writer.println("</th>");
				writer.println("<th style='border: 1px black solid'>");
					writer.println("Codigo responsable");
				writer.println("</th>");
				writer.println("</tr>");
				Iterator<Departamentos> it = dept.iterator();
				while(it.hasNext()) {
					Departamentos depart = it.next();
					writer.println("<tr style='border: 1px black solid'>");
					writer.println("<td style='border: 1px black solid'>");
						writer.println(depart.getCodigo());
					writer.println("</td>");
					writer.println("<td style='border: 1px black solid'>");
						writer.println(depart.getNombre());
					writer.println("</td>");
					writer.println("<td style='border: 1px black solid'>");
						writer.println(depart.getCod_responsable());
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
