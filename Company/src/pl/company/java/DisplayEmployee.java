package pl.company.java;

import java.util.Scanner;
import java.util.regex.Pattern;
import pl.company.java.domain.Employee;

public class DisplayEmployee {
	
	
	
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


	public static void displayEmployee() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                LISTA PRACOWNIK�W            ######");
		System.out.println("#########################################################");
		
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			System.out.println(i + ": " + employee.getName());
		}
		System.out.println();
		Pattern patternNumber = Pattern.compile("[0-9]+");
		String numberLoaded;
		do {
			System.out.print("Kt�r� osob� chcesz wy�wietli�? ");
			numberLoaded  = getUserInput();
		} while (!patternNumber.matcher(numberLoaded).matches());
		
		Integer numberEmployee = Integer.parseInt(numberLoaded);
		if (employeeDAO.getEmployees().size()>numberEmployee) {
			Employee person = employeeDAO.getEmployees().get(numberEmployee);
			System.out.println("Dane wybranego pracownika "+person.getName()+", nazwisko "+person.getSurname()+", p�e� "+person.getSex()+", numer odzia�u "+person.getNr_department()+" wiek "+person.getAge()+" ilosc dzieci "+person.getChildren()+" status cywilny "+person.getMaritial_status()+" zarobki" + person.getEarnings());
		} else {
			System.out.println("Niestety, nie znalaz�em pracownika o wybranym numerze :( Sprob�j ponownie lub go dodaj!");
		}
	}
	
}
