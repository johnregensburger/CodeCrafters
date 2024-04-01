public class Job {
    private final int employeeID;
    private String firstName;
    private String lastName;
    private String title;
    private String supervisor;
    private int dateHired;

    public Job (String last, String first, String position, String boss, int when) {
        employeeID = 0;
        lastName = last;
        firstName = first;
        title = position;
        supervisor = boss;
        dateHired = when;
        
    }
}
