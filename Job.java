import java.util.ArrayList;
import java.sql.Date;


public class Job {
    private int employeeID; // The ID of the employee
    private String name; // The name of the job
    private String title; // The title of the job
    private String supervisor; // The supervisor of the job
    private Date dateHired; // The date the job was hired

    /**
     * Constructor to create a new Job object.
     * @param employeeID The ID of the employee.
     * @param name The name of the job.
     * @param title The title of the job.
     * @param supervisor The supervisor of the job.
     * @param dateHired The date the job was hired.
     */
    public Job(int employeeID, String name, String title, String supervisor, Date dateHired) {
        this.employeeID = employeeID;
        this.name = name;
        this.title = title;
        this.supervisor = supervisor;
        this.dateHired = dateHired;
    }

    /**
     * Get the employee ID.
     * @return The employee ID.
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Set the employee ID.
     * @param employeeID The employee ID to set.
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Get the name of the job.
     * @return The name of the job.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the job.
     * @param name The name of the job to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the title of the job.
     * @return The title of the job.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the job.
     * @param title The title of the job to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the supervisor of the job.
     * @return The supervisor of the job.
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * Set the supervisor of the job.
     * @param supervisor The supervisor of the job to set.
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * Get the date the job was hired.
     * @return The date the job was hired.
     */
    public Date getDateHired() {
        return dateHired;
    }

    /**
     * Set the date the job was hired.
     * @param dateHired The date the job was hired to set.
     */
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    /**
     * Override toString method to display Job details.
     * @return String representation of Job details.
     */
    @Override
    public String toString() {
        return "Job{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", dateHired=" + dateHired +
                '}';
    }

    public int getID() {
        return employeeID;
       
    }

    public static void add(Job j) {
        
    }
}
