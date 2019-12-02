package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Payments database table.
 * 
 */
@Entity
@Table(name="Payments")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PaymentId")
	private int paymentId;

	@Column(name="Amount_payment")
	private double amount_payment;

	@Column(name="Payment_date")
	private Date payment_date;

	//bi-directional many-to-one association to Candidate
	@OneToMany(mappedBy="payment")
	private List<Candidate> candidates;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="UserId_idUser")
	private AppUser appUser;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount_payment() {
		return this.amount_payment;
	}

	public void setAmount_payment(double amount_payment) {
		this.amount_payment = amount_payment;
	}

	
	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public Candidate addCandidate(Candidate candidate) {
		getCandidates().add(candidate);
		candidate.setPayment(this);

		return candidate;
	}

	public Candidate removeCandidate(Candidate candidate) {
		getCandidates().remove(candidate);
		candidate.setPayment(null);

		return candidate;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}