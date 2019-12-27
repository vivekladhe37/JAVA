package pojos;
import javax.persistence.*;

@Embeddable
public class EducationQualifications {
	@Column(name="passing_yr")
	private int yearOfPassing;
	private double cgpa;
	public EducationQualifications() {
		// TODO Auto-generated constructor stub
	}
	public EducationQualifications(int yearOfPassing, double cgpa) {
		super();
		this.yearOfPassing = yearOfPassing;
		this.cgpa = cgpa;
	}
	public int getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	@Override
	public String toString() {
		return "EducationQualifications [yearOfPassing=" + yearOfPassing + ", cgpa=" + cgpa + "]";
	}
	

}
