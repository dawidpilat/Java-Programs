package pl.company.java;

import java.util.Collections;
import java.util.Scanner;

import pl.company.java.domain.Employee;

public class AdditionalFunctions {
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
	
	
	public static void additionalFunctionsEmployee() {
		String userChoice;
		do {
			System.out.println();
			System.out.println("Wybierz, co chcesz zrobi�, a nast�pnie zatwierd� enterem:");
	    	System.out.println("[1] Liczba pracownik�w z pensj� nie mniejsz� ni� podane przez u�ytkownika");
	    	System.out.println("[2] �rednia p�aca w dziale");
	    	System.out.println("[3] Najwi�ksza pensja z wszystkich kobiet lub me�czyzn");
	    	System.out.println("[4] Czy wi�kszo�� pracownik�w w dziale jest kobietami czy me�czyznami");
	    	System.out.println("[5] Wy�weitl stosunek p�ac kobiet do p�ac m�czyzn");
	    	System.out.println("[6] Zwi�ksz pensj� ka�dego pracownika o 10%");
	    	System.out.println("[7] Zwi�ksz pensj� ka�dego pracownika o podan� kwot�?");
	    	System.out.println("[8] Sortowanie pracownik�w wed�ug nazwiska");
	    	System.out.println("[9] Sortowanie pracownik�w wed�ug pensji");
	    	System.out.println("[x] Zako�cz");
	    	userChoice = getUserInput();
			
			if (userChoice.equals("1")) {
				numberEmployess();
				
	    		
	    	} else if (userChoice.equals("2")) {
	    		averageEarnings();
	    	}
	    	else if (userChoice.equals("3")) {
	    		biggestEarnings();
	    	}
	    	else if (userChoice.equals("4")) {
	    		womanman();
	    	}
	    	else if (userChoice.equals("5")) {
	    		ratioEarnings();
	    	}
			
	    	else if (userChoice.equals("6")) {
	    		increasingEarnings10();
	    	}
	    

	    	else if (userChoice.equals("7")) {
	    		increasingEarnings();
	    	}
			

	    	else if (userChoice.equals("8")) {
	    	sortSurname();
	    	}
			

	    	else if (userChoice.equals("9")) {
	    	sortEarnings();
	    	}
			
		} while (!userChoice.equalsIgnoreCase("x"));	
		
		
		
		
	}

