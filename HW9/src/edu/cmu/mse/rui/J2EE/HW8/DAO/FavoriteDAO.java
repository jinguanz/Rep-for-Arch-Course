package edu.cmu.mse.rui.J2EE.HW8.DAO;

// default package

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import edu.cmu.mse.rui.J2EE.HW8.DataBean.Favorite;

/**
 * A data access object (DAO) providing persistence and search support for
 * Favorite entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .Favorite
 * @author MyEclipse Persistence Tools
 */

public class FavoriteDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(FavoriteDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String URL = "url";
	public static final String CLICK_COUNTER = "clickCounter";
	public static final String COMMENT = "comment";

	public void save(Favorite transientInstance) {
		log.debug("saving Favorite instance");
		try {
			Session ss = getSession();
			Transaction tran = ss.beginTransaction();
			ss.save(transientInstance);
			// ss.flush();
			tran.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(java.lang.Integer id) {
		log.debug("deleting Favorite instance");
		try {
			String hql = "delete Favorite where id=" + id;
			Session session = getSession();
			Query q = session.createQuery(hql);

			Transaction t = session.beginTransaction();
			q.executeUpdate();
			t.commit();
			session.flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void increaseCounter(java.lang.Integer id) {
		log.debug("update Favorite instance by increase count by 1");
		Session session = getSession();

		// String hql = "update Exam set endTime=? where id="+id;
		String hql = "update Favorite set clickCounter=clickCounter+1 where id="
				+ id;
		Query q = session.createQuery(hql);

		Transaction t = session.beginTransaction();
		q.executeUpdate();
		t.commit();
		session.flush();
	}

	public List queryUserFavorites(int userid) {
		log.debug("query all the user favorites");
		Session session = getSession();
		String hql = "from Favorite  where UserID=" + userid;

		Query q = session.createQuery(hql);

		List list = q.list();
		for (int i = 0; i < list.size(); i++) {
			session.refresh(list.get(i));
		}

		return list;
	}

	public Favorite findById(java.lang.Integer id) {
		log.debug("getting Favorite instance with id: " + id);
		try {
			Favorite instance = (Favorite) getSession().get("Favorite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Favorite instance) {
		log.debug("finding Favorite instance by example");
		try {
			List results = getSession().createCriteria("Favorite")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Favorite instance with property: " + propertyName
				+ ", value: " + value);
		try {
			Session session = getSession();
			session.flush();
			String queryString = "from Favorite as model where model."
					+ propertyName + "= ?";
			Transaction t = session.beginTransaction();
			Query queryObject = getSession().createQuery(queryString);

			queryObject.setParameter(0, value);
			// queryObject.executeUpdate();
			t.commit();
			List list = queryObject.list();
			for (int i = 0; i < list.size(); i++) {
				session.refresh(list.get(i));
			}
			
			return list;

		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByClickCounter(Object clickCounter) {
		return findByProperty(CLICK_COUNTER, clickCounter);
	}

	public List findByComment(Object comment) {
		return findByProperty(COMMENT, comment);
	}

	public List findAll() {
		log.debug("finding all Favorite instances");
		try {
			Session session = getSession();
			String queryString = "from Favorite";
			Query queryObject = getSession().createQuery(queryString);
			List list = queryObject.list();
			for (int i = 0; i < list.size(); i++) {
				session.refresh(list.get(i));
			}
			return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Favorite merge(Favorite detachedInstance) {
		log.debug("merging Favorite instance");
		try {
			Favorite result = (Favorite) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Favorite instance) {
		log.debug("attaching dirty Favorite instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Favorite instance) {
		log.debug("attaching clean Favorite instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}