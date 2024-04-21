import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Employee {
    private int employeeID;

    private String firstName;
    private String lastName;
    private String fullName;

    private String streetAddress; // Should be written something like "1234 Sycamore Street"
    private String city;
    private String state;
    private String zip;
    private String fullAddress;

    private int phone;
    private String email;

    private String title;
    private String supervisor;
    private Date dateHired; // Should be formatted as three different ints, YYYY MM DD

    ArrayList<Task> tasks;
    ArrayList<Skill> skills;
    ArrayList<Job> jobs;
    Evaluation evaluation;

    public Employee(String lastName, String firstName,
                    String streetAddress, String city, String state, String zip,
                    int phone, String email,
                    String title, String supervisor, Date dateHired) {
        this.employeeID = generateRandomID();

        this.lastName = lastName;
        this.firstName = firstName;
        this.fullName = firstName + " " + lastName;

        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.fullAddress = streetAddress + " " + city + ", " + state + " " + zip;

        this.phone = phone;
        this.email = email;
        
        this.title = title;
        this.supervisor = supervisor;
        this.dateHired = new Date(); // Default is the date and time at which the object is instantiated

        this.evaluation = new Evaluation(this.employeeID, "N/A", 'C');

        Temparrays.employees.add(this); // Add new Employee to employees
    }

    public int generateRandomID() {
        Random random = new Random();
        int newID = random.nextInt(899999999) + 100000000; // Generates a unique 9-digit number greater than 100,000,000
        boolean unique = true;

        for (int i = 0; i < Temparrays.employees.size(); i++) {
            if (Temparrays.employees.get(i).employeeID == newID) { // Checks generated ID against pre-existing ones
                unique = false;
                break;
            }
        }

        if (unique == true) {
            return newID;
        } else {
            return generateRandomID(); // If no unique ID is found, it runs the method again
        }
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public int getTaskId(int i) {
        return tasks.get(i).getId();
    }

    public void addSkill(Skill s) {
        skills.add(s);
    }

    public int getSkillId(int i) {
        return tasks.get(i).getId();
    }

    public void addJob(Job j) {
        jobs.add(j);
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
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

    public String getFullName() {
        return fullName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {  // Dates should be declared as Date(int year, int month, int day)
        this.dateHired = dateHired;
    }
}