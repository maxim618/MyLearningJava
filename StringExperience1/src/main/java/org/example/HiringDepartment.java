package org.example;

public class HiringDepartment {
    private Development development; //Определяем интерфейс

    //Конструктор принимает объект интерфейса
    public HiringDepartment(Development development){
        this.development = development;
    }

    public void displayInfo(){
        System.out.println("Name: " + development.getName());
        System.out.println("Job: " + development.getJob());
    }
}