	private static void numberEmployess() {
		int k=0;
		float z;
		float salary;
		System.out.println("Wpisz pensje");
		z=getUserInputFloat();
		
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			salary=employee.getEarnings();
			if (salary>=z)
				k++;
				}
		System.out.println(" Liczba pracownik�w=" +k);
		
		
		
		
		
	}

	private static void averageEarnings() {
		float averageSalary=0;;
		float salary;
		int department;
		System.out.println("Wpisz numer dzia�u");	
		department = getUserInputInt();
		float k=0;
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			
			if (department==employee.getNr_department())
				k++;
			salary=employee.getEarnings();
			averageSalary=(averageSalary+salary)/k;
				}
		System.out.println("�rednia pensja pracownik�w dzia�u" +department+"wynosi" +averageSalary );
		
		
	}

	private static void biggestEarnings() {
		
		float max=0;
		float salary;
		char choice;
		char s;
		
		System.out.println("Najwi�ksza pensja kobiet czy m�czyzn. Wybierz m lub k");	
		choice = getUserInputChar(); 
		
		
			
			
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			s=employee.getSex();
			
			if(choice==s) {
			
				salary=employee.getEarnings();
			if (max<salary)
				max=salary;
				}}
		System.out.println(" Maksymalna pensja wynosi = " +max);
			
		
		
			
	}	

	private static void womanman() {
		
		
		char k='k';
		char m='m';
		int k1=0;
		int m1=0;
		
		int k2=0;
		int m2=0;
		
		int k3=0;
		int m3=0;
		
		int j=1;
		int department;
		char s;
		
		
		
		
		
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			department=employee.getNr_department();
			s=employee.getSex();
			
			
			if(department==1) {
				if(s==k) {
					k1++;
				}
				if(s==m) {
					m1++;
				}
				
			}
				
			else if(department==2) {
				if(s==k) {
					k2++;
				}
				if(s==m) {
					m2++;
				}
				
			}
			
			else if(department==3) {
				if(s==k) {
					k3++;
				}
				if(s==m) {
					m3++;
				}
				
			}
				
		
		
		
		
		
	}
		
		System.out.println("Dzial 1 "+ " Liczba kobiet= " +k1 +" Liczba m�czyzn= " +m1 );
		System.out.println("Dzial 2 " + " Liczba kobiet= " +k2 +" Liczba m�czyzn= " +m2 );
		System.out.println("Dzial 3 " + " Liczba kobiet= " +k3 +" Liczba m�czyzn= " +m3 );
		
		
	}

	private static void ratioEarnings() {
		float ASM=0;
		float ASK=0;
		float salary;
		char k='k';
		char m='m';
		char s;
		float j=0;
		float z=0;
		float ratio;
		
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			s=employee.getSex();
		
			if (s==k) {
				j++;
				salary=employee.getEarnings();
				ASK=(ASK+salary)/j;
				}
		
		

			if (s==m) {
				z++;
				salary=employee.getEarnings();
				ASM=(ASM+salary)/z;
				}
			
			
		
		}
		
		ratio=ASK/ASM;
		
		System.out.println("Stosunek p�ac kobiet do m�zczyzn wynosi: " + ratio);
	}



	private static void increasingEarnings10() {
		
		float salary;
		float s;
		
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			s=employee.getEarnings();
			salary=(float) (s+s*0.01);
			employee.setEarnings(salary);	
		
		}	
		
	}

	private static void increasingEarnings() {
		
		float salary;
		float s;
		float u;
		System.out.println("O ile procent chcesz podwy�szy� pensj� wszystkim pracownikom?" );
		u = getUserInputFloat();
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			s=employee.getEarnings();
			salary=(float) (s+s*(u/100));
			employee.setEarnings(salary);	
		
		}		
		
		
		
		
	}



	   
	private static void sortSurname()  {
		String userChoice;
		do {
			System.out.println();
			System.out.println("Wybierz, co chcesz zrobi�, a nast�pnie zatwierd� enterem:");
	    	System.out.println("[1] Sortuj rosn�co");
	    	System.out.println("[1] Sortuj malej�co");
	    	System.out.println("[x] Zako�cz");
	    	userChoice = getUserInput();
			
			if (userChoice.equals("1")) {

				
				Collections.sort(employeeDAO.getEmployees(), Employee.namerosnaco);
	    		
	    	} else if (userChoice.equals("2")) {
	    		Collections.sort(employeeDAO.getEmployees(), Employee.namemalejaco);
	    	}
			
		} while (!userChoice.equalsIgnoreCase("x"));
		
		
		
	}



	  
	private static void sortEarnings() {
		
		String userChoice;
		do {
			System.out.println();
			System.out.println("Wybierz, co chcesz zrobi�, a nast�pnie zatwierd� enterem:");
	    	System.out.println("[1] Sortuj rosn�co");
	    	System.out.println("[2] Sortuj malej�co");
	    	System.out.println("[x] Zako�cz");
	    	userChoice = getUserInput();
			
			if (userChoice.equals("1")) {
				Collections.sort(employeeDAO.getEmployees(), Employee.pensjarosnaco);	

				
	    		
	    	} else if (userChoice.equals("2")) {
	    		Collections.sort(employeeDAO.getEmployees(), Employee.pensjamalejaco);
	    	}
			
		} while (!userChoice.equalsIgnoreCase("x"));	
		
		
		

	}





	public static void additionalFunctionsFile() {
		String userChoice;
		do {
			System.out.println();
			System.out.println("Wybierz, co chcesz zrobi�, a nast�pnie zatwierd� enterem:");
	    	System.out.println("[1] Wy�wietl osob� o najd�uzszym nazwisku");
	    	System.out.println("[2] Obliczenie �redniego wieku os�b posiadaj�cych dzieci");
	    	System.out.println("[3] Kodowanie danych");
	    	System.out.println("[4] Utw�rz plik html.");
	    	System.out.println("[x] Zako�cz");
	    	userChoice = getUserInput();
			
			if (userChoice.equals("1")) {
				longestSurname();
				
	    		
	    	} else if (userChoice.equals("2")) {
	    		averageAge();
	    	}
			
			 else if (userChoice.equals("3")) {
				 encodedData();
			}
			
			 else if (userChoice.equals("4")) {
				fileHtml();
			}
			
		} while (!userChoice.equalsIgnoreCase("x"));	
		
		
		
		
	}


	private static void longestSurname() {
		int max=0;
		
		
		String s;
		int w;
		
		Employee employee;
		for (int i=0; i<employeeDAO.getEmployees().size(); i++) {
			employee = employeeDAO.getEmployees().get(i);
			s=employee.getName();
			w=s.length();
			 
			
			
			if (max<w)
				max=w;
			
			
				}
		System.out.println("Najd�u�sze nazwisko to = " +max);
		
		
	}

	private static void averageAge() {
	}

	private static void encodedData() {
	}

	private static void fileHtml() {
	}


	}
		
	
	

