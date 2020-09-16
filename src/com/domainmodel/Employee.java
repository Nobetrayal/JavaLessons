package com.domainmodel;

public class Employee {

    private static int id;
    private int employeeId;
    private String name;
    private String position;
    private int salary;
    private String department;

    // Блок инициализации.
    static{
        id = 1000;
    }
    {
        department = "it";
    }

    public int getEmployeeId() {
        return employeeId;
    }

    private Employee(String name, String position, int salary, String department) {
        employeeId = id ++;
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {

    }
    public Employee(String name, String position, int salary) {
        this(name, position, salary, "it");
//        new Employee(name, position, salary, "it");
//        employeeId = id ++;
//        this.name = name;
//        this.position = position;
//        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }
}
