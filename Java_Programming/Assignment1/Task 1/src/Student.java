import java.time.LocalDate; // for get the year of now

public class Student {
	
	public String studentName; // for store student name
	public int dateOfBirth; // for store the year of the birth
	public float cumulativeGPA; 
	public String department;
	public int age; // year of now - year of the birth
	
	public Student() {} // default constructor
	
	// overloading constructor
	public Student(String name, int birth, float gpa, String dep) {
		studentName = name;
		dateOfBirth = birth;
		cumulativeGPA = gpa;
		department = dep;
	}
	
	// method for calculate the age by year of now - year of the birth
	// argument 'birth' is the data that 'dateOfBirth'
	public void calculateAge(int birth) {
		
		LocalDate now = LocalDate.now();
		age = now.getYear() - birth;
		
	}
	
	// return the name of student
	public String getStudentName() {
		
		return studentName;
	}
	
	// return the age
	public int getAge() {
		
		return age;
	}
	
	// return cumulatibeGPA
	public float getGpa() {
		
		return cumulativeGPA;
	}
	
	//return department
	public String getDepartment() {
		
		return department;
	}
}
