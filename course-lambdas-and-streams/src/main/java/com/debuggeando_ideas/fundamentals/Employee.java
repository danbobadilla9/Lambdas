package com.debuggeando_ideas.fundamentals;

public class Employee {

    private String dni;
    private String name;
    private Double salary;

    public Employee(String name, Double salary, String dni) {
        this.name = name;
        this.salary = salary;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
