import java.io.*;
import java.util.*;

public class Attendances {

	public static void main(String[]args) throws IOException {
		// Initialize the necessary DataStructure
		List<String> attend = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		File attendance = new File("C://Users//CYRIL//OneDrive//Desktop//Attendance.txt");
		System.out.println("File created");
		
		// Add the user's names inside the file
		for(int i = 0; i < 5; i++) {
			System.out.println("Enter user's name: ");
			attend.add(sc.nextLine().toUpperCase());
		}
		
		// Before we write the file, we should sort the data first inside the LinkedList for it to be organized
		Collections.sort(attend);
		
		// Write the user's names from the LinkedList to the Attendance.txt file
		FileWriter writer = new FileWriter("C:/Users/CYRIL/OneDrive/Desktop/Attendance.txt");

		// Now we will write the data inside the linked list to the attendance text file
		for(int i = 0; i < 5; i++) {
			writer.write("▢ " + attend.get(i)+"\n"); // we write the data from the LinkedList to the Attendance.txt file, we added "\n" for a new line in every username
		}
		writer.close();
	}
}
