import java.util.*;

public class main {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        //test8();
        //test9();


    }

    /**
     * 模拟发牌
     * 原理：
     *  使用 Map 存牌
     *  使用 LinkedList 记录牌的下标，也就是 Map 的 Key 值。
     *  使用 Collections.shuffle() 方法对 LinkedList 进行随机打乱排序
     *  使用重新排序后的 LinkedList 值（Key） 取 Map 中的牌（Value）
     */
    private static void test9() {
        Map<Integer, String> poker = new HashMap<>(); // 存牌
        LinkedList<Integer> indexList = new LinkedList<>(); // 存下标
        String[] str1 = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] str2 = {"♥", "♠", "♣", "♦"};

        int index = 0; // 牌下标

        for (String s : str1) {
            for (String s1 : str2) {
                String s3 = s1 + s; // 组装成牌
                indexList.add(index);
                poker.put(index++, s3);
            }
        }

        // 把大王、小王放进去
        indexList.add(index);
        poker.put(index++, "小王");

        indexList.add(index);
        poker.put(index, "大王");
        //System.out.println(poker);

        // 创建三个人和底牌
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> diPai = new TreeSet<>();

        // 洗牌
        Collections.shuffle(indexList); // 将 List 中的内容随机打乱顺序

        // 发牌
        for (int i = 0; i < 17; i++) { // 3*17=51+3=54
            player1.add(indexList.removeLast()); // 给一张，删一张
            player2.add(indexList.removeLast());
            player3.add(indexList.removeLast());
        }
        diPai.addAll(indexList); // 剩下的三张全给底牌

        showPoker(poker, "player1", player1);
        showPoker(poker, "player2", player2);
        showPoker(poker, "player3", player3);
        showPoker(poker, "底牌", diPai);
    }

    /**
     * 发牌的看牌函数
     * @param map 牌
     * @param name 用户名
     * @param treeSet 下标
     */
    private static void showPoker(Map<Integer, String> map, String name, TreeSet<Integer> treeSet) {
        System.out.print(name + "的牌是:");
        for (Integer key : treeSet) {
            System.out.printf(map.get(key) + " ");
        }
        System.out.println();
    }

    /**
     * HashMap
     * 通过 Map 的实体获取所有值
     */
    private static void test8() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王二");
        map.put(4, "麻子");
        map.put(5, "哈哈");

        // Map 内部接口 Map.Entry<> 实体，包含 key,value
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        // 获取迭代器
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            // 获取每个实体
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Key=" + entry.getKey() + ",Value=" + entry.getValue());
        }
    }

    /**
     * HashMap
     * 通过 set 进行迭代器获取所有值
     */
    private static void test7() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王二");
        map.put(4, "麻子");
        map.put(5, "哈哈");
        System.out.println(map);

        // 获取 map 的所有 key 集合
        Set<Integer> set = map.keySet();  // 使用 keySet 获取所有 key 给 set
        Iterator<Integer> iterator = set.iterator(); // 迭代器
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println("Key=" + key + ",Value=" + value);
        }
    }

    /**
     * HashSet 和 TreeSet
     * 特征：去重 排序
     */
    private static void test6() {
        Set<String> strings = new HashSet<>();  // 去重，排序
        strings.add("b");
        strings.add("a");
        strings.add("a");
        strings.add("f");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("e");
        strings.add("c");
        System.out.println(strings);

        TreeSet<Integer> treeSet = new TreeSet<>(); // 去重，排序
        treeSet.add(22);
        treeSet.add(11);
        treeSet.add(22);
        treeSet.add(22);
        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(9);
        treeSet.add(0);
        System.out.println(treeSet);
    }

    /**
     * LinkedList
     * .add() .addFirst() .addLast .removeList
     */
    private static void test5() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.addFirst("2");
        linkedList.addLast("3");
        System.out.println(linkedList);

        String s = linkedList.removeLast(); // 删除最后一个，返回删除的元素
        System.out.println(linkedList);
    }

    /**
     * List
     * 两种遍历方式：
     * 1. 增强 for 循环
     * 2. 迭代器 Iterator
     */
    private static void test4() {
        // 使用 List 接口 创建集合
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list.get(2));  // 下标由 0 开始
        list.set(2, "U");
        System.out.println(list);

        for (String s : list) {  // for 循环遍历
            System.out.print(s + " ");
        }
        System.out.println();
        Iterator<String> iterator = list.iterator(); // Iterator
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

    /**
     * 泛型 与自定义类的泛型
     */
    private static void test3() {
        Collection<String> collection = new ArrayList<>();  // 泛型
        ((ArrayList<String>) collection).add(0, "2");
        collection.add("3");
        System.out.println(collection);

        Student<String> stu = new Student<>("小王", 5, "泛型 String 填充");
        stu.show();
    }

    /**
     * 集合 迭代器取值
     * <p>
     * 迭代器 Iterator ，配合 while() 循环使用
     * 判断下一个是否存在 .hasNext()
     * 取值，下标自动移动 .next()
     */
    private static void test2() {
        Collection collection = new ArrayList();

        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);

        // 集合方法获取迭代器
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) // 判断是否有元素
            System.out.print(iterator.next() + " "); // 取值
    }

    /**
     * 集合
     * 增 add ,删 remove
     */
    private static void test1() {
        // 定义一个集合
        Collection collection = new ArrayList(), c1 = new ArrayList(), c2 = new ArrayList();
        if (collection.isEmpty())
            System.out.println("集合当前为空");

        collection.add("张三");
        collection.add(12);
        collection.add("sss");
        System.out.println(collection);

        collection.remove(12);
        System.out.println(collection);

        System.out.println("集合大小：" + collection.size());

        c1.add(collection);
        System.out.println(c1);
        c2.addAll(collection);
        System.out.println(c2);
    }
}
