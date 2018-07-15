import java.util.ArrayList;
import java.util.List;

public class ListTest01 {

    public static void main(String[] args) {

        //list中添加，获取，删除元素
        List<String> person = new ArrayList<>();
        person.add("jackie");   //索引为0  //.add(e)
        person.add("peter");    //索引为1
        person.add("annie");    //索引为2
        person.add("martin");   //索引为3
        person.add("marry");    //索引为4

        person.remove(3);   //.remove(index)
        person.remove("marry");     //.remove(Object o)

        String per = "";
        per = person.get(1);
        System.out.println(per);    ////.get(index)

        for (int i = 0; i < person.size(); i++) {
            System.out.println(person.get(i));  //.get(index)
        }

        //list总是否包含某个元素
        List<String> fruits = new ArrayList<>();
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("桃子");
        //for循环遍历list
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
        String appleString = "苹果";
        //true or false
        System.out.println("fruits中是否包含苹果：" + fruits.contains(appleString));

        if (fruits.contains(appleString)) {
            System.out.println("我喜欢吃苹果");
        } else {
            System.out.println("我不开心");
        }

        //list中根据索引将元素数值改变(替换)
        String a = "白龙马", b = "沙和尚", c = "八戒", d = "唐僧", e = "悟空";
        List<String> people = new ArrayList<>();
        people.add(a);
        people.add(b);
        people.add(c);
        people.set(0, d);   //.set(index, element)      //将d唐僧放到list中索引为0的位置，替换a白龙马
        people.add(1, e);   //.add(index, element);     //将e悟空放到list中索引为1的位置,原来位置的b沙和尚后移一位

        //增强for循环遍历list
        for (String str : people) {
            System.out.println(str);
        }

        //list中查看（判断）元素的索引
        List<String> names = new ArrayList<>();
        names.add("刘备");    //索引为0
        names.add("关羽");    //索引为1
        names.add("张飞");    //索引为2
        names.add("刘备");    //索引为3
        names.add("张飞");    //索引为4
        System.out.println(names.indexOf("刘备"));
        System.out.println(names.lastIndexOf("刘备"));
        System.out.println(names.indexOf("张飞"));
        System.out.println(names.lastIndexOf("张飞"));

        //根据元素索引位置进行的判断
        if (names.indexOf("刘备") == 0) {
            System.out.println("刘备在这里");
        } else if (names.lastIndexOf("刘备") == 3) {
            System.out.println("刘备在那里");
        } else {
            System.out.println("刘备到底在哪里？");
        }

        //利用list中索引位置重新生成一个新的list（截取集合）
        List<String> phone = new ArrayList<>();
        phone.add("三星");    //索引为0
        phone.add("苹果");    //索引为1
        phone.add("锤子");    //索引为2
        phone.add("华为");    //索引为3
        phone.add("小米");    //索引为4
        //原list进行遍历
        for (String pho : phone) {
            System.out.println(pho);
        }
        //生成新list
        //利用索引1-4的对象重新生成一个list，但是不包含索引为4的元素，4-1=3
        phone = phone.subList(1, 4);  //.subList(fromIndex, toIndex)
        for (int i = 0; i < phone.size(); i++) { // phone.size() 该方法得到list中的元素数的和
            System.out.println("新的list包含的元素是" + phone.get(i));
        }

        //对比两个list中的所有元素
        //两个相等对象的equals方法一定为true, 但两个hashcode相等的对象不一定是相等的对象
        if (person.equals(fruits)) {
            System.out.println("两个list中的所有元素相同");
        } else {
            System.out.println("两个list中的所有元素不一样");
        }

        if (person.hashCode() == fruits.hashCode()) {
            System.out.println("我们相同");
        } else {
            System.out.println("我们不一样");
        }


        //判断list是否为空
        //空则返回true，非空则返回false
        if (person.isEmpty()) {
            System.out.println("空的");
        } else {
            System.out.println("不是空的");
        }

        //返回Iterator集合对象
        System.out.println("返回Iterator集合对象:" + person.iterator());

        //将集合转换为字符串
        String liString = "";
        liString = person.toString();
        System.out.println("将集合转换为字符串:" + liString);

        //将集合转换为数组，默认类型
        System.out.println("将集合转换为数组:" + person.toArray());

        ////将集合转换为指定类型（友好的处理）
        //1.默认类型
        List<Object> listsStrings = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            listsStrings.add(person.get(i));
        }
        //2.指定类型
        List<StringBuffer> lst = new ArrayList<>();
        for (String string : person) {
            lst.add(StringBuffer(string));
        }
    }

    private static StringBuffer StringBuffer(String string) {
        return null;
    }

}