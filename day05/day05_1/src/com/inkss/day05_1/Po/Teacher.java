package com.inkss.day05_1.Po;

public class Teacher {

    private Integer id;
    private String name;
    private Integer age;
    private String home;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age, String home) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.home = home;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", home='" + home + '\'' +
                '}';
    }
}
