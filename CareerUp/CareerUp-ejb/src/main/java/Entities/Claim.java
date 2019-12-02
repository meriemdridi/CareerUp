package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Claims database table.
 * 
 */
@Entity
@Table(name="Claims")
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ClaimId")
	private int claimId;

	@Column(name="Content_claim")
	private String content_claim;

	@Column(name="Date_claim")
	private Date date_claim;

	@Column(name="Object_claim")
	private String object_claim;

	@Column(name="State_claim")
	private String state_claim;

	@Column(name="TreatmentDate_claim")
	private Date treatmentDate_claim;

	@Column(name="Type_claim")
	private String type_claim;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="UserId_idUser")
	private AppUser appUser;

	public Claim() {
	}

	public int getClaimId() {
		return this.claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	

	public String getContent_claim() {
		return content_claim;
	}

	public void setContent_claim(String content_claim) {
		this.content_claim = content_claim;
	}

	public Date getDate_claim() {
		return date_claim;
	}

	public void setDate_claim(Date date_claim) {
		this.date_claim = date_claim;
	}

	public String getObject_claim() {
		return object_claim;
	}

	public void setObject_claim(String object_claim) {
		this.object_claim = object_claim;
	}

	public String getState_claim() {
		return state_claim;
	}

	public void setState_claim(String state_claim) {
		this.state_claim = state_claim;
	}

	public Date getTreatmentDate_claim() {
		return treatmentDate_claim;
	}

	public void setTreatmentDate_claim(Date treatmentDate_claim) {
		this.treatmentDate_claim = treatmentDate_claim;
	}

	public String getType_claim() {
		return type_claim;
	}

	public void setType_claim(String type_claim) {
		this.type_claim = type_claim;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}