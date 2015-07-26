package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="flats")
@NamedQuery(name="Flat.findAll", query="SELECT f FROM Flat f")
public class Flat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int number;

	private double flatSurface;

	private String password;

	private int roomCount;
	
	@Enumerated(EnumType.STRING)
	 private status status;

	@OneToMany(mappedBy="flat")
	private List<Answer> answers;

	@OneToMany(mappedBy="flat")
	private List<Notification> notifications;

	@OneToMany(mappedBy="flat")
	private List<Payment> payments;

	@OneToMany(mappedBy="flat")
	private List<People> peoples;

	@OneToMany(mappedBy="flat1")
	private List<PrivateMessage> privateMessages1;

	@OneToMany(mappedBy="flat2")
	private List<PrivateMessage> privateMessages2;

	public Flat() {
	}
	
	public status getStatus() {
		return this.status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getFlatSurface() {
		return this.flatSurface;
	}

	public void setFlatSurface(double flatSurface) {
		this.flatSurface = flatSurface;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoomCount() {
		return this.roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setFlat(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setFlat(null);

		return answer;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setFlat(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setFlat(null);

		return notification;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setFlat(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setFlat(null);

		return payment;
	}

	public List<People> getPeoples() {
		return this.peoples;
	}

	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}

	public People addPeople(People people) {
		getPeoples().add(people);
		people.setFlat(this);

		return people;
	}

	public People removePeople(People people) {
		getPeoples().remove(people);
		people.setFlat(null);

		return people;
	}

	public List<PrivateMessage> getPrivateMessages1() {
		return this.privateMessages1;
	}

	public void setPrivateMessages1(List<PrivateMessage> privateMessages1) {
		this.privateMessages1 = privateMessages1;
	}

	public PrivateMessage addPrivateMessages1(PrivateMessage privateMessages1) {
		getPrivateMessages1().add(privateMessages1);
		privateMessages1.setFlat1(this);

		return privateMessages1;
	}

	public PrivateMessage removePrivateMessages1(PrivateMessage privateMessages1) {
		getPrivateMessages1().remove(privateMessages1);
		privateMessages1.setFlat1(null);

		return privateMessages1;
	}

	public List<PrivateMessage> getPrivateMessages2() {
		return this.privateMessages2;
	}

	public void setPrivateMessages2(List<PrivateMessage> privateMessages2) {
		this.privateMessages2 = privateMessages2;
	}

	public PrivateMessage addPrivateMessages2(PrivateMessage privateMessages2) {
		getPrivateMessages2().add(privateMessages2);
		privateMessages2.setFlat2(this);

		return privateMessages2;
	}

	public PrivateMessage removePrivateMessages2(PrivateMessage privateMessages2) {
		getPrivateMessages2().remove(privateMessages2);
		privateMessages2.setFlat2(null);

		return privateMessages2;
	}


}