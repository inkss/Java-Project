
// 泛型类型 T
public class Student<T> {

    private String name;
    private int age;
    private T t;

    public void show() {
        System.out.println(t);
    }

    public Student() { }

    public Student(String name, int age, T t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
