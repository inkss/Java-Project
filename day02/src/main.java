
import com.inkss.day02.Student;
import com.inkss.day02.Teacher;

import java.util.Scanner;

import static java.lang.Math.random;

public class main {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();

    }


    private static void test3() {
        //Student stu = new Student("二狗子", 233, "男", "二里屯");
        //System.out.println(stu);
        //Teacher teacher = new Teacher("二狗子老师", 233, "男", 5, 6);
        //System.out.println(teacher);

        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];
        for (int i = 1; i < 4; i++) {
            System.out.println("输入第" + i + "位学生信息（姓名，年龄，性别，地址）：");
            students[i - 1] = new Student(sc.next(), sc.nextInt(), sc.next(), sc.next());
        }
        System.out.println("打印：");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void test2() {
        int max = 35, flag = 0;
        int[] a = new int[20];
        System.out.print("随机数为：");
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (random() * 55 + 35);
            System.out.print(a[i] + " ");
            if (max < a[i]) {
                max = a[i];
                flag = i;
            }
        }
        System.out.println("， 最大数：" + max + " 下标:" + flag);
    }

    private static void test1() {
        int sum = 0;
        int[] b = new int[20];
        System.out.print("随机数为：");
        for (int i = 0; i < b.length; i++) {
            sum += b[i] = (int) (random() * 40 + 30);
            System.out.print(b[i] + " ");
        }
        System.out.println("， 总和为：" + sum);
    }
}
