import java.util.ArrayList;

public class TempArrays {

    public TempArrays() {
        ArrayList<Employee> employees; // John
        ArrayList<Task> tasks; // Duru
        ArrayList<Skill> skills; // Duru
        ArrayList<Job> jobs; // Jaden
        ArrayList<Evaluation> evaluations; // Jaden
    }

    public void editEmployee(int ID, String attribute, String newValue) {}
    public void deleteEmployee() {}

    public void addTask() {}
    public void editTask() {}
    public void deleteTask() {}

    public void addSkill() {}
    public void editSkill() {}
    public void deleteSkill() {}

    public void addJob(int ID, String , String title, String supervisor, int dateHired) {}

    public void editJob(String title, String supervisor, int ID) {}
    public void deleteJob(String title) {}

    public void editEvaluation(int evaluationID, String employeeState, char grade) {}
    public void deleteEvaluation(String name, int evaluationID, String employeeState, char grade ) {}

}