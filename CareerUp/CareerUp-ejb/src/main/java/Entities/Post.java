package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Posts database table.
 * 
 */
@Entity
@Table(name="Posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_post")
	private int idPost;

	@Column(name="date_post")
	private Date datePost;

	@Column(name="photo_post")
	private String photoPost;

	@Column(name="text_post")
	private String textPost;

	@Column(name="video_post")
	private String videoPost;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	//bi-directional many-to-one association to Like_Deslike
	@OneToMany(mappedBy="post")
	private List<Like_Deslike> likeDeslikes;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="User_idUser")
	private AppUser appUser;

	//bi-directional many-to-one association to Domaine
	@ManyToOne
	@JoinColumn(name="domaine_id")
	private Domaine domaine;

	public Post() {
	}

	public int getIdPost() {
		return this.idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getPhotoPost() {
		return photoPost;
	}

	public void setPhotoPost(String photoPost) {
		this.photoPost = photoPost;
	}

	public String getTextPost() {
		return textPost;
	}

	public void setTextPost(String textPost) {
		this.textPost = textPost;
	}

	public String getVideoPost() {
		return videoPost;
	}

	public void setVideoPost(String videoPost) {
		this.videoPost = videoPost;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setPost(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setPost(null);

		return comment;
	}

	public List<Like_Deslike> getLikeDeslikes() {
		return this.likeDeslikes;
	}

	public void setLikeDeslikes(List<Like_Deslike> likeDeslikes) {
		this.likeDeslikes = likeDeslikes;
	}

	public Like_Deslike addLikeDeslike(Like_Deslike likeDeslike) {
		getLikeDeslikes().add(likeDeslike);
		likeDeslike.setPost(this);

		return likeDeslike;
	}

	public Like_Deslike removeLikeDeslike(Like_Deslike likeDeslike) {
		getLikeDeslikes().remove(likeDeslike);
		likeDeslike.setPost(null);

		return likeDeslike;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Domaine getDomaine() {
		return this.domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

}