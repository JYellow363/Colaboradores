package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Collaborator;

public interface ICollaboratorDao {
	public void insert(Collaborator collaborator);
	public List<Collaborator> list();
	public List<Collaborator> findByName(Collaborator collaborator);
}
