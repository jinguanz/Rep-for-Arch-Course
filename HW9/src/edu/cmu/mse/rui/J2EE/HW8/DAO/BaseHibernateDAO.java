package edu.cmu.mse.rui.J2EE.HW8.DAO;
// default package

import org.hibernate.Session;

import edu.cmu.mse.rui.J2EE.HW9.Hibernate.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}