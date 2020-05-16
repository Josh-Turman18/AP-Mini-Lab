
/*
 * Classroom class
 */
public class Classroom extends Generics 
{
	public static final String type = "Classroom";
	public enum KeyType {combo, subject, grade, numStudents};
	public static KeyType key = KeyType.combo;
	private String subject; 
	private int grade; 
	private int numStudents;
	
	public Classroom(String subject, int grade, int numStudents)
	{
		this.setType(type);
		this.subject = subject;
		this.grade = grade;
		this.numStudents = numStudents;
	}

	
	// providing output for classroom based off of what the key is
	@Override
	public String toString()
	{
		String output="";
		switch(key) {
		case subject:
			output += this.subject;
			break;
		case grade:
			output += "000" + this.grade;
			output = output.substring(output.length()-3);
			break;
		case numStudents:
			output += "000" + this.numStudents;
			break;
		case combo:
		default:
			output += type + ": " + this.subject  + ", " + this.grade + ", " + this.numStudents; 
		}
		return output;
	}
	
	/* Initialize Classroom data
	 * returns an array of data
	 * 
	 */
	public static Generics[] classroomData() {
		Generics[] ad = { 
				new Classroom("AP Physics C: Mechanics", 11, 36),
				new Classroom("Economics", 12, 40),
				new Classroom("AP Computer Science A", 10, 28),
				new Classroom("AP Calculus BC", 11, 30),
				new Classroom("Expos", 12, 37),
				new Classroom("Civics", 12, 38)
		};
		return ad;
	}
	
	/* main to test Classroom class
	 * 
	 */
	public static void main(String[] args)
	{
		Generics[] ad = classroomData();
		for(Generics a : ad)
			System.out.println(a);
	}

	
}
