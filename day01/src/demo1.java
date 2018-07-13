import java.util.Scanner;

public class demo1 {

    public void test1(){
        int a = 3, b = 5;
        int c = a;
        a = b;
        b = c;

        System.out.println(a + "\n" + b);

        System.out.println(a > b);

        System.out.println(a > b ? a : b);

        Scanner sc = new Scanner(System.in);
        System.out.println("输入的值为：" + sc.nextLine());

        System.out.println("面积：" + sc.nextInt() * sc.nextInt());
    }
}
