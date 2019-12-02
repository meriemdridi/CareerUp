package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AppUsers database table.
 * 
 */
@Entity
@Table(name="AppUsers")
@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idUser;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	
	private Role role;

	private String userName;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="appUser")
	private List<Application> applications;

	//bi-directional many-to-one association to Claim
	@OneToMany(mappedBy="appUser")
	private List<Claim> claims;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="appUser")
	private List<Comment> comments;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="appUser")
	private List<Event> events;

	//bi-directional many-to-one association to Like_Deslike
	@OneToMany(mappedBy="appUser")
	private List<Like_Deslike> likeDeslikes;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="appUser1")
	private List<Message> messages1;



	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="appUser")
	private List<Payment> payments;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="appUser")
	private List<Post> posts;

	public AppUser() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setAppUser(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setAppUser(null);

		return application;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Claim addClaim(Claim claim) {
		getClaims().add(claim);
		claim.setAppUser(this);

		return claim;
	}

	public Claim removeClaim(Claim claim) {
		getClaims().remove(claim);
		claim.setAppUser(null);

		return claim;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAppUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAppUser(null);

		return comment;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setAppUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setAppUser(null);

		return event;
	}

	public List<Like_Deslike> getLikeDeslikes() {
		return this.likeDeslikes;
	}

	public void setLikeDeslikes(List<Like_Deslike> likeDeslikes) {
		this.likeDeslikes = likeDeslikes;
	}

	public Like_Deslike addLikeDeslike(Like_Deslike likeDeslike) {
		getLikeDeslikes().add(likeDeslike);
		likeDeslike.setAppUser(this);

		return likeDeslike;
	}

	public Like_Deslike removeLikeDeslike(Like_Deslike likeDeslike) {
		getLikeDeslikes().remove(likeDeslike);
		likeDeslike.setAppUser(null);

		return likeDeslike;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setAppUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setAppUser1(null);

		return messages1;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setAppUser(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setAppUser(null);

		return payment;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setAppUser(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setAppUser(null);

		return post;
	}
	
	

	public AppUser(int idUser, String email, String firstName, String lastName, String password, Role role,
			String userName) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}

	public AppUser(String email, String firstName, String lastName, String password, Role role, String userName) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}


	
}