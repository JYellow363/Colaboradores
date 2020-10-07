package pe.edu.upc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collaborator")
public class Collaborator implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idCollaborator")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rcIdCollaborator;

	@Column(name = "full_name", nullable = false, length = 45)
	private String rcFullName;

	@Column(name = "weight", nullable = false)
	private double rcWeight;
	@Column(name = "height", nullable = false)
	private double rcHeight;
	
	public Collaborator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collaborator(int rcIdCollaborator, String rcFullName, double rcWeight, double rcHeight) {
		super();
		this.rcIdCollaborator = rcIdCollaborator;
		this.rcFullName = rcFullName;
		this.rcWeight = rcWeight;
		this.rcHeight = rcHeight;
	}

	public int getRcIdCollaborator() {
		return rcIdCollaborator;
	}

	public void setRcIdCollaborator(int rcIdCollaborator) {
		this.rcIdCollaborator = rcIdCollaborator;
	}

	public String getRcFullName() {
		return rcFullName;
	}

	public void setRcFullName(String rcFullName) {
		this.rcFullName = rcFullName;
	}

	public double getRcWeight() {
		return rcWeight;
	}

	public void setRcWeight(double rcWeight) {
		this.rcWeight = rcWeight;
	}

	public double getRcHeight() {
		return rcHeight;
	}

	public void setRcHeight(double rcHeight) {
		this.rcHeight = rcHeight;
	}
}
