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
@Table(name = "notifications")
@NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
public class Notification implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Id
    private int id;

    @Lob
    private String content;

    @Column(name = "DATE")
    private Timestamp date;

    private String title;

    @ManyToOne
    @JoinColumn(name = "flatNumber")
    private Flat flat;

    public Notification() {
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

    public Flat getFlat() {
	return this.flat;
    }

    public void setFlat(Flat flat) {
	this.flat = flat;
    }

}