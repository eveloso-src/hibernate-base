package hibernate.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.app.entity.EmployeeEntity;
import hibernate.util.HibernateUtil;

public class EmployeeDao {

	public void insertEmployee(EmployeeEntity emp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(emp);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	public EmployeeEntity getEmployee(int id) {
		Session sesn = HibernateUtil.getSessionFactory().openSession();
		Query query = sesn.createQuery("From EmployeeEntity where employeId = " + id );
		EmployeeEntity emplo = (EmployeeEntity) query.uniqueResult();
		HibernateUtil.shutdown();
		return emplo;
	}
	
	public List<EmployeeEntity> getAllEmployee() {
		Session sesn = HibernateUtil.getSessionFactory().openSession();
		List<EmployeeEntity> emplo = new ArrayList<EmployeeEntity>();
		Query query = sesn.createQuery("From EmployeeEntity");
		emplo = query.list();

		HibernateUtil.shutdown();
		return emplo;
	}

	public void deleteEmployee(EmployeeEntity emp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(emp);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
