package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
@Entity
@Table(name = "obligations")
@NamedQuery(name = "Obligation.findAll", query = "SELECT o FROM Obligation o")
public class Obligation implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DEADLINE")
    Timestamp deadline;

    private double debt;

    @Lob
    private String description;

    @OneToMany(mappedBy = "obligation")
    private List<Payment> payments;

    public Obligation() {
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getDeadline() {
	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.deadline);
    }

    public void setDeadline(String inputDeadline) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	try {
	    Date currentDate = dateFormat.parse(inputDeadline);
	    this.deadline = new Timestamp(currentDate.getTime());
	} catch (ParseException e) {
	    // Figure out where to propagate or throw it(most likely)
	}
    }

    public double getDebt() {
	return this.debt;
    }

    public void setDebt(double debt) {
	this.debt = debt;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<Payment> getPayments() {
	return this.payments;
    }

    public void setPayments(List<Payment> payments) {
	this.payments = payments;
    }

    public Payment addPayment(Payment payment) {
	getPayments().add(payment);
	payment.setObligation(this);

	return payment;
    }

    public Payment removePayment(Payment payment) {
	getPayments().remove(payment);
	payment.setObligation(null);

	return payment;
    }

}