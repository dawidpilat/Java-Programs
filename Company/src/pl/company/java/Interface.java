package pl.company.java;
import java.io.IOException;
import java.util.Scanner;



public class Interface  {
	
	

	
static Scanner sc = new Scanner(System.in);
static EmployeeDAO employeeDAO = new EmployeeDAO();
public static String getUserInput() {
    return sc.nextLine().trim();
}





public static void main(String[] args) throws IOException {
	String userChoice;
	do {
		System.out.println();
		System.out.println("Wybierz, co chcesz zrobiæ, a nastêpnie zatwierdŸ enterem:");
    	System.out.println("[1] Wyswietl wszystkich pracownikow");
    	System.out.println("[2] Dodaj pracownika");
    	System.out.println("[3] Eksport");
    	System.out.println("[4] Usuwanie pracownikow");
    	System.out.println("[5] Edycja danych");
    	System.out.println("[6] Dodatkowe funkcje");
    	System.out.println("[7] Dodatkowe funkcje dla plikow tekstowych");
    	System.out.println("[8] Informacje o programie");
    	System.out.println("[x] Zakoñcz");
    	userChoice = getUserInput();
		
		if (userChoice.equals("1")) {
    		DisplayEmployee.displayEmployee();
    		
    	} else if (userChoice.equals("2")) {
    		CreateEmployee.addEmployee();
    	}
    	else if (userChoice.equals("3")) {
    		CreateFile.eksport();
    	}
    	else if (userChoice.equals("4")) {
    		CreateEmployee.deleteEmployee();
    	}
    	else if (userChoice.equals("5")) {
    		CreateEmployee.changeEmployee();
    	}
		
    	else if (userChoice.equals("6")) {
    		AdditionalFunctions.additionalFunctionsEmployee();
    	}
		
    	else if (userChoice.equals("7")) {
    		AdditionalFunctions.additionalFunctionsFile();
    	}
    
	} while (!userChoice.equalsIgnoreCase("x"));
    
}











	





}
	
	
	






