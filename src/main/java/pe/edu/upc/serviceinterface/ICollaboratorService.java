package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Collaborator;

public interface ICollaboratorService {
	public void insert(Collaborator collaborator);
	public List<Collaborator> list();
	public List<Collaborator> findByName(Collaborator collaborator);
}
