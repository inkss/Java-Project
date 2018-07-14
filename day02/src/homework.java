import java.util.*;

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

    public static void main(String[] args) {

        /*System.out.println("习题1：");
        homework1();*/

        /*System.out.println("习题2：");
        int[] a = homework2(20, 80, 5);
        for (int temp : a) {
            System.out.printf(temp +" ");
        }*/

        /*System.out.println("习题3：");
        homework3();*/

        /*System.out.println("习题4：");
        homework4();*/

        /*System.out.println("习题5：");
        homework5();*/

        System.out.println("习题6：");
        homework6();

    }

    public static void homework6() {

        TreeMap<Integer, String> pokers = new TreeMap<>();
        //向集合中存储元素
        String[] colors = {"♥", "♠", "♣", "♦"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //创建一个ArrayList存储每一张牌对应的索引
        ArrayList<Integer> indexs = new ArrayList<>();
        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                pokers.put(index, color + number);
                indexs.add(index);
                index++;
            }
        }
        //将大王小王存进去
        pokers.put(index, "大王");
        indexs.add(index);
        index++;
        pokers.put(index, "小王");
        indexs.add(index);
        //洗牌
        Collections.shuffle(indexs);
        //发牌
        TreeSet<Integer> dagou = new TreeSet<>();
        TreeSet<Integer> ergou = new TreeSet<>();
        TreeSet<Integer> sangou = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();
        //发牌
        for (int i = 0; i < indexs.size(); i++) {
            if (i >= indexs.size() - 3) {
                dipai.add(indexs.get(i));
            } else if (i % 3 == 0) {
                dagou.add(indexs.get(i));
            } else if (i % 3 == 1) {
                ergou.add(indexs.get(i));
            } else if (i % 3 == 2) {
                sangou.add(indexs.get(i));
            }
        }
        //看牌
        lookPoker("大狗", dagou, pokers);
        lookPoker("二狗", ergou, pokers);
        lookPoker("三狗", sangou, pokers);
        lookPoker("底牌", dipai, pokers);
    }

    public static void lookPoker(String name, TreeSet<Integer> indexs,
                                 TreeMap<Integer, String> pokers) {
        System.out.print(name + "的牌是：");
        for (Integer index : indexs) {
            System.out.print(pokers.get(index) + "  ");
        }
        System.out.println();
    }

    public static void homework5() {
        String str = "abcdabcdabcdaadd";
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        // 存进 MAP
        for (char c : arr) {
            if (map.get(c) == null) {
                map.put(c, 1); // 没取到就存入
            } else {  // 取到了就代表已经存在
                Integer i = map.get(c);
                i++;
                map.put(c, i);
            }
        }

        // 取值打印
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + "出现了" + entry.getValue() + "次");

    }

    public static void homework4() {
        Scanner sc = new Scanner(System.in);
        List<Character> list = new ArrayList<>();
        List<Character> list1 = new ArrayList<>();

        System.out.print("请输入：");
        char[] arr = sc.nextLine().toCharArray(); // String 转 char 数组

        // char 数组给 list
        for (char temp : arr)
            list.add(temp);

        // 去重
        for (char c : list)
            if (Collections.frequency(list1, c) < 1) // 获取所指定元素集合等于指定对象中的数量
                list1.add(c); // 如果没有就加进去

        // 打印
        for (Character aList1 : list1)
            System.out.print(aList1);
    }

    public static void homework3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组容量：");
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("请输入元素值：");
            str[i] = sc.next();
        }
        System.out.println("数组内容为：");
        for (String s : str)
            System.out.print(s + " ");

    }

    public static int[] homework2(int a, int b, int n) {
        int[] num = new int[n];
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        for (int i = 0; i < n; i++)
            num[i] = (int) (random() * (max - min)) + min;
        return num;
    }

    public static void homework1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一串英文（例： I am man）：");
        String max = "";
        String[] temp = sc.nextLine().split(" ");
        for (String aTemp : temp)
            if (max.length() < aTemp.length())
                max = aTemp;
        System.out.println("最长字符串为：" + max);
    }
}
