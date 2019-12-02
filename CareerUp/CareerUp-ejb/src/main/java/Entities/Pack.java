package Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Packs database table.
 * 
 */
@Entity
@Table(name="Packs")
@NamedQuery(name="Pack.findAll", query="SELECT p FROM Pack p")
public class Pack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PackId")
	private int packId;

	@Column(name="Details")
	private String details;

	@Column(name="Price")
	private int price;

	public Pack() {
	}

	public int getPackId() {
		return this.packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}