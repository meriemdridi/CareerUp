package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Like_Deslike database table.
 * 
 */
@Entity
@NamedQuery(name="Like_Deslike.findAll", query="SELECT l FROM Like_Deslike l")
public class Like_Deslike implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_like")
	private int idLike;

	private Date date_LD;

	private String type;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AppUser appUser;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;

	public Like_Deslike() {
	}

	public int getIdLike() {
		return this.idLike;
	}

	public void setIdLike(int idLike) {
		this.idLike = idLike;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDate_LD(Date date_LD) {
		this.date_LD = date_LD;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}