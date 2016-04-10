package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Candidato;
import hibernate.HibernateUtil;

public class CandidatoDAO extends GenericDAO<Integer, Candidato>{

	private static CandidatoDAO instance;

	public static CandidatoDAO getInstance() {	

		instance = new CandidatoDAO();	

		return instance;

	}
	public void insert(Candidato candidato) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			session.save(candidato);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}
	}

	@Override
	public Candidato find(Candidato entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Candidato getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Candidato candidato = null;

		try {

			session.beginTransaction();
			candidato = (Candidato) session.get(Candidato.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return candidato;
	}

	@SuppressWarnings("unchecked")
	public List <Candidato> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Candidato> candidatos = null;
		String candidato = "Candidato";

		try {

			String hql = "from Pessoa where DTYPE = :candidato";

			Query query = session.createQuery(hql);
			query.setParameter("candidato", candidato);

			candidatos = (List<Candidato>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return candidatos;
	}
	public Candidato getByNumero(int numero) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Candidato candidato = null;

		try {

			String hql = "from Candidato where numero = :numero";

			Query query = session.createQuery(hql);
			query.setParameter("numero", numero);

			candidato = (Candidato) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return candidato;
	}
	@SuppressWarnings("unchecked")
	public List <Candidato> getAllCandidatos() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Candidato> candidatos = null;
		String candidato = "Candidato";

		try {

			String hql = "from Pessoa where DTYPE = :candidato";

			Query query = session.createQuery(hql);
			query.setParameter("candidato", candidato);

			candidatos = (List<Candidato>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return candidatos;

	}

}