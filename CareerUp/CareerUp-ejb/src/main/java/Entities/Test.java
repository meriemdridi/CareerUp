package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Tests database table.
 * 
 */
@Entity
@Table(name="Tests")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TestId")
	private int testId;

	@Column(name="DateTest")
	private Date dateTest;

	private int score;

	@Column(name="StatusTest")
	private String statusTest;

	@Column(name="TestName")
	private String testName;

	@Column(name="TypeTest")
	private int typeTest;

	//bi-directional many-to-one association to Candidate
	@OneToMany(mappedBy="test")
	private List<Candidate> candidates;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="test")
	private List<Question> questions;

	//bi-directional many-to-one association to TestMark
	@OneToMany(mappedBy="test")
	private List<TestMark> testMarks;

	public Test() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	

	public Date getDateTest() {
		return dateTest;
	}

	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}

	public String getStatusTest() {
		return statusTest;
	}

	public void setStatusTest(String statusTest) {
		this.statusTest = statusTest;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTypeTest() {
		return this.typeTest;
	}

	public void setTypeTest(int typeTest) {
		this.typeTest = typeTest;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public Candidate addCandidate(Candidate candidate) {
		getCandidates().add(candidate);
		candidate.setTest(this);

		return candidate;
	}

	public Candidate removeCandidate(Candidate candidate) {
		getCandidates().remove(candidate);
		candidate.setTest(null);

		return candidate;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setTest(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setTest(null);

		return question;
	}

	public List<TestMark> getTestMarks() {
		return this.testMarks;
	}

	public void setTestMarks(List<TestMark> testMarks) {
		this.testMarks = testMarks;
	}

	public TestMark addTestMark(TestMark testMark) {
		getTestMarks().add(testMark);
		testMark.setTest(this);

		return testMark;
	}

	public TestMark removeTestMark(TestMark testMark) {
		getTestMarks().remove(testMark);
		testMark.setTest(null);

		return testMark;
	}

}