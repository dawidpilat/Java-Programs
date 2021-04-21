package pl.company.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;



public class CreateFile {
	static Scanner sc = new Scanner(System.in);
	static EmployeeDAO employeeDAO = new EmployeeDAO();

	public static String getUserInput() {
	    return sc.nextLine().trim();
	}

	public static char getUserInputChar() {
	    return sc.next().charAt(0);
	}

	public static int getUserInputInt() {
	    return sc.nextInt();
	}

	public static boolean getUserInputBoolean() {
	    return sc.nextBoolean();
	}

	public static float getUserInputFloat() {
	    return sc.nextFloat();
	}
	
	

	public static void eksport() throws IOException {
		
		try {
		
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(EmployeeDAO.employees);
			

			o.close();
			f.close();

		

			

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}

	}
	
	
}
