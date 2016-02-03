package model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
@Entity
@Table(name = "people")
@NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r")
public class Resident implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Id
    private int id;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "flatNumber")
    private Flat flat;

    public Resident() {
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