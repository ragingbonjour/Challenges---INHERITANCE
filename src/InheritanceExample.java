import java.util.Locale;
import java.text.NumberFormat;

class Employee {
    // instance variables:
    protected String name; 
    private int salary; 
    
    /** Parameterized Constructor 
    *	@param name The volunteer's name. **/
    Employee(String name){
    	// use name param to initialize instance variable:
        this.name = name; 
    }
    
    /** @return The name instance variable. **/
    String getName(){
        return name; 
    }
    
    /** @param salary The integer to set as the salary instance variable. **/
    void setSalary(int salary){
        this.salary = salary; 
    }
    
    /** @return The salary instance variable. **/
    int getSalary(){
        return salary; 
    }
    
    /** Print information about an instance of Employee. **/
    void print(){
        if(this.salary == 0){
            System.err.println("Error: No salary set for " + this.name 
                + "; please set salary and try again.\n");
        }
        else{ // Print employee information
            // Formatter for salary that will add commas between zeroes:
            NumberFormat salaryFormat = NumberFormat.getNumberInstance(Locale.US);
            
            System.out.println("Employee Name: " + this.name 
                + "\nSalary: " + salaryFormat.format(this.salary) + "\n");
        }
    }
}

class Volunteer extends Employee{
	// instance variable:
    int hours;
    
    /** Parameterized Constructor 
    * 	@param name The volunteer's name. **/
    Volunteer(String name){
    	// explicit call to superclass' parameterized constructor
        super(name);  
    }
    
    /** @param Set the hours instance variable. **/
    void setHours(int hours){
        this.hours = hours; 
    }
    
    /** @return The hours instance variable **/
    int getHours(){
        return hours; 
    }
    
    @Override 
    /** Overrides the superclass' print method and prints information about an instance of Volunteer. **/
    void print(){ 
        System.out.println("Volunteer Name: " + this.getName() 
            + "\nHours: " + this.getHours());    
    }
}