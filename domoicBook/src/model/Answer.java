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
@Table(name = "answers")
public class Answer implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @EmbeddedId
    private AnswerPK id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DATE")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "discuss_id")
    private Discussion discussion;

    @ManyToOne
    @JoinColumn(name = "replier_number")
    private Flat flat;

    public Answer() {
    }

    public AnswerPK getId() {
	return this.id;
    }

    public void setId(AnswerPK id) {
	this.id = id;
    }

    public String getContent() {
	return this.content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public Discussion getDiscussion() {
	return this.discussion;
    }

    public void setDiscussion(Discussion discussion) {
	this.discussion = discussion;
    }

    public Flat getFlat() {
	return this.flat;
    }

    public void setFlat(Flat flat) {
	this.flat = flat;
    }

    public String getDate() {
	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.date);
    }

    public void setDate() {
	Date currentDate = Calendar.getInstance().getTime();
	this.date = new Timestamp(currentDate.getTime());
    }
}