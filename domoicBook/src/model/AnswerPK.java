package model;

import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class AnswerPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="discuss_id", insertable=false, updatable=false)
	private int discussId;

	@Column(name="replier_number", insertable=false, updatable=false)
	private int replierNumber;

	public AnswerPK() {
	}
	public int getDiscussId() {
		return this.discussId;
	}
	public void setDiscussId(int discussId) {
		this.discussId = discussId;
	}
	public int getReplierNumber() {
		return this.replierNumber;
	}
	public void setReplierNumber(int replierNumber) {
		this.replierNumber = replierNumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AnswerPK)) {
			return false;
		}
		AnswerPK castOther = (AnswerPK)other;
		return 
			(this.discussId == castOther.discussId)
			&& (this.replierNumber == castOther.replierNumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.discussId;
		hash = hash * prime + this.replierNumber;
		
		return hash;
	}
}