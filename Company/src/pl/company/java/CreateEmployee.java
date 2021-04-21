package pl.company.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import pl.company.java.domain.Employee;

public class CreateEmployee {
	
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
	

	public static void addEmployee() {
		
		

		
		
		
		
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 DODAJ  PRACOWNIKA           ######");
		System.out.println("#########################################################");
		Employee employee = new Employee();
		
		System.out.print("Podaj imiê pracownika: ");
		employee.setName(getUserInput());
		
		System.out.print("Podaj nazwisko pracownika: ");
		employee.setSurname(getUserInput());
		
		System.out.print("Podaj p³eæ pracownika ");
		employee.setSex(getUserInputChar());
		
		System.out.print("Podaj numer dzia³u: ");
		employee.setNr_department(getUserInputInt());

	    Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	    String dataUrodzeniaWczytana;
	    do {
	        System.out.print("Podaj datê urodzenia kota w formacie RRRR.MM.DD: ");
	        dataUrodzeniaWczytana = getUserInput();
	        if (wzorzecDaty.matcher(dataUrodzeniaWczytana).matches()) {
	        	try {
	        		employee.setAge(sdf.parse(dataUrodzeniaWczytana));
	        	} catch (ParseException pe) {
	        		System.out.println("Coœ jest nie tak z dat¹! Przyk³adowa data: 2014.01.05");
	        	}
	        }
	    } while (employee.getAge()==null);
	    
	    
	    System.out.print("Podaj iloœæ dzieci ");
		employee.setChildren(getUserInputInt());
		
		System.out.print("Podaj status cywilny ");
		employee.setMaritial_status(getUserInputBoolean());
		
		System.out.print("Podaj zarobki pracownika ");
		employee.setEarnings(getUserInputFloat());
	    
	    

	    employeeDAO.add(employee);
	    
	    System.out.println("Dziêkujê");
	    
	      
	}
	
	public static void deleteEmployee() {
		
		Pattern patternNumber = Pattern.compile("[0-9]+");
		String numberLoaded ;
		do {
			System.out.print("Któr¹ osobê chcesz usun¹æ? ");
			numberLoaded = getUserInput();
		} while (!patternNumber.matcher(numberLoaded).matches());
		
		Integer numberEmployee = Integer.parseInt(numberLoaded);
		if (employeeDAO.getEmployees().size()>numberEmployee) {
			Employee person = employeeDAO.getEmployees().get(numberEmployee);
			employeeDAO.delete(person);
			System.out.println("Pracownik zosta³ usuniêty" );
		} else {
			System.out.println("Niestety, nie znalaz³em pracownika o wybranym numerze :( Sprobój ponownie lub go dodaj!");
		}	
		
	}
	
	
	
	public static void changeEmployee(){
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                LISTA PRACOWNIKÓW            ######");
		System.out.println("#########################################################");
		
		Employee employee = null;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			System.out.println(i + ": " + employee.getName() +  employee.getSurname()+ employee.getNr_department()+ employee.getChildren()+ employee.getSex()+ employee.getAge()+ employee.getMaritial_status() + employee.getEarnings());
		}
			Pattern patternNumber = Pattern.compile("[0-9]+");
			String numberLoaded;
			do {
				System.out.print("Którego pracownika chcesz edytowaæ? ");
				numberLoaded = getUserInput();
			} while (!patternNumber.matcher(numberLoaded).matches());
			
			
			Integer numberEmployee = Integer.parseInt(numberLoaded);
			if (employeeDAO.getEmployees().size()>numberEmployee) {
				Employee person = employeeDAO.getEmployees().get(numberEmployee);
			
		
			String userChoice;
			do {
				

				
				System.out.println();
				System.out.println("Wybierz co chcesz edytowaæ:");
		    	System.out.println("[1] Imiê");
		    	System.out.println("[2] Nazwisko");
		    	System.out.println("[3] P³eæ");
		    	System.out.println("[4] Numer Departamentu");
		    	System.out.println("[5] Wiek");
		    	System.out.println("[6] Liczbê dzieci");
		    	System.out.println("[7] Status cywilny");
		    	System.out.println("[8] Zarobki");
		   
		    	System.out.println("[x] Zakoñcz");
		    	userChoice = getUserInput();
				
				
				
				
				
				if (userChoice.equals("1")) {

					System.out.print("Podaj imiê pracownika: ");
					person.setName(getUserInput());
		    	} else if (userChoice.equals("2")) {
		    		System.out.print("Podaj nazwisko pracownika: ");
		    		person.setSurname(getUserInput());
		    	}
		    	else if (userChoice.equals("3")) {
		    		System.out.print("Podaj p³eæ pracownika ");
		    		person.setSex(getUserInputChar());
		    	}
		    	else if (userChoice.equals("4")) {
		    		System.out.print("Podaj numer dzia³u: ");
		    		person.setNr_department(getUserInputInt());
		    	}
		    	else if (userChoice.equals("5")) {
		    		 Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
		    		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		    		    String dataUrodzeniaWczytana;
		    		    do {
		    		        System.out.print("Podaj datê urodzenia kota w formacie RRRR.MM.DD: ");
		    		        dataUrodzeniaWczytana = getUserInput();
		    		        if (wzorzecDaty.matcher(dataUrodzeniaWczytana).matches()) {
		    		        	try {
		    		        		person.setAge(sdf.parse(dataUrodzeniaWczytana));
		    		        	} catch (ParseException pe) {
		    		        		System.out.println("Coœ jest nie tak z dat¹! Przyk³adowa data: 2014.01.05");
		    		        	}
		    		        }
		    		    } while (person.getAge()==null);
		    		    
		    	}
		    	else if (userChoice.equals("6")) {
		    		 
		    	    System.out.print("Podaj iloœæ dzieci ");
		    	    person.setChildren(getUserInputInt());
		    	}
		    	else if (userChoice.equals("7")) {
		    		System.out.print("Podaj status cywilny ");
		    		person.setMaritial_status(getUserInputBoolean());
		    	    
		    	}
				
		    	else if (userChoice.equals("8")) {
		    		System.out.print("Podaj zarobki ");
		    		person.setEarnings(getUserInputFloat());
		    	    
		    	}
		    
			} while (!userChoice.equalsIgnoreCase("x"));
		    
			
			
			
		
	}}
	
}
