package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Events database table.
 * 
 */
@Entity
@Table(name="Events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="IdEvent")
	private int idEvent;

	@Column(name="Description")
	private String description;

	@Column(name="EventDate")
	private Date eventDate;

	@Column(name="InterestNbr")
	private int interestNbr;

	@Column(name="Lieu")
	private String lieu;

	private String logo;

	@Column(name="NameEvent")
	private String nameEvent;

	@Column(name="ParticipantNbre")
	private int participantNbre;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="User_idUser")
	private AppUser appUser;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="Company_IdCompany")
	private Company company;

	public Event() {
	}

	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	

	public int getInterestNbr() {
		return this.interestNbr;
	}

	public void setInterestNbr(int interestNbr) {
		this.interestNbr = interestNbr;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public int getParticipantNbre() {
		return this.participantNbre;
	}

	public void setParticipantNbre(int participantNbre) {
		this.participantNbre = participantNbre;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

	public Event(String description, Date eventDate, String lieu, String logo, String nameEvent) {
		super();
		this.description = description;
		this.eventDate = eventDate;
		this.lieu = lieu;
		this.logo = logo;
		this.nameEvent = nameEvent;
	}

	public Event(int idEvent, String description, Date eventDate, String lieu, String logo, String nameEvent) {
		super();
		this.idEvent = idEvent;
		this.description = description;
		this.eventDate = eventDate;
		this.lieu = lieu;
		this.logo = logo;
		this.nameEvent = nameEvent;
	}


	
}