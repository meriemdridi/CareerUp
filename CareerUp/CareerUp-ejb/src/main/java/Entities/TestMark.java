package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TestMarks database table.
 * 
 */
@Entity
@Table(name="TestMarks")
@NamedQuery(name="TestMark.findAll", query="SELECT t FROM TestMark t")
public class TestMark implements Serializable {
	private static final long serialVersionUID = 1L;

	

	private int mark;

	@Id
	@Column(name="TestMarkId")
	private int testMarkId;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="c_IdCandidate")
	private Candidate candidate;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="testId")
	private Test test;

	public TestMark() {
	}



	public int getMark() {
		return this.mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getTestMarkId() {
		return this.testMarkId;
	}

	public void setTestMarkId(int testMarkId) {
		this.testMarkId = testMarkId;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}