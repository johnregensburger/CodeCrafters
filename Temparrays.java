import java.util.ArrayList;
import java.util.Date;
public class Temparrays {
    public static void main(String[] args) {}
    public static ArrayList<Employee> employees; //John
    public static ArrayList<Task> tasks; // Duru
    public static ArrayList<Skill> skills; // Duru
    public static ArrayList<Job> jobs; // Jaden
    public static ArrayList<Evaluation> evaluations; // Jaden

    public Temparrays() {}

    //public void editEmployee(int ID, String attribute, String newValue) {}

    // editEmployee() will be overloaded so it is compatible with int, String, and Date
    
    /**
     * 
     * @param selectedID The ID of the Employee whose data will be edited
     * @param attribute The attribute to be edited
     * @param newData The new value for the attribute
     */
    public void editEmployee(int selectedID, String attribute, int newData) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == selectedID) {
                Employee e = employees.get(i);
                switch (attribute) {
                    case "employeeID":
                        e.setEmployeeID(newData);
                        break;
                    case "phone":
                        e.setPhone(newData);
                        break;
                }
                break;
            }
        }
    }

    /**
     * 
     * @param selectedID The ID of the Employee whose data will be edited
     * @param attribute The attribute to be edited
     * @param newData The new value for the attribute
     */
    public void editEmployee(int selectedID, String attribute, String newData) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == selectedID) {
                Employee e = employees.get(i);
                switch (attribute) {
                    case "firstName":
                        e.setFirstName(newData);
                        break;
                    case "lastName":
                        e.setLastName(newData);
                        break;
                    case "streetAddress":
                        e.setStreetAddress(newData);
                        break;
                    case "city":
                        e.setCity(newData);
                        break;
                    case "state":
                        e.setState(newData);
                        break;
                    case "zip":
                        e.setZip(newData);
                        break;
                    case "email":
                        e.setEmail(newData);
                        break;
                    case "title":
                        e.setTitle(newData);
                        break;
                    case "supervisor":
                        e.setSupervisor(newData);
                        break;
                }
                break;
            }
        }
    }

    /**
     * 
     * @param selectedID The ID of the Employee whose data will be edited
     * @param attribute The attribute to be edited
     * @param newData The new value for the attribute
     */
    public void editEmployee(int selectedID, String attribute, Date newData) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == selectedID) {
                Employee e = employees.get(i);
                switch (attribute) {
                    case "dateHired":
                        e.setDateHired(newData);
                        break;
                }
                break;
            }
        }
    }
    
    public void deleteEmployee(int selectedID) { // Removes Employee from employees
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == selectedID) {
                employees.remove(i);
                break;
            }
        }
    }

    public void addTask(int taskId, int employeeId, String name, boolean completed, Date dateAssigned, Date dateCompleted, double progress) {
        Task t = new Task(taskId, employeeId, name, completed, dateAssigned, dateCompleted, progress);
        tasks.add(t);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == employeeId) {
                employees.get(i).addTask(t);
                break;
            }
        }
    }

    public void editTask(int taskId, int employeeId, boolean completed, Date dateAssigned, Date dateCompleted, double progress) {
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getId() == taskId){
                tasks.get(i).setCompleted(completed);
                tasks.get(i).setDateAssigned(dateAssigned);
                tasks.get(i).setDateCompleted(dateCompleted);
                tasks.get(i).setProgress(progress);
                break;
            }
        }
        for (int i = 0; i < employees.size(); i++) {    // For every item in employees
            if (employees.get(i).getEmployeeID() == employeeId) {   // If it's the right employee
                for (int j = 0; j < employees.get(i).tasks.size(); j++) {   // For every item in that employee's tasklist
                    if (employees.get(i).tasks.get(j).getId() == taskId) { // If it's the right task
                        tasks.get(i).setCompleted(completed);
                        tasks.get(i).setDateAssigned(dateAssigned);
                        tasks.get(i).setDateCompleted(dateCompleted);
                        tasks.get(i).setProgress(progress);
                        break;
                    }
                }
            }
            
        }
    }

    public void deleteTask(int selectedID) {
        int empId = -1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == selectedID) {
                empId = tasks.get(i).getEmployeeId();
                tasks.remove(i);
                break;
            }
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == empId) {
                for (int j = 0; j < employees.get(i).tasks.size(); j++) {
                    if (employees.get(i).tasks.get(j).getId() == selectedID) {
                        tasks.remove(i);
                        break;
                    }
                }
            }
        }
    }

    public void addSkill(int skillId, int employeeId, String name, int level, String origin, String use) {
        Skill s = new Skill(skillId, employeeId, name, level, origin, use);
        skills.add(s);
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getEmployeeID() == employeeId) {
                employees.get(i).addSkill(s);
                break;
            }
        }
    }
    public void editSkill(int skillId, int employeeId, String name, int level, String origin, String use) {
        for (int i = 0; i < skills.size(); i++){
            if (skills.get(i).getSkillId() == skillId){
                skills.get(i).setName(name);
                skills.get(i).setLevel(level);
                skills.get(i).setOrigin(origin);
                skills.get(i).setUse(use);
                break;
            }
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == employeeId) {
                for (int j = 0; j < employees.get(i).skills.size(); j++) {
                    if (employees.get(i).skills.get(j).getSkillId() == skillId) {
                        skills.get(i).setName(name);
                        skills.get(i).setLevel(level);
                        skills.get(i).setOrigin(origin);
                        skills.get(i).setUse(use);
                        break;
                    }
                }
            }
            
        }
    }

    public void deleteSkill(int selectedID) {
        int empId = -1;
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getSkillId() == selectedID) {
                empId = skills.get(i).getEmployeeId();
                skills.remove(i);
                break;
            }
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == empId) {
                for (int j = 0; j < employees.get(i).skills.size(); j++) {
                    if (employees.get(i).skills.get(j).getSkillId() == selectedID) {
                        skills.remove(i);
                        break;
                    }
                }
            }
        }
    }

    // Added int employeeID parameter to addJob method so job can be added to employee objects -- John
    public void addJob(int ID, int employeeID, String name, String title, String supervisor, java.sql.Date dateHired, ArrayList<Employee> jobs) {
        Job j = new Job(employeeID, name, title, supervisor, dateHired);
        Job.add(j);
        for (int i = 0; i < employees.size(); i++) {    // Adds job to individual employee's list of jobs -- John
            if (employees.get(i).getEmployeeID() == ID) {
                employees.get(i).jobs.add(j);
                break;
            }
        }
    }

    // Edit an existing Job in the jobs list at the specified index
    public void editJob(int index, Job newJob) {
        if (index >= 0 && index < jobs.size()) {
            jobs.set(index, newJob);
        } else {
            System.out.println("Invalid index");
        }
        // This should also update the corresponding employee's job list -- John
    }

    public void deleteJob(int ID) {
        jobs.removeIf(job -> job.getID() == ID);
        // This should also remove the corresponding employee's job from their job list -- John
        for (int i = 0; i < employees.size(); i++) {    // Go through all employees
            for (int j = 0; j < employees.get(i).jobs.size(); j++) {    // Go through employee's jobs
                if (employees.get(i).jobs.get(j).getID() == ID) {   // If the job ID is right
                    employees.get(i).jobs.remove(j);    // Remove it
                    break;
                }    
            
            }
        }
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