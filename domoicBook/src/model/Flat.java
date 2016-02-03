package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
@Entity
@Table(name = "flats")
@NamedQuery(name = "Flat.findAll", query = "SELECT f FROM Flat f")
public class Flat implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Id
    private int number;

    private double flatSurface;

    private String password;

    private int roomCount;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "flat", cascade = CascadeType.PERSIST)
    private List<Answer> answers;

    @OneToMany(mappedBy = "flat")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "flat")
    private List<Payment> payments;

    @OneToMany(mappedBy = "flat")
    private List<Resident> residents;

    @OneToMany(mappedBy = "sender")
    private List<PrivateMessage> sentMessages;

    @OneToMany(mappedBy = "recipient")
    private List<PrivateMessage> receivedMessages;

    public Flat() {
    }

    public Status getStatus() {
	return this.status;
    }

    public void setStatus(Status status) {
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

    public List<Resident> getResidents() {
	return this.residents;
    }

    public void setResidents(List<Resident> residents) {
	this.residents = residents;
    }

    public Resident addResident(Resident resident) {
	getResidents().add(resident);
	resident.setFlat(this);

	return resident;
    }

    public Resident removeResident(Resident resident) {
	getResidents().remove(resident);
	resident.setFlat(null);

	return resident;
    }

    public List<PrivateMessage> getSentMessages() {
	return this.sentMessages;
    }

    public void setSentMessages(List<PrivateMessage> sentMessage) {
	this.sentMessages = sentMessage;
    }

    public PrivateMessage addSentMessage(PrivateMessage sentMessage) {
	getSentMessages().add(sentMessage);
	sentMessage.setSender(this);

	return sentMessage;
    }

    public PrivateMessage removeSentMessage(PrivateMessage sentMessage) {
	getSentMessages().remove(sentMessage);
	sentMessage.setSender(null);

	return sentMessage;
    }

    public List<PrivateMessage> getReceivedMessages() {
	return this.receivedMessages;
    }

    public void setReceivedMessages(List<PrivateMessage> receivedMessages) {
	this.receivedMessages = receivedMessages;
    }

    public PrivateMessage addReceivedMessage(PrivateMessage receivedMessage) {
	getReceivedMessages().add(receivedMessage);
	receivedMessage.setRecipient(this);

	return receivedMessage;
    }

    public PrivateMessage removeReceivedMessage(PrivateMessage receivedMessage) {
	getReceivedMessages().remove(receivedMessage);
	receivedMessage.setRecipient(null);

	return receivedMessage;
    }

}