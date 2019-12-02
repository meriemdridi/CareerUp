package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Jobs database table.
 * 
 */
@Entity
@Table(name="Jobs")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdJob")
	private int idJob;

	@Column(name="Deadline")
	private Date deadline;

	@Column(name="Description")
	private String description;

	@Column(name="Experience")
	private int experience;

	@Column(name="Gender")
	private int gender;

	@Column(name="Industry")
	private String industry;

	@Column(name="JobType")
	private int jobType;

	@Column(name="PostedDate")
	private Date postedDate;

	@Column(name="Qualification")
	private int qualification;

	@Column(name="Salary")
	private String salary;

	@Column(name="Skills")
	private String skills;

	@Column(name="Title")
	private String title;

	//bi-directional many-to-many association to Candidate
	@ManyToMany
	@JoinTable(
		name="Candidature"
		, joinColumns={
			@JoinColumn(name="Job_IdJob")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Candidate_IdCandidate")
			}
		)
	private List<Candidate> candidates;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="Company_IdCompany")
	private Company company;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="job")
	private List<Notification> notifications;

	public Job() {
	}

	public int getIdJob() {
		return this.idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}


	public int getJobType() {
		return this.jobType;
	}

	public void setJobType(int jobType) {
		this.jobType = jobType;
	}

	

	public int getQualification() {
		return this.qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	
	
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setJob(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setJob(null);

		return notification;
	}

}