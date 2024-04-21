import java.util.ArrayList;
import java.util.Date;

public class TempArrays {
   private ArrayList<Job> jobs;          // Array list to store Job objects
    private ArrayList<Evaluation> evaluations;  // Array list to store Evaluation objects

    // Constructor to initialize TempArray with empty ArrayLists
    public TempArrays() {
        this.jobs = new ArrayList<>();
        this.evaluations = new ArrayList<>();
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

    // Methods for managing Job objects

    // Add a new Job to the jobs list
    public void addJob(Job job) {
        jobs.add(job);
    }

    // Edit an existing Job in the jobs list at the specified index
    public void editJob(int index, Job newJob) {
        if (index >= 0 && index < jobs.size()) {
            jobs.set(index, newJob);
        } else {
            System.out.println("Invalid index");
        }
    }

    // Delete an existing Job from the jobs list at the specified index
    public void deleteJob(int index) {
        if (index >= 0 && index < jobs.size()) {
            jobs.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    // Get all Job objects in the jobs list
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    // Get a specific Job from the jobs list at the specified index
    public Job getJob(int index) {
        if (index >= 0 && index < jobs.size()) {
            return jobs.get(index);
        } else {
            System.out.println("Invalid index");
            return null;
        }
    }

   // Methods for managing Evaluation objects

    // Add a new Evaluation to the evaluations list
    public void addEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }

    // Edit an existing Evaluation in the evaluations list at the specified index
    public void editEvaluation(int index, Evaluation newEvaluation) {
        if (index >= 0 && index < evaluations.size()) {
            evaluations.set(index, newEvaluation);
        } else {
            System.out.println("Invalid index");
        }
    }

    // Delete an existing Evaluation from the evaluations list at the specified index
    public void deleteEvaluation(int index) {
        if (index >= 0 && index < evaluations.size()) {
            evaluations.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    // Get all Evaluation objects in the evaluations list
    public ArrayList<Evaluation> getEvaluations() {
        return evaluations;
    }

    // Get a specific Evaluation from the evaluations list at the specified index
    public Evaluation getEvaluation(int index) {
        if (index >= 0 && index < evaluations.size()) {
            return evaluations.get(index);
        } else {
            System.out.println("Invalid index");
            return null;
        }
    }
}