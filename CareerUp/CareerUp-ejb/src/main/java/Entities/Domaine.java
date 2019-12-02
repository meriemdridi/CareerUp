package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Domaines database table.
 * 
 */
@Entity
@Table(name="Domaines")
@NamedQuery(name="Domaine.findAll", query="SELECT d FROM Domaine d")
public class Domaine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dom")
	private int idDom;

	private String nom;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="domaine")
	private List<Post> posts;

	public Domaine() {
	}

	public int getIdDom() {
		return this.idDom;
	}

	public void setIdDom(int idDom) {
		this.idDom = idDom;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setDomaine(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setDomaine(null);

		return post;
	}

}