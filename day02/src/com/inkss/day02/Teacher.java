package com.inkss.day02;

public class Teacher extends Person {

    private int workAge;

    private float salary;

    public Teacher() {
    }

    public Teacher(String name, int age, String sex, int workAge, float salary) {
        super(name, age, sex);
        this.workAge = workAge;
        this.salary = salary;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name=" + super.getName() +
                ", age=" + super.getAge() +
                ", sex=" + super.getSex() +
                ", workAge=" + workAge +
                ", salary=" + salary +
                '}';
    }
}
