package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.HibernateUtil;

public abstract class GenericDAO<PK, T> {

	public abstract List<T> getAll() throws HibernateException;

	public abstract Class<?> getEntityClass();

	public void insert(T entity) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}
	}

	public boolean insertOrUpdate(T entity) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		boolean success = false;

		try {

			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();

			success = true;

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}

		return success;
	}
	public void update(T entity) throws HibernateException{

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			session.merge(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}

	}

	public void delete(T entity) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> getAll(String namedQuery) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> list = null;

		try {

			session.beginTransaction();
			Query query = session.getNamedQuery(namedQuery);
			list = (List<T>) query.list();
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}

		return list;
	}

	public abstract T find(T entity) throws HibernateException;

}
