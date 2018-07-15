import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {

    private static List<Stu> stuList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int input;

        while (true) {
            System.out.println("=================================");
            System.out.println("1.查看学生信息");
            System.out.println("2.添加学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.删除学生信息");
            System.out.println("5.退出学生信息管理系统");
            System.out.println("请输入对应功能的序号");
            System.out.println("=================================");
            input = sc.nextInt();
            if (input == 5) {
                System.out.println("感谢使用管理系统 欢迎下次再来哦");
                break;
            }
            switch (input) {
                case 1:
                    fun1();
                    break;
                case 2:
                    fun2();
                    break;
                case 3:
                    fun3();
                    break;
                case 4:
                    fun4();
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }

    private static void fun1() {

        if (stuList.size() == 0) {
            System.out.println("系统中没有学生的信息,请选择添加功能");
        } else {
            System.out.println("学号  姓名  年龄  家乡");
            for (Stu s : stuList)
                System.out.println(s);
        }
        System.out.println("\n展示完毕");
    }

    private static void fun2() {
        System.out.print("请输入学生学号：");
        String num = sc.next();
        //System.out.println(stuList);
        if (stuList.size() == 0) {
            input(num);
        }
        for (Stu s : stuList) {
            if (s.getNum().equals(num))
                System.out.println("数据库中已经存在该学生");
            else {
                input(num);
                break;
            }
        }
    }

    private static void fun3() {
        System.out.print("请输入学生学号：");
        String num = sc.next();
        boolean flag = true;
        for (Stu s : stuList) {
            if (s.getNum().equals(num)) {
                flag = false;
                System.out.print("请输入学生姓名：");
                s.setName(sc.next());
                System.out.print("请输入学生年龄：");
                s.setAge(sc.next());
                System.out.print("请输入学生家乡：");
                s.setHome(sc.next());
                System.out.println("修改完成");
                break;
            }
        }
        if (flag)
            System.out.println("查无此生");
    }

    private static void fun4() {
        System.out.print("请输入学生学号：");
        String num = sc.next();
        boolean flag = true;
        for (Stu s : stuList) {
            if (s.getNum().equals(num)) {
                stuList.remove(s);
                flag = false;
                System.out.println("删除完毕");
                break;
            }
        }
        if (flag)
            System.out.println("查无此生");
    }

    private static void input(String num) {
        System.out.print("请输入学生姓名：");
        String name = sc.next();
        System.out.print("请输入学生年龄：");
        String age = sc.next();
        System.out.print("请输入学生家乡：");
        String home = sc.next();
        stuList.add(new Stu(num, name, age, home));
    }
}


class Stu {
    private String num;
    private String name;
    private String age;
    private String home;

    public Stu() { }

    public Stu(String num, String name, String age, String home) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.home = home;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
        return "Stu{" +
                "  " + num +
                "  " + name +
                "  " + age +
                "  " + home +
                '}';
    }
}