import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}

// *********************************************************************
class Person {
	private String firstName;
	private String lastName;
	private int idNumber;

	// Constructor
	Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

	// Print person data
	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
	}

}

// -------------------------------------------------------------------

/*
 * class Person retains firstName, lastName, and the ID int, however Student is
 * differentiated with the fact it contains an int array of the test scores
 */
class Student extends Person {

	private int[] testScores;

	Student(String firstName, String lastName, int identification, int[] testScores) {
		/*
		 * Make a Person parent class with the details provided, then add the necessary
		 * testScores to make the Student differentiated from the person because of the
		 * scores variable.
		 */
		super(firstName, lastName, identification);
		try {
			identificationLimit(identification);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(
					"ID must be 7 numbers long. Enter a valid ID for: " + "\nName: " + firstName + " " + lastName);
		}
		this.testScores = testScores;

	}

	static void identificationLimit(int id) throws IndexOutOfBoundsException {
		// Check that the ID number has 7 digits as per. project constraints
		int length = String.valueOf(id).length();
		if (length == 7) {

		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	public char calculate() {
		// Evaluate the average of the grades then apply that to a letter grade and
		// return char
		char character = 0;
		int totalScoreAccumulated = 0;
		for (int testScore : testScores) {
			totalScoreAccumulated += testScore;
		}

		int averageGrade = totalScoreAccumulated / testScores.length;
		// System.out.println(averageGrade + "." + (totalScoreAccumulated %
		// testScores.length) );
		if (averageGrade >= 90 && averageGrade <= 100)
			character = 'O';
		else if (averageGrade >= 80 && averageGrade < 90)
			character = 'E';
		else if (averageGrade >= 70 && averageGrade < 80)
			character = 'A';
		else if (averageGrade >= 55 && averageGrade < 70)
			character = 'P';
		else if (averageGrade >= 40 && averageGrade < 55)
			character = 'D';
		else if (averageGrade < 40)
			character = 'T';
		return character;

	}

	// An override probably isn't all that necessary here, but whatever it works and
	// I'd rather not poke the beast
	@Override
	public void printPerson() {
		super.printPerson();
	}

}