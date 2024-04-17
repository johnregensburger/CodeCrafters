import java.util.ArrayList;
import java.util.Date;

public class TempArrays {
    public static ArrayList<Employee> employees; //John
    public static ArrayList<Task> tasks; // Duru
    public static ArrayList<Skill> skills; // Duru
    public static ArrayList<Job> jobs; // Jaden
    public static ArrayList<Evaluation> evaluations; // Jaden

    public TempArrays() {}

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