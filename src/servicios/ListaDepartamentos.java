package servicios;

import clasesServices.DepartmentsServices;
import dataBaseHR.Departments;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Servlet implementation class ListaDepartamentos
 */

public class ListaDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.trace("Estamos en el doGet de la clase ListaDepartamentos");
		PrintWriter out = null;
		
		DepartmentsServices deptService = new DepartmentsServices();
		List<Departments> ld = deptService.listarDepartamentos();
		Departments dept = new Departments();
		Iterator it = ld.iterator();
		
		
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		
		out = response.getWriter();
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
		out.println("<listadepartamentos>");
		while (it.hasNext())
		{
			dept = (Departments) it.next();
			System.out.println((dept.getDepartmentId() + " " + dept.getDepartmentName()));
			out.println("<departamento>");
			out.println("<id>"+ dept.getDepartmentId()+"</id>");
			out.println("<nombre>"+dept.getDepartmentName()+"</nombre>");
			out.println("</departamento>");
		}
		out.println("</listadepartamentos>");
		
	}

}
