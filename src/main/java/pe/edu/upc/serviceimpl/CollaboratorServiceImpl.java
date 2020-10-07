package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.ICollaboratorDao;
import pe.edu.upc.entity.Collaborator;
import pe.edu.upc.serviceinterface.ICollaboratorService;

@Named
@RequestScoped
public class CollaboratorServiceImpl implements ICollaboratorService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ICollaboratorDao cD;

	@Override
	public void insert(Collaborator collaborator) {
		cD.insert(collaborator);
	}

	@Override
	public List<Collaborator> list() {
		return cD.list();
	}

	@Override
	public List<Collaborator> findByName(Collaborator collaborator) {
		return cD.findByName(collaborator);
	}
	
}