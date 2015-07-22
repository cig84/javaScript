package clasesServices;

import clasesDAO.DepartmentsDAO;
import dataBaseHR.Departments;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public class DepartmentsServices {
	
	private static DepartmentsDAO dDAO = null;
	private final static Logger log = LogManager.getRootLogger();
	
	public DepartmentsServices() {	
		
		log.trace("se crea el objeto DepartmentsDAO");
		this.dDAO = new DepartmentsDAO();
		
	}	

	public ArrayList<Departments> listarDepartamentos() {

		log.trace("entra en el método listarDepartamentos");
		ArrayList<Departments> listaDepartamento = new ArrayList<Departments>();
		listaDepartamento.addAll(this.dDAO.obtenerDepartamentos());
		return listaDepartamento;
	}

}
