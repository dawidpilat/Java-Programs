package pl.company.java.domain;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Employee implements Serializable{

	
	private String name;
	private String surname;
    private char sex;
    private int nr_department;
    private Date age;
    private int children;
    private boolean maritial_status;
    private float earnings;
	
    
    
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public char getSex() {
		return sex;
	}
	
	public int getNr_department() {
		return nr_department;
	}
	public Date getAge() {
		return age;
	}
	public int getChildren() {
		return children;
	}
	public boolean getMaritial_status() {
		return maritial_status;
	}
	
	public float getEarnings() {
			return earnings;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public void setNr_department(int nr_department) {
		this.nr_department = nr_department;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public void setMaritial_status(boolean maritial_status) {
		this.maritial_status = maritial_status;
	}
	public void setEarnings(float earnings) {
		this.earnings = earnings;
	}
	
	
	 
	

public static Comparator<Employee> namerosnaco = new Comparator<Employee>() {
	
	public int compare(Employee s1, Employee s2) {
	   String StudentName1 = s1.getName().toUpperCase();
	   String StudentName2 = s2.getName().toUpperCase();

	   //ascending order
	   return StudentName1.compareTo(StudentName2);

   }};
   
   
   public static Comparator<Employee> namemalejaco = new Comparator<Employee>() {

		public int compare(Employee s1, Employee s2) {
		   String StudentName1 = s1.getName().toUpperCase();
		   String StudentName2 = s2.getName().toUpperCase();

		 

		 
		   return StudentName2.compareTo(StudentName1);
	   }};
	   
	   public static Comparator<Employee> pensjarosnaco = new Comparator<Employee>() {

			public int compare(Employee s1, Employee s2) {

			   float rollno1 = s1.getEarnings();
			   float rollno2 = s2.getEarnings();

			   /*For ascending order*/
			   return (int)(rollno1-rollno2);

			   /*For descending order*/
			   //rollno2-rollno1;
		  }};
		  
		  public static Comparator<Employee> pensjamalejaco = new Comparator<Employee>() {

				public int compare(Employee s1, Employee s2) {

				   float rollno1 = s1.getEarnings();
				   float rollno2 = s2.getEarnings();

				  
				  
				   return (int)(rollno2-rollno1);
				   
				   
			  }};
		  
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", sex=" + sex + ", nr_department=" + nr_department
				+ ", age=" + age + ", children=" + children + ", maritial_status=" + maritial_status + ", earnings="
				+ earnings + "]";
	}
	
	 
	
   
    
}
