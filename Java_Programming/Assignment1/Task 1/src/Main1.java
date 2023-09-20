import java.util.Scanner; // for take the data from users

public class Main1 {

	public static void main(String[] args) {
		
		String studentName;
		int dateOfBirth;
		float gpa;
		String department;
		String buffer; // variable for treating the newline problems
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		studentName = sc.nextLine();
		System.out.print("Enter your date of birth: ");
		dateOfBirth = sc.nextInt();
		System.out.print("Enter your cumulative GPA: ");
		gpa = sc.nextFloat();
		System.out.print("Enter your department: ");
		buffer = sc.nextLine(); // for treating the newline problems
		department = sc.nextLine();
		sc.close(); // close the sc variable 
		
		
		Student studentObject = new Student(studentName, dateOfBirth, gpa, department); // create object
		
		// calculate the age by calculateAge method
		// argument is dateOfBirth
		studentObject.calculateAge(dateOfBirth); 
		System.out.println("=============================");
		System.out.println("Student name: " + studentObject.getStudentName()); // coming from Student class
		System.out.println("Student's age: " + studentObject.getAge());
		System.out.println("Student's CGPA: " + studentObject.getGpa());
		System.out.println("Student's department: " + studentObject.getDepartment());
		

	}

}
