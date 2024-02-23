public class HardSkill {
    /*
    - Attributes:
        - title (String): Stores the title of the hardSkill (C#, OOP, Java, SQL, TeamLead, TechnicalWriting ect)
        - level (String): Stores the skill level of the hardskill (Beginner, Intermediate, Advanced, Expert)
    - Methods:
        - setTitle(String): Sets the title of the hardskill.
        - setLevel(String): Sets the level of skill
        - getTitle(): Retrieves the title of the hardSkill.
        - getLevel(): Retrieves the level of the hardSkill.
        - displayDetails(): Displays the title and skillLevel of each hardSkill
    */

    // Attributes
    String title;
    String level;

    // Methods
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public void setLevel(String newLevel) {
        level = newLevel;
    }

    public String getTitle() {
        return title;
    }

    public String getLevel() {
        return level;
    }

    public void displayDetails() {
        System.out.println("Skill: " + getTitle());
        System.out.println("Level: " + getLevel());
    }
}