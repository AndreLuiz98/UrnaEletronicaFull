package back;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidade.Candidato;
import hibernate.HibernateUtil;

public class CandidatoDAO extends GenericDAO<Integer, Candidato>{

	private static CandidatoDAO instance;

	public static CandidatoDAO getInstance() {	

		instance = new CandidatoDAO();	

		return instance;

	}

	@Override
	public Candidato find(Candidato entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidato> getAll() throws HibernateException {
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

}
