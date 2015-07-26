package model;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="people")
@NamedQuery(name="People.findAll", query="SELECT p FROM People p")
public class People implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String firstName;

	private String lastName;
	


	@ManyToOne
	@JoinColumn(name="flatNumber")
	private Flat flat;

	public People() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Flat getFlat() {
		return this.flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

}