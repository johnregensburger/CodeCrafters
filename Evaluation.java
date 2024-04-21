public class Evaluation {
    private int evaluationID;       // Unique identifier for the evaluation
    private String employeeState;   // State of the employee during the evaluation (e.g., performance status)
    private char grade;             // Grade assigned to the employee for the evaluation

    // Constructor to initialize an Evaluation object with the provided values
    public Evaluation(int evaluationID, String employeeState, char grade) {
        this.evaluationID = evaluationID;
        this.employeeState = employeeState;
        this.grade = grade;
    }

    // Getter method to retrieve the evaluation ID
    public int getEvaluationID() {
        return evaluationID;
    }

    // Setter method to set the evaluation ID
    public void setEvaluationID(int evaluationID) {
        this.evaluationID = evaluationID;
    }

    // Getter method to retrieve the employee state
    public String getEmployeeState() {
        return employeeState;
    }

    // Setter method to set the employee state
    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    // Getter method to retrieve the grade
    public char getGrade() {
        return grade;
    }

    // Setter method to set the grade
    public void setGrade(char grade) {
        this.grade = grade;
    }
}
