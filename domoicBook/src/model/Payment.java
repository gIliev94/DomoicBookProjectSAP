package model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="payments")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PaymentPK id;

	@Column(name="PAYMENTSTATUS")
	 @Enumerated(EnumType.STRING)
	 private paymentStatus paymentStatus;

	@Column(name="PAYMENTDATE")
	 private Timestamp paymentDate;
	

	@ManyToOne
	@JoinColumn(name="obligation_id")
	private Obligation obligation;

	@ManyToOne
	@JoinColumn(name="flat_number")
	private Flat flat;

	@SuppressWarnings("static-access")
	public Payment() {
		this.paymentStatus=paymentStatus.NOT_PAID;
	}

	public PaymentPK getId() {
		return this.id;
	}

	public void setId(PaymentPK id) {
		this.id = id;
	}

	public String getPaymentDate() {
		  SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  if(this.paymentDate==null){
			  return "-";
			  }
			  else return dateFormat.format(this.paymentDate);
		  }

	 public void setPaymentDate() {
		   Calendar calendar=Calendar.getInstance();
		   Date dateNow=calendar.getTime();
		   this.paymentDate=new Timestamp(dateNow.getTime());
	}

	public String getPaymentStatus() {
			    return this.paymentStatus.name();
	}

	public void setPaymentStatus(paymentStatus paymentStatus) {
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