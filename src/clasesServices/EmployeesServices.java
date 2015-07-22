package clasesServices;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import clasesDAO.EmployeesDAO;
import dataBaseHR.Employees;

/**
 * 
 * @author Francesco
 * En esta clase declaramos los métodos a los cuales el usuario puede acceder.
 * Esta clase inicializa un objeto EmployeesDAO que tiene acceso a la base de datos a través de los
 * métodos declarados en la misma clase.
 * Esta clase es la que se encarga de obtener una conección a la base de datos llamando el metodo
 * correspondiente de la clase SessionManager, de declarar el inicio de una transacción y setear
 * la sessión abierta para el objeto EmployeesDAO creado. También se encarga de hacer el commit o
 * el roolback de la transaccíon si hay algún fallo en la ejecución, así como de cerrar la sessión 
 * cuando el metodo llamado haya terminado su ejecución, con o sin fallos.
 *
 */

public class EmployeesServices {
	
	private static EmployeesDAO empDAO = null;
	private final static Logger log = LogManager.getRootLogger();
	
	public EmployeesServices() {
		
		log.trace("se crea el objeto EmployeesDAO");
		this.empDAO = new EmployeesDAO();
	}
	
	
	public ArrayList<Employees> obtenerEmplPorDept(String id) {

		log.trace("entra en el método obtenerEmplPorDept");
		ArrayList<Employees> listaEmpleados = new ArrayList<Employees>();
		listaEmpleados.addAll(this.empDAO.obtenerEmpleadosporId(id));
		return listaEmpleados;
	}
	

}
