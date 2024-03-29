// TempArrays.java

import java.util.ArrayList;
import java.util.Scanner;

public class Temparrays {
    // Arrays for storing HR data
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Department> departments = new ArrayList<>();
    // You may add more arrays for other entities like salaries, benefits, etc.

    // Method to add employee
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // Method to edit employee
    public void editEmployee(int index, Employee emp) {
        employees.set(index, emp);
    }

    // Method to delete employee
    public void deleteEmployee(int index) {
        employees.remove(index);
    }

    // Method to add department
    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    // Method to edit department
    public void editDepartment(int index, Department dept) {
        departments.set(index, dept);
    }

    // Method to delete department
    public void deleteDepartment(int index) {
        departments.remove(index);
    }

    // Method to display employees
    public void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // Method to display departments
    public void displayDepartments() {
        for (Department dept : departments) {
            System.out.println(dept);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Temparrays hrApp = new Temparrays();
        // You can create demo data here or use a separate method to populate the arrays
        // Then test your methods here
    }
}

// Sample Employee class
class Employee {
    private String name;
    private int age;
    // Add more fields as needed

    // Constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    // You can add more methods as needed

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// Sample Department class
class Department {
    private String name;
    private String location;
    // Add more fields as needed

    // Constructor
    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and setters
    // You can add more methods as needed

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
