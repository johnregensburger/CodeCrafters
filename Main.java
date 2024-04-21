public class Main {
   
        Person p = new Person();
        System.out.println("--- Person Details ---");
        p.setName("John Doe");
        p.setAge(25);
        p.displayDetails();

        Job j = new Job();
        System.out.println("--- Jobs ---");
        j.setTitle("Software Engineer");
        j.setExperience(24);
        j.displayDetails();

        HardSkill h = new HardSkill();
        System.out.println("--- Hard Skills ---");
        h.setTitle("Java");
        h.setLevel("Expert");
        h.displayDetails();
    }
}
