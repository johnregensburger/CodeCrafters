public class Job {
    private int ID;
    private String name;
    private String title;
    private String supervisor;
    private int dateHired;

    public Job(int ID, String name, String title, String supervisor, int dateHired) {
        this.ID = ID;
        this.name = name;
        this.title = title;
        this.supervisor = supervisor;
        this.dateHired = dateHired;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public int getDateHired() {
        return dateHired;
    }

    public void setDateHired(int dateHired) {
        this.dateHired = dateHired;
    }
}
