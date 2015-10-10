package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "private_messages")
@NamedQuery(name = "PrivateMessage.findAll", query = "SELECT p FROM PrivateMessage p")
public class PrivateMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @Lob
    private String content;

    @Column(name = "DATE")
    private Timestamp date;

    private String title;

    @ManyToOne
    @JoinColumn(name = "senderNumber")
    private Flat flat1;

    @ManyToOne
    @JoinColumn(name = "receiverNumber")
    private Flat flat2;

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
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return dateFormat.format(this.date);
    }

    public void setDate() {
	Calendar calendar = Calendar.getInstance();
	Date dateNow = calendar.getTime();
	this.date = new Timestamp(dateNow.getTime());
    }

    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Flat getFlat1() {
	return this.flat1;
    }

    public void setFlat1(Flat flat1) {
	this.flat1 = flat1;
    }

    public Flat getFlat2() {
	return this.flat2;
    }

    public void setFlat2(Flat flat2) {
	this.flat2 = flat2;
    }

}