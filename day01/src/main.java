import java.util.Scanner;

import static java.lang.Math.random;

public class main {

    public static void main(String[] args) {
        //demo1 d1 = new demo1();
        //d1.test1();
        //test2();
        //test3(new Scanner(System.in).nextInt());
        //test4();
        //test5();
        test6();

    }

    private static void test6() {
        //[0-1] double 类型
        int num = (int) (random() * 10); // 获取0-10
        System.out.println(num);

        //获取 10-20,(20-10),转为 0-10,即： [0-10]+10
        System.out.println((int) (random() * 10 + 10));

        //获取 24-67,(67-24),转为 0-43,即： [0-43]+24
        System.out.println((int) (random() * 43 + 24));

    }

    private static void test5() {
        //循环
        int i = 0;
        while (i++ < 5)
            System.out.println("Hello world * " + i);

        i = 0;
        while (i++ < 5) {
            System.out.print(i + " ");
        }

        i = 0;
        System.out.println();
        while (i++ < 5) {
            System.out.print(6 - i + " ");
        }

        System.out.println();
        for (int k = 1; k < 101; k++) {
            if (k % 7 != 0 && k % 10 != 7) // 去除7的倍数和个位是7
                if (!(k > 69 && k < 80))
                    System.out.print(k + " ");
        }
    }

    private static void test4() {
        // 条件
        Scanner sc = new Scanner(System.in);
        System.out.print("成绩：");
        int score = sc.nextInt();
        if (score > 90)
            System.out.println("优秀");
        else if (score > 59)
            System.out.println("及格");
        else
            System.out.println("凉凉");

        // 条件嵌套
        System.out.print("\n成绩：");
        if (sc.nextInt() < 10) {
            System.out.print("性别：");
            String sex = sc.next();
            System.out.print("晋级：");
            if (sex.equals("男"))
                System.out.println("为男子组");
            else
                System.out.println("为女子组");
        } else
            System.out.println("凉凉");

        // 选择
        int mingci = 1;
        switch (mingci) {
            case 1:
                System.out.println("第1名");
                break;
            case 2:
                System.out.println("第2名");
                break;
            case 3:
                System.out.println("第3名");
                break;
            default:
                System.out.println("凉凉");

        }

        int year = sc.nextInt();
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            System.out.println("闰年");
        else System.out.println("不是闰年");


        int x, y;
        x = sc.nextInt();
        if (x < 1)
            y = x;
        else if (x > 9)
            y = 3 * x - 11;
        else
            y = 2 * x - 2;
        //y = x < 1 ? x : (x > 9 ? 3 * x - 11 : 2 * x - 2);
        System.out.println(y);


        float n1 = sc.nextFloat();
        String op = sc.next();
        float n2 = sc.nextFloat();
        switch (op) {
            case "+":
                System.out.println(n1 + n2);
                break;
            case "-":
                System.out.println(n1 - n2);
                break;
            case "*":
                System.out.println(n1 * n2);
                break;
            case "/":
                if (n2 != 0)
                    System.out.println(n1 / n2);
        }
    }

    public static void test3(int n) {
        int a = n / 20;
        int temp = n - 20 * a;

        int b = temp / 10;
        temp -= b * 10;

        int c = temp / 5;
        temp -= c * 5;

        int d = temp;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    private static void test2() {
        int num = new Scanner(System.in).nextInt();
        int a = num / 1000;
        int b = num / 100 - a * 10;
        int c = num / 10 - a * 100 - b * 10;
        int d = num - a * 1000 - b * 100 - c * 10;

        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println(num / 1000 + " " + num / 100 % 10 + " " + num / 10 % 10 + " " + num % 10);
    }

}
