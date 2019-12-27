package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course extends AbstractEntity {
	@Column(length = 20, unique = true)
	private String name;
	@Column(name = "strt_dt")
	private LocalDate strtDate;
	@Column(name = "end_dt")
	private LocalDate endDate;
	private double fees;
	private int capacity;
	// one -to -many between entities
	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.ALL/* ,fetch = FetchType.EAGER */)
	private List<Student> students = new ArrayList<>();

	public Course() {
		System.out.println("in course constr");
	}

	public Course(String name, LocalDate strtDate, LocalDate endDate, double fees, int capacity) {
		super();
		this.name = name;
		this.strtDate = strtDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStrtDate() {
		return strtDate;
	}

	public void setStrtDate(LocalDate strtDate) {
		this.strtDate = strtDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + getId() + ", name=" + name + ", strtDate=" + strtDate + ", endDate=" + endDate
				+ ", fees=" + fees + ", capacity=" + capacity + "]";
	}
	//in case bi-dir asso provide helper methods
	//for adding / removing a student
	public void addStudent(Student s)
	{
		students.add(s);
		s.setSelectedCourse(this);
	}
	public void removeStudent(Student s)
	{
		students.remove(s);
		s.setSelectedCourse(null);
	}


}
