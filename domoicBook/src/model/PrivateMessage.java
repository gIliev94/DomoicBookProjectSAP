package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
@Entity
@Table(name = "private_messages")
@NamedQuery(name = "PrivateMessage.findAll", query = "SELECT p FROM PrivateMessage p")
public class PrivateMessage implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Id
    private int id;

    @Lob
    private String content;

    @Column(name = "DATE")
    private Timestamp date;

    private String title;

    @ManyToOne
    @JoinColumn(name = "senderNumber")
    private Flat sender;

    @ManyToOne
    @JoinColumn(name = "receiverNumber")
    private Flat recipient;

    public PrivateMessage() {
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getContent() {
	return this.content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getDate() {
	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.date);
    }

    public void setDate() {
	Date currentDate = Calendar.getInstance().getTime();
	this.date = new Timestamp(currentDate.getTime());
    }

    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Flat getSender() {
	return this.sender;
    }

    public void setSender(Flat sender) {
	this.sender = sender;
    }

    public Flat getRecipient() {
	return this.recipient;
    }

    public void setRecipient(Flat recipient) {
	this.recipient = recipient;
    }

}