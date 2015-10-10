package model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class PaymentPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "obligation_id", insertable = false, updatable = false)
    private int obligationId;

    @Column(name = "flat_number", insertable = false, updatable = false)
    private int flatNumber;

    public PaymentPK() {
    }

    public int getObligationId() {
	return this.obligationId;
    }

    public void setObligationId(int obligationId) {
	this.obligationId = obligationId;
    }

    public int getFlatNumber() {
	return this.flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
	this.flatNumber = flatNumber;
    }

    public boolean equals(Object other) {
	if (this == other) {
	    return true;
	}
	if (!(other instanceof PaymentPK)) {
	    return false;
	}
	PaymentPK castOther = (PaymentPK) other;
	return (this.obligationId == castOther.obligationId) && (this.flatNumber == castOther.flatNumber);
    }

    public int hashCode() {
	final int prime = 31;
	int hash = 17;
	hash = hash * prime + this.obligationId;
	hash = hash * prime + this.flatNumber;

	return hash;
    }
}