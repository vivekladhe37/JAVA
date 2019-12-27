package pojos;
import javax.persistence.*;

@Entity
@Table(name="stud_address")
public class Address extends AbstractEntity{
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String country;
	//one-to-one (Address HAS A Student) --owning side
	@OneToOne
	@JoinColumn(name="stud_id")
	private Student stud;
	public Address() {
		System.out.println("in adr constr");
	}
	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", getId()=" + getId() + "]";
	}
	
	
	

}
