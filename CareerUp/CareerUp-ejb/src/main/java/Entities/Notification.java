package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Notifications database table.
 * 
 */
@Entity
@Table(name="Notifications")
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_notif")
	private int idNotif;

	@Column(name="date_notif")
	private Date dateNotif;

	private String description;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="jobOffer_id_IdJob")
	private Job job;

	public Notification() {
	}

	public int getIdNotif() {
		return this.idNotif;
	}

	public void setIdNotif(int idNotif) {
		this.idNotif = idNotif;
	}

	
	public Date getDateNotif() {
		return dateNotif;
	}

	public void setDateNotif(Date dateNotif) {
		this.dateNotif = dateNotif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}