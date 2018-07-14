package com.inkss.day02;

public class Student extends Person {

    private String address;

    public Student() {
    }

    public Student(String name, int age, String sex, String address) {
        super(name, age, sex);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + super.getName() +
                ", age=" + super.getAge() +
                ", sex=" + super.getSex() +
                ", address=" + address +
                '}';
    }
}
