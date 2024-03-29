public class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("--- Person Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

/*public class Main {
    public static void main(String[] args) {
       
        Person person1 = new Person();
        person.setName("John Doe");
        person.setAge(25);

        person1.displayDetails();
        */