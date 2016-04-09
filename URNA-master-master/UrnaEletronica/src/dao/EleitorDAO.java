package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Eleitor;
import hibernate.HibernateUtil;

public class EleitorDAO extends GenericDAO<Integer, Eleitor>{

	private static EleitorDAO instance;

	public static EleitorDAO getInstance() {	

		instance = new EleitorDAO();	

		return instance;

	}

	@Override
	public Eleitor find(Eleitor entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Eleitor> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Eleitor getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Eleitor eleitor = null;

		try {
			session.beginTransaction();
			eleitor = (Eleitor) session.get(Eleitor.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return eleitor;
	}

	public Eleitor getByTitulo(Integer titulo) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Eleitor eleitor = null;
		
		try {
					
			Query query = session.createQuery("from Eleitor where tituloVotacao_pessoa = :titulo");
			query.setParameter("titulo", titulo);
			
			eleitor = (Eleitor) query.uniqueResult();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
		} finally {
		
			session.close();
		}
		System.out.println("Aqui");
		return eleitor;

	}

}