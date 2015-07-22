package servicios;

import clasesServices.EmployeesServices;
import dataBaseHR.Employees;
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
 * Servlet implementation class RecuperarEmpleadosPorDepts
 */

public class RecuperarEmpleadosPorDepts extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final static Logger log = LogManager.getRootLogger();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.trace("Estamos en el doGet de la clase RecuperarEmpleadosPorDepts");
		PrintWriter out = null;
		
		EmployeesServices empService = new EmployeesServices();
		String idDept = (String) request.getParameter("dpto");
		Employees emp = new Employees();
		List<Employees> listaEmpleados = empService.obtenerEmplPorDept(idDept);
		Iterator it = listaEmpleados.iterator();
		
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		
		out = response.getWriter();
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
		out.println("<listaempleados>");
		while(it.hasNext()) {
			emp = (Employees) it.next();
			System.out.println((emp.getFirstName() + " " + emp.getLastName()));
			out.println("<id>"+ emp.getEmployeeId()+"</id>");
			out.println("<nombre>"+ emp.getFirstName()+"</nombre>");
			out.println("<apellido>"+ emp.getLastName()+"</apellido>");
			
		}
		out.println("</listaempleados>");

	}

}