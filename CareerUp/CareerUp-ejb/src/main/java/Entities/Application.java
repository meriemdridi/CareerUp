package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Applications database table.
 * 
 */
@Entity
@Table(name="Applications")
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AppId")
	private int appId;

	@Column(name="ApplicationStatus")
	private String applicationStatus;

	@Column(name="CandId")
	private int candId;

	@Column(name="Nom")
	private String nom;

	@Column(name="OfferId")
	private int offerId;

	@Column(name="Prenom")
	private String prenom;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="AppUser_idUser")
	private AppUser appUser;

	public Application() {
	}

	public int getAppId() {
		return this.appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	

	public int getCandId() {
		return this.candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}