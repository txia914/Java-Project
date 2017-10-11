package StudentDiary;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class StudentProfile {
	String name;
	String rollno;
	Date DOB;
	String college;
	int semester;
	
	public StudentProfile() {
		name = "";
		rollno = "";
		college = "";
		semester = 1;
		Calendar C = Calendar.getInstance();
		C.set(2017, 1, 1);
		DOB = C.getTime();
	}
	public StudentProfile(String name, String rollno, Date DOB, String college, int semester) {
		this.name = name;
		this.rollno = rollno;
		this.DOB = DOB;
		this.college = college;
		this.semester = semester;
	}
	public String getname() {
		return name;
	}
	public String getrollno() {
		return rollno;
	}
	public Date getDOB() {
		return DOB;
	}
	public String getcollege() {
		return college;
	}
	public int getsemester() {
		return semester;
	}
	public void newStudentProfile() {
		System.out.println("Enter the Name");
		Scanner s = new Scanner(System.in);
		this.name = s.next();
		System.out.println("Enter roll no");
		this.rollno = s.next();
		System.out.println("Enter the name of the college");
		this.college = s.next();
		System.out.println("Enter date of birth in day , month , year format");
		int day, month, year;
		day = s.nextInt();
		month = s.nextInt();
		year = s.nextInt();
		Calendar C = Calendar.getInstance();
		C.set(year, month-1, day);
		this.DOB = C.getTime();
		System.out.println("Enter the semester");
		this.semester = s.nextInt();
	}
	
	public static StudentProfile readfile() {
			try {
				FileInputStream f = new FileInputStream("StudentProfile.txt");
				ObjectInputStream o = new ObjectInputStream(f);
				StudentProfile sp = (StudentProfile)o.readObject();
				StudentProfile s = new StudentProfile(sp.getname(), sp.getrollno(), sp.getDOB(), sp.getcollege(), sp.getsemester());
				return s;
			}
			
			catch(FileNotFoundException fof) {
				System.out.println("File not found!");
			}
			
			catch(IOException ioe) {
				System.out.println("File may be corrupt!");
			}
			
			catch(ClassNotFoundException cnf) {
				System.out.println("Class not found!");
			}
			return null;
	}
	
	public static void writefile(StudentProfile sp) {
		try {
			FileOutputStream f = new FileOutputStream("StudentProfile.txt", true);
			ObjectOutputStream o = new ObjectOutputStream(f);
			StudentProfile s = new StudentProfile(sp.name, sp.rollno, sp.DOB, sp.college, sp.semester);
			o.writeObject(s);			
		}
		
		catch(FileNotFoundException fof) {
			System.out.println("File not found!");
		}
	
		catch(IOException ioe) {
			System.out.println("File may be corrupt!");
		}
	}
	public void PrintDetails() {
		
		SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Name:" + name + "\n" + "Roll No:" + rollno + "\n" + "DOB:" + dateOnly.format(DOB) + "\n" + "College:" + college + "\n" + "Semsester" + semester);
		
	}
	
}
