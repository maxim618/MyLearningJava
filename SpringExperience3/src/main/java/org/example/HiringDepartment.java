package org.example;

import java.util.ArrayList;
import java.util.List;

public class HiringDepartment {
    private Development development; //Определяем интерфейс
    private int salary;
    private String citizenship;

    public void displayInfo(){
        System.out.println("Name: " + development.getName());
        System.out.println("Job: " + development.getJob());
        System.out.println("Salary: " + this.salary);
        System.out.println("Citizenship: " + citizenship);

    }

    public void setDevelopment(Development development){
        this.development = development;
    }

    public Development getDevelopment(){
        return development;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}
