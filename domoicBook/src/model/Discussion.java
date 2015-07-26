package model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="discussions")
@NamedQuery(name="Discussion.findAll", query="SELECT d FROM Discussion d")
public class Discussion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String content;
	
	@Column(name="DATE")
	 private Timestamp date;
	
	private String title;

	@OneToMany(mappedBy="discussion")
	private List<Answer> answers;

	public Discussion() {
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setDiscussion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setDiscussion(null);

		return answer;
	}

	public String getDate() {
		  SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  return dateFormat.format(this.date);
		  }

		  public void setDate() {
		   Calendar calendar=Calendar.getInstance();
		   Date dateNow=calendar.getTime();
		   this.date=new Timestamp(dateNow.getTime());
		  }

}