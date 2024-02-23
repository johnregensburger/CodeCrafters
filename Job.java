public class Job {
    //Title (String): Stores the past or current job title.
    private String title;
    //Experience (int): Stores the number of months in the job.
    private int experience;

    //setTitle(String): Sets the job title
    public void setTitle(String title) {
        this.title = title;
    }
    // setExperience(int): Sets the number of months on the job.
    public void setExperience(int experience) {
        this.experience = experience;
    }

    // getTitle(): Retrieves the job title
    public String getTitle() {
        return title;
    }
    //getExperiencel(): Retrieves the number of months on the job
    public int getExperience() {
        return experience;
    }

    // displayDetails(): Displays the jobs and lengths of time in months on the job
    public void displayDetails() {
        System.out.println("Job Title: " + title);
        System.out.println("Experience (months): " + experience);
    }

    // Example usage
    public static void main(String[] args) {
        Job job = new Job();
        job.setTitle("Software Engineer");
        job.setExperience(24);

        // Display job details
        job.displayDetails();
    }
    /*
    - Attributes:
        - Title (String): Stores the past or current job title.
        - Experience (int): Stores the number of months in the job.
    - Methods:
        - setTitle(String): Sets the job title
        - setExperience(int): Sets the number of months on the job.
        - getTitle(): Retrieves the job title
        - getExperiencel(): Retrieves the number of months on the job
        - displayDetails(): Displays the jobs and lengths of time in months on the job
    */
}