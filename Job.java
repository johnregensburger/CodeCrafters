import java.sql.Date;

public class Job {
    // Attributes of the Job class
    private int ID;             // Unique identifier for the job
    private String name;        // Name of the employee in the job
    private String title;       // Title or position of the job
    private String supervisor;  // Name of the supervisor for the job
    private Date dateHired;     // Date when the employee was hired for the job

    // Constructor to initialize a Job object
    public Job(int ID, String name, String title, String supervisor, Date dateHired) {
        this.ID = ID;
        this.name = name;
        this.title = title;
        this.supervisor = supervisor;
        this.dateHired = dateHired;
    }

    // Getter method for retrieving the job ID
    public int getID() {
        return ID;
    }

    // Getter method for retrieving the employee name
    public String getName() {
        return name;
    }

    // Setter method for updating the employee name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for retrieving the job title
    public String getTitle() {
        return title;
    }

    // Setter method for updating the job title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method for retrieving the supervisor name
    public String getSupervisor() {
        return supervisor;
    }

    // Setter method for updating the supervisor name
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    // Getter method for retrieving the date of hire
    public Date getDateHired() {
        return dateHired;
    }

    // Setter method for updating the date of hire
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public static void add(Job j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
