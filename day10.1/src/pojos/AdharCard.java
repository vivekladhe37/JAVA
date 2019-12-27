package pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Embeddable //mandatory
public class AdharCard {
	@Column(name="adhar_num",unique = true,length = 16)
	private String adharNumber;
	@Column(name="creation_dt")
	private LocalDate createdOn;
	public AdharCard() {
		// TODO Auto-generated constructor stub
	}
	public AdharCard(String adharNumber, LocalDate createdOn) {
		super();
		this.adharNumber = adharNumber;
		this.createdOn = createdOn;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "AdharCard [adharNumber=" + adharNumber + ", createdOn=" + createdOn + "]";
	}
	

}
