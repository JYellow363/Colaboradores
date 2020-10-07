package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Collaborator;
import pe.edu.upc.serviceinterface.ICollaboratorService;

@Named
@RequestScoped
public class CollaboratorController {
	@Inject
	private ICollaboratorService cS;

	private Collaborator collaborator;
	List<Collaborator> listCollaborators;

	@PostConstruct
	public void init() {
		this.collaborator = new Collaborator();
		this.listCollaborators = new ArrayList<Collaborator>();
		this.list();
	}

	public String newCollaborator() {
		this.setCollaborator(new Collaborator());
		return "collaborator.xhtml";
	}

	public void insert() {
		try {

			cS.insert(collaborator);
			this.cleanCollaborator();
			this.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void list() {
		try {
			listCollaborators = cS.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void cleanCollaborator() {
		this.init();
	}
	
	public void findByName() {
		try {
			if(collaborator.getRcFullName().isEmpty()) {
				this.list();
			} else {
				listCollaborators = this.cS.findByName(this.getCollaborator()); 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public List<Collaborator> getListCollaborators() {
		return listCollaborators;
	}

	public void setListCollaborators(List<Collaborator> listCollaborators) {
		this.listCollaborators = listCollaborators;
	}

}
