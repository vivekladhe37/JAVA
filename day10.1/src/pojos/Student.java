package pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="students")
public class Student extends AbstractEntity{
	@Column(length = 20)
	private String name;
	//many to one side of association
	@ManyToOne //mandatory o.w MappingExc
	//to specify name of FK column name in the owning side of asso.
	@JoinColumn(name="course_id")//optional BUT reco
	private Course selectedCourse;
	//one to one bi dir asso between stud --- adr
	//inverse side
	@OneToOne(mappedBy = "stud",cascade = CascadeType.ALL)
	private Address addr;
	//one to one association between entity n value type
	@Embedded //optional
	private AdharCard card;
	//one to many association between entity n value type
	@ElementCollection //mandatory
	@CollectionTable(name = "stud_edu",joinColumns = @JoinColumn(name="stud_id"))
	private List<EducationQualifications> qualifications=new ArrayList<>();
	public Student() {
		System.out.println("in stud constr");
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	@Override
	public String toString() {
		return "Student [name=" + name  + ", getId()=" + getId() + "]";
	}
	//add helper methods to add/remove address : bi dir association
	public void addAddress(Address a)
	{
		addr=a;//student---> addr
		a.setStud(this);
	}
	public void removeAddress(Address a)
	{
		addr=null;//student---> addr
		a.setStud(null);
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public AdharCard getCard() {
		return card;
	}
	public void setCard(AdharCard card) {
		this.card = card;
	}
	public List<EducationQualifications> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<EducationQualifications> qualifications) {
		this.qualifications = qualifications;
	}
	
	
	
	

}
