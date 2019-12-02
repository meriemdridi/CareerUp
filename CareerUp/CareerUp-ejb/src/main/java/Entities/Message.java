package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Messages database table.
 * 
 */
@Entity
@Table(name="Messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_msg")
	private int idMsg;

	@Column(name="date_msg")
	private Date dateMsg;

	private String text;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="UserEmm_idUser")
	private AppUser appUser1;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="UserRec_idUser")
	private AppUser appUser2;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="AppUser_idUser")
	private AppUser appUser3;

	public Message() {
	}

	public int getIdMsg() {
		return this.idMsg;
	}

	public void setIdMsg(int idMsg) {
		this.idMsg = idMsg;
	}

	
	public Date getDateMsg() {
		return dateMsg;
	}

	public void setDateMsg(Date dateMsg) {
		this.dateMsg = dateMsg;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AppUser getAppUser1() {
		return this.appUser1;
	}

	public void setAppUser1(AppUser appUser1) {
		this.appUser1 = appUser1;
	}

	public AppUser getAppUser2() {
		return this.appUser2;
	}

	public void setAppUser2(AppUser appUser2) {
		this.appUser2 = appUser2;
	}

	public AppUser getAppUser3() {
		return this.appUser3;
	}

	public void setAppUser3(AppUser appUser3) {
		this.appUser3 = appUser3;
	}

}