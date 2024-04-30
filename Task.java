import java.util.Date;

public class Task {

    public Task(int taskId, int employeeId, String name, boolean completed, Date dateAssigned, Date dateCompleted, double progress) {
        this.taskId = taskId;
        this.employeeId = employeeId;
        this.name = name;
        this.dateAssigned = dateAssigned;
        this.dateCompleted = dateCompleted;
        this.progress = progress;
    }
    
    private int taskId;
    private int employeeId;
    private String name;
    private boolean completed;
    private Date dateAssigned;
    private Date dateCompleted;
    private double progress;

    public int getId() {
        return taskId;
    }

    public void setId(int taskId) {
        this.taskId = taskId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setDateAssigned(Date dateAssigned){
        this.dateAssigned = dateAssigned;
    }

    public void setDateCompleted(Date dateCompleted){
        this.dateCompleted = dateCompleted;
    }

    public void setProgress(double progress){
        this.progress = progress;
    }

    public String getName(){
        return this.name;
    }

    public boolean getCompleted(){
        return this.completed;
    }

    public Date getDateAssigned(){
        return this.dateAssigned;
    }

    public Date getDateCompleted(){
        return this.dateCompleted;
    }

    public double getProgress(){
        return this.progress;
    }
}