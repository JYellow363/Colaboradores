package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.ICollaboratorDao;
import pe.edu.upc.entity.Collaborator;

public class CollaboratorDaoImpl implements Serializable, ICollaboratorDao {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Collaborator collaborator) {
		try {
			em.persist(collaborator);
		} catch (Exception e) {
			System.out.println("Error al insertar colaborador");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Collaborator> list() {
		List<Collaborator> lista = new ArrayList<Collaborator>();
		try {
			Query q = em.createQuery("from Collaborator c");
			lista = (List<Collaborator>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar colaboradores");
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Collaborator> findByName(Collaborator collaborator) {
		List<Collaborator> lista = new ArrayList<Collaborator>();
		try {
			Query q = em.createQuery("from Collaborator c where c.rcFullName like ?1");
			q.setParameter(1,"%"+ collaborator.getRcFullName()+"%");
			lista = (List<Collaborator>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar colaborador");
		}
		return lista;
	}
	
}