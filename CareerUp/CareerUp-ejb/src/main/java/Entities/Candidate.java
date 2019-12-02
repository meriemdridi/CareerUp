package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Candidates database table.
 * 
 */
@Entity
@Table(name="Candidates")
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdCandidate")
	private int idCandidate;

	@Column(name="BirthDate")
	private Date birthDate;

	@Column(name="City")
	private String city;

	@Column(name="Countries")
	private int countries;

	@Column(name="Description")
	private String description;

	@Column(name="Email")
	private String email;

	@Column(name="Facebook")
	private String facebook;

	@Column(name="Google")
	private String google;

	private String linkedin;

	@Column(name="Name")
	private String name;

	@Column(name="Password")
	private String password;

	@Column(name="Phone")
	private int phone;

	@Column(name="Photo")
	private String photo;

	@Column(name="Twitter")
	private String twitter;

	@Column(name="Website")
	private String website;

	//bi-directional many-to-one association to Payment
	@ManyToOne
	@JoinColumn(name="Payment_PaymentId")
	private Payment payment;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="Test_TestId")
	private Test test;

	//bi-directional many-to-many association to Job
	@ManyToMany(mappedBy="candidates")
	private List<Job> jobs;

	//bi-directional many-to-one association to TestMark
	@OneToMany(mappedBy="candidate")
	private List<TestMark> testMarks;

	public Candidate() {
	}

	public int getIdCandidate() {
		return this.idCandidate;
	}

	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}

	

	public int getCountries() {
		return this.countries;
	}

	public void setCountries(int countries) {
		this.countries = countries;
	}

	

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<TestMark> getTestMarks() {
		return this.testMarks;
	}

	public void setTestMarks(List<TestMark> testMarks) {
		this.testMarks = testMarks;
	}

	public TestMark addTestMark(TestMark testMark) {
		getTestMarks().add(testMark);
		testMark.setCandidate(this);

		return testMark;
	}

	public TestMark removeTestMark(TestMark testMark) {
		getTestMarks().remove(testMark);
		testMark.setCandidate(null);

		return testMark;
	}

}