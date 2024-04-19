import java.util.Random;

public class Skill {
    private int skillId;
    private int employeeId;
    private String name;
    private int level;
    private String origin;
    private String use;

    public Skill(int skillId, int employeeId, String name, int level, String origin, String use){
        this.skillId = skillId;
        this.employeeId = employeeId;
        this.name = name;
        this.level = level;
        this.origin = origin;
        this.use = use;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setName( String name ){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setLevel( int level ){
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }
    public void  setOrigin( String origin ) {
        this.origin = origin;
    }
    public String getOrigin() {
        return this.origin;
    }
    public  void setUse( String use ) {
        this.use = use;
    }
    public String getUse() {
        return this.use;
    }
    
}