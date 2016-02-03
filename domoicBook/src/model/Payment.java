package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
@Entity
@Table(name = "payments")
@NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
public class Payment implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @EmbeddedId
    private PaymentPK id;

    @Column(name = "PAYMENTSTATUS")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "PAYMENTDATE")
    private Timestamp paymentDate;

    @ManyToOne
    @JoinColumn(name = "obligation_id")
    private Obligation obligation;

    @ManyToOne
    @JoinColumn(name = "flat_number")
    private Flat flat;

    @SuppressWarnings("static-access")
    public Payment() {
	this.paymentStatus = paymentStatus.NOT_PAID;
    }

    public PaymentPK getId() {
	return this.id;
    }

    public void setId(PaymentPK id) {
	this.id = id;
    }

    public String getPaymentDate() {
	if (this.paymentDate == null) {
	    return "-";
	}
	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.paymentDate);
    }

    public void setPaymentDate() {
	Date currentDate = Calendar.getInstance().getTime();
	this.paymentDate = new Timestamp(currentDate.getTime());
    }

    public String getPaymentStatus() {
	return this.paymentStatus.name();
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
	this.paymentStatus = paymentStatus;
    }

    public Obligation getObligation() {
	return this.obligation;
    }

    public void setObligation(Obligation obligation) {
	this.obligation = obligation;
    }

    public Flat getFlat() {
	return this.flat;
    }

    public void setFlat(Flat flat) {
	this.flat = flat;
    }

}