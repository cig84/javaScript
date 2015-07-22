package clasesDAO;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import interfaces.InterfazRecuperable;
import dataBaseHR.Employees;

/**
 * 
 * @author Francesco
 * En esta clase se definen los metodos para acceder a la base de datos. Esta clase implementa la
 * interfaz "interfazRecuperable y extiende la super clase "SuperClaseDAO".
 *
 */

public class EmployeesDAO extends SuperClaseDAO implements InterfazRecuperable {

	public ArrayList<Employees> obtenerEmpleadosporId(String id) {
		
		EmployeesDAO empDAO = new EmployeesDAO();
		Session session = null;
		Transaction trans = null;
		ArrayList<Employees> emps = null;
		try {
			session = SessionManager.obtenerSession();
			trans = session.beginTransaction();
			empDAO.setSession(session);
			emps = empDAO.leerEmpleados(id);
			trans.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		finally {
			SessionManager.cerrar(session);

		}
		return emps;
	}
		
	public ArrayList<Employees> leerEmpleados(String id) {
		
		ArrayList<Employees> emps = (ArrayList<Employees>) getSession().createSQLQuery("Select * from Employees where department_id = " + id).addEntity(Employees.class).list();
		return emps;
	}

	@Override
	public Object leerEmpleado(int n) {
		// TODO Auto-generated method stub
		return null;
	}
}
