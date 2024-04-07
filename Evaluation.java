public class Evaluation {
    private int evaluationID;
    private String employeeState;
    private char grade;

    public Evaluation(int evaluationID, String employeeState, char grade) {
        this.evaluationID = evaluationID;
        this.employeeState = employeeState;
        this.grade = grade;
    }

    public int getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(int evaluationID) {
        this.evaluationID = evaluationID;
    }

    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
