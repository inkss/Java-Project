import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class homework {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //fun1();
        //fun2();
        //fun3();
        //fun4();
        //fun5();
        //fun6();
        //fun7();
        //fun8();
        fun9();

    }

    private static void fun9() {
        System.out.println("100-999以内的水仙花数：");
        for (int i = 100, a, b, c; i < 1000; i++) {
            a = i / 100;
            b = (i - a * 100) / 10;
            c = i % 10;
            if (pow(a, 3) + pow(b, 3) + pow(c, 3) == i)
                System.out.println(i);
        }
    }

    private static void fun8() {
        int x, y, temp;
        System.out.print("输入两个数：");
        x = sc.nextInt();
        y = sc.nextInt();
        // 普通方法
        temp = x < y ? x : y;
        for (int i = temp; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                System.out.println("最大公约数：" + i);
                break;
            }
        }
        temp = x > y ? x : y;
        for (int i = temp; ; i++) {
            if (i % x == 0 && i % y == 0) {
                System.out.println("最小公倍数数：" + i);
                break;
            }
        }

        System.out.println("最大公约数：" + fun8_1(x, y));
        System.out.printf("最小公倍数数：%d", x * y / fun8_1(x, y));
    }

    private static int fun8_1(int a, int b) {// 辗转相除法
        int temp = a % b;
        if (temp == 0)
            return b;
        a = b;
        b = temp;
        return fun8_1(a, b);
    }

    private static void fun7() {
        for (int i = 1, n = 0; i <= 5; i++) {
            System.out.println("欢迎光临第" + i + "家专卖店");
            while (true) {
                System.out.print("要离开吗（y/n）？ ");
                if (sc.next().equals("y")) {
                    System.out.println("离店结账\n");
                    if (i == 5)
                        System.out.println("总共买了" + n + "件衣服");
                    break;
                }
                n++;
                System.out.println("买了一件衣服");
            }
        }
    }

    private static void fun6() {
        int sum = 0, n = 0, temp;
        for (int i = 1; i < 4; i++, sum = 0) {
            System.out.println("请输入第" + i + "个班的成绩：");
            for (int j = 1; j < 5; j++) {
                System.out.printf("第%d个学员的成绩：", j);
                temp = sc.nextInt();
                sum += temp;
                if (temp > 85) n++;
            }
            System.out.println("第" + i + "个班级参赛学员的平均分是:" + sum / 4.0 + "\n");
        }
        System.out.println("三个班级中共有 " + n + " 名同学成绩高于85分");
    }

    private static void fun5() {
        int i = 1;
        System.out.println("用 while 循环打印出1~100之间7的倍数:");
        while (i++ < 101) {
            if (i % 7 == 0)
                System.out.print(i + " ");
        }
        System.out.println();

        i = 1;
        System.out.println("用 while 循环打印出1~100之间个位为7的数:");
        while (i++ < 101) {
            if (i % 10 == 7)
                System.out.print(i + " ");
        }
        System.out.println();

        i = 1;
        System.out.println("用 while 循环打印出1~100之间十位为7的数:");
        while (i++ < 101) {
            if (i > 69 && i < 80)
                System.out.print(i + " ");
        }
        System.out.println();

        i = 1;
        System.out.println("用 while 循环打印出1~100之间既不是7的倍数并且也不包含7的数:");
        while (i++ < 101) {
            if (i % 7 != 0 && i % 10 != 7)
                if (!(i > 69 && i < 80))
                    System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void fun4() {
        System.out.println("九九乘法表：");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %2d ", j, i, i * j);
            }
            System.out.println();
        }
    }

    private static void fun3() {
        System.out.println("打印图案1：");
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(j + 1 + " ");
            System.out.println();
        }

        System.out.println("打印图案2：");
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < i; j++)
                System.out.print(j + 1 + " ");
            System.out.println();
        }

        System.out.println("打印图案3：");
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(3 - j + " ");
            System.out.println();
        }

        System.out.println("打印图案4：");
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < i; j++)
                System.out.print(3 - j + " ");
            System.out.println();
        }

        System.out.println("打印图案5：");
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(j + 1 + " ");
            System.out.println();
        }

        System.out.println("打印图案6：");
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++)
                System.out.print(j + 1 + " ");
            System.out.println();
        }
    }

    private static void fun2() {
        //获取 0-9,(9-0),转为 0-9,即： [0-9]+0
        System.out.println("0-9 随机数：" + (int) (random() * 9));

        //获取 10-20,(20-10),转为 0-10,即： [0-10]+10
        System.out.println("10-20 随机数：" + (int) (random() * 10 + 10));

        //获取 48-73,(73-48),转为 0-25,即： [0-25]+48
        System.out.println("48-73 随机数：" + (int) (random() * 25 + 48));

        int max = 10, min = 30, temp;
        System.out.print("10-30 随机数：");
        for (int i = 0; i < 10; i++) {
            temp = (int) (random() * 20 + 10);
            System.out.print(temp + " ");
            if (temp > max) max = temp;
            if (min > temp) min = temp;
        }
        System.out.println(" 最大值：" + max + " 最小值：" + min);
    }

    private static void fun1() {
        System.out.println("用 for 循环打印出1~100之间7的倍数:");
        for (int i = 1; i < 101; i++) {
            if (i % 7 == 0)
                System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("用 for 循环打印出1~100之间个位为7的数:");
        for (int i = 1; i < 101; i++) {
            if (i % 10 == 7)
                System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("用 for 循环打印出1~100之间十位为7的数:");
        for (int i = 1; i < 101; i++) {
            if (i > 69 && i < 80)
                System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("用 for 循环打印出1~100之间既不是7的倍数并且也不包含7的数:");
        for (int i = 1; i < 101; i++) {
            if (i % 7 != 0 && i % 10 != 7)
                if (!(i > 69 && i < 80))
                    System.out.print(i + " ");
        }
        System.out.println();
    }
}
