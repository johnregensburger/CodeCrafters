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

    public void addJob(int ID, String name, String title, String supervisor, int dateHired, ArrayList<Employee> jobs) {
        Job.add(new Job(ID, name, title, supervisor, dateHired));
    }

    public void editJob(int ID, String title, String supervisor, Job[] jobs) {
        for (Job job : jobs) {
            if (job.getID() == ID) {
                job.setTitle(title);
                job.setSupervisor(supervisor);
                break;
            }
        }
    }

    public void deleteJob(int ID, ArrayList<Employee> jobs) {
        jobs.removeIf(job -> job.getID() == ID);
    }

    public void editEvaluation(int evaluationID, String employeeState, char grade) {}
    public void deleteEvaluation(String name, int evaluationID, String employeeState, char grade ) {}

}