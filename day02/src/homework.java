import java.util.Scanner;

import static java.lang.Math.random;

/**
 * 1.编程在一个已知的字符串中找最长单词，假定字符串中只含字母和空格，空格用来分隔不同单词。
 * 比如："ni hao world ",最长单词是world
 * <p>
 * 2.定义一个方法，实现传入a，b，n得到n个[a,b]范围的随机数
 * <p>
 * 3.控制台输入一个整数代表数组容量，并提示用户逐个输入元素存入数组中
 * 请输入数组的容量：n
 * 请输入n个数组元素值
 * 您输入的数组为：
 * <p>
 * 4.使用Scanner从键盘读取一行输入aaaabbbcccddd,去掉其中重复字符, 打印出不同的那些字符
 * 使用List集合保存无重复的结果
 * <p>
 * 5.统计字符串”abcdabcdabcdaadd”中每个字符出现的次数  MAP练习
 * 控制台打印结果：
 * a出现5次
 * b出现3次
 * c出现3次
 * d出现5次
 * <p>
 * 6.模拟斗地主发牌：无序与有序两种情况
 */
public class homework {


    public int[] homework2(int a, int b, int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = (int) (random() * (a > b ? a : b - a > b ? b : a)) + a > b ? b : a;
        }
        return num;
    }

    public void homework1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(), max = "";
        String[] temp = str.split(" ");
        for (String aTemp : temp) {
            if (max.length() < aTemp.length())
                max = aTemp;
        }
        System.out.println("最长字符串为：" + max);
    }
}
