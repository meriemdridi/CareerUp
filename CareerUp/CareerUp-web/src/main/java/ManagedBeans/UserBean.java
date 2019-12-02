package ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.*;
import Services.*;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userIdUpdated;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	private Role role;

	private String userName;

	private List<AppUser> users;

	public List<AppUser> getUsers() {
		users = userService.getAllUsers();
		return users;
	}

	public Integer getUserIdUpdated() {
		return userIdUpdated;
	}

	public void setUserIdUpdated(Integer userIdUpdated) {
		this.userIdUpdated = userIdUpdated;
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

	public UserBean(String email, String firstName, String lastName, String password, Role role, String userName) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}

	public UserBean() {

	}

	public UserBean(Integer userIdUpdated, String email, String firstName, String lastName, String password, Role role,
			String userName) {
		super();
		this.userIdUpdated = userIdUpdated;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}

	@EJB
	UserService userService;

	public void addUser() {
		userService.ajouterUser(new AppUser(email, firstName, lastName, password, role, userName));
	}

	public void removeUser(int id) {
		userService.deleteUser(id);
	}

	public void displayUser(AppUser user) {
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setUserName(user.getUserName());
		this.setPassword(user.getPassword());
		this.setRole(user.getRole());
		this.setUserIdUpdated(user.getIdUser());
	}

	public void updateUser() {
		userService.updateUser(new AppUser(userIdUpdated, email, firstName, lastName, password, role, userName));

	}

}