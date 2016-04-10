package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Voto;
import hibernate.HibernateUtil;

public class VotoDAO extends GenericDAO<Integer, Voto>{

	private static VotoDAO instance;

	public static VotoDAO getInstance() {	

		instance = new VotoDAO();	

		return instance;

	}

	@Override
	public Voto find(Voto entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voto> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Voto> votos = null;

		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("Voto.getAll");
			votos = (List<Voto>) query.list();
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.clear();
			session.close();
		}

		return votos;
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Voto getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Voto voto = null;

		try {

			session.beginTransaction();
			voto = (Voto) session.get(Voto.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return voto;
	}
	@SuppressWarnings("unchecked")
	public List<Voto> getByVoto(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Voto> votos = null;

		try {

			String hql = "from Voto where eleitor.id = :id";

			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			votos = (List<Voto>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return votos;
	}
	@SuppressWarnings("unchecked")
	public int getVotosCandidato(int numero, String cargo) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Voto> votos = null;

		try {

			String hql = "from Voto where voto_candidato = :numero and cargo_candidato = :cargo";

			Query query = session.createQuery(hql);
			query.setParameter("numero", numero);
			query.setParameter("cargo", cargo);

			votos = (List<Voto>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}
		if (votos ==  null)
			return 0;

		return votos.size();
	}

	@SuppressWarnings("unchecked")
	public int getVotosEmBranco(){

		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Voto> votos = null;

		try {

			String hql = "from Voto where voto_candidato = :numero";

			Query query = session.createQuery(hql);
			query.setParameter("numero", 0);

			votos = (List<Voto>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}
		if (votos ==  null)
			return 0;

		return votos.size();
	}
}

