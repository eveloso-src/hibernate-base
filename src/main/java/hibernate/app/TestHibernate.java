package hibernate.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import hibernate.app.dao.EmployeeDao;
import hibernate.app.entity.EmployeeEntity;
import hibernate.util.DateUtil;
import hibernate.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {
		
		// Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName(null);
		
		EmployeeDao eDao = new EmployeeDao();
		eDao.insertEmployee(emp);
		
		System.out.println("Ingrese id de employee a borrar: ");
		Scanner sc = new Scanner (System.in);
		Integer employeeId = sc.nextInt();
		
		EmployeeEntity empDelete = new EmployeeEntity();
		empDelete.setEmployeeId(employeeId);
		eDao.deleteEmployee(empDelete);

		Date fecha = new Date();
		String fechaString = DateUtil.pasarDateAString(DateUtil.PATTERN_D2_M2_Y4, fecha);
		
		eDao.getAllEmployee();
		HibernateUtil.shutdown();
	}

	@SuppressWarnings("unchecked")
	private static void listUsers() {
		Session sesn = HibernateUtil.getSessionFactory().openSession();
		List<EmployeeEntity> emplo = new ArrayList<EmployeeEntity>();
		try {
			emplo = sesn.createQuery("From EmployeeEntity").list();
			for (EmployeeEntity emp : emplo) {
				System.out.println(emp.getFirstName() + " " + emp.getLastName());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sesn.close();
		}
	}

}
