package hibernate.app;

import java.util.List;

import hibernate.app.dao.EmployeeDao;
import hibernate.app.entity.EmployeeEntity;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		System.out.println("test 1");
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeEntity> list = dao.getAllEmployee();
		boolean tieneRegistros = list.size() > 0;
		assertTrue(tieneRegistros);
		assertTrue(list.size() < 10000);
	}

	public void testApp2() {
		System.out.println("test 2");
		assertFalse(false);
	}

}
