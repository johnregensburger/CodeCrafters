import java.util.Random;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String title;
    private String supervisor;
    private int dateHired;

    public Employee(int employeeID, String lastName, String firstName, String title, String supervisor, int dateHired) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.supervisor = supervisor;
        this.dateHired = dateHired;
    }

    public void generateRandomID() {
    Random random = new Random();
    int newID = random.nextInt(900000000) + 100000000; // Generate a 9-digit number
    this.employeeID = newID;
}


    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public int getDateHired() {
        return dateHired;
    }

    public void setDateHired(int dateHired) {
        this.dateHired = dateHired;
    }

    public int getID() {
        return employeeID;
    }
    
}

