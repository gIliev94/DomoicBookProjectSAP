package model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
@Embeddable
public class AnswerPK implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Column(name = "discuss_id", insertable = false, updatable = false)
    private int discussionId;

    @Column(name = "replier_number", insertable = false, updatable = false)
    private int recipientNumber;

    public AnswerPK() {
    }

    public int getDiscussId() {
	return this.discussionId;
    }

    public void setDiscussId(int discussId) {
	this.discussionId = discussId;
    }

    public int getReplierNumber() {
	return this.recipientNumber;
    }

    public void setReplierNumber(int recipientNumber) {
	this.recipientNumber = recipientNumber;
    }

    public boolean equals(Object other) {
	if (this == other) {
	    return true;
	}
	if (!(other instanceof AnswerPK)) {
	    return false;
	}
	AnswerPK castOther = (AnswerPK) other;
	return (this.discussionId == castOther.discussionId) && (this.recipientNumber == castOther.recipientNumber);
    }

    public int hashCode() {
	final int prime = 31;
	int hash = 17;
	hash = hash * prime + this.discussionId;
	hash = hash * prime + this.recipientNumber;

	return hash;
    }
}