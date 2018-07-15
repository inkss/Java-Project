import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class test2 {

    private static HashMap<Integer, People> hashMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int input;
        while (true) {
            System.out.println("=================================");
            System.out.println("|-----1.增加");
            System.out.println("|-----2.删除");
            System.out.println("|-----3.修改 ");
            System.out.println("|-----4.根据ID查询");
            System.out.println("|-----5.查所有");
            System.out.println("|-----0.退出");
            System.out.println("=================================");
            System.out.println("请选择业务：");
            input = sc.nextInt();
            if (input == 0) {
                System.out.println("Bye~");
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
                case 5:
                    fun5();
                    break;
                default:
                    System.out.println("输入值错误");
                    break;
            }
        }
    }

    private static void fun1() {
        System.out.println("---增加员工---");
        System.out.print("请输入员工编号：");
        int id = sc.nextInt();
        if (checkAgain(id)) {
            System.out.println("已经存在该员工");
        } else {
            People people = intPut(id);
            hashMap.put(people.getID(), people);
            System.out.println("添加成功");
        }
    }

    private static void fun2() {
        System.out.println("---删除员工---");
        System.out.print("请输入员工编号：");
        int id = sc.nextInt();
        if (checkAgain(id)) {
            hashMap.remove(id);
            System.out.println("删除成功");
        } else {
            System.out.println("查无此人");
        }
    }

    private static void fun3() {
        System.out.println("---修改员工---");
        System.out.print("请输入员工编号：");
        int id = sc.nextInt();
        if (checkAgain(id)) {
            People temp = intPut(id);
            hashMap.put(id, temp);
            System.out.println("修改成功");
        } else {
            System.out.println("查无此人");
        }
    }

    private static void fun4() {
        System.out.println("---查询员工---");
        System.out.print("请输入员工编号：");
        int id = sc.nextInt();
        if (checkAgain(id)) {
            People people = hashMap.get(id);
            System.out.println(people);
        } else {
            System.out.println("查无此人");
        }
    }

    private static void fun5() {
        System.out.println("---查询所有---");
        Set<Integer> set = hashMap.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(hashMap.get(key));
        }
    }

    /**
     * 输入函数
     * @param id 对象的 ID 值
     * @return 赋值后的 People 对象
     */
    private static People intPut(int id) {
        System.out.print("请输入员工姓名：");
        String name = sc.next();
        System.out.print("请输入员工职务(员工、经理、董事)：");
        String job = sc.next();
        System.out.print("请输入员工请假天数：");
        double holiday = (double) sc.nextInt();
        System.out.print("请输入员工基本工资：");
        double salary = (double) sc.nextInt();
        People people = null;
        switch (job) {
            case "员工":
                people = new CommonEmployee(id, name, job, holiday, salary);
                ((CommonEmployee) people).updateMoney();
                break;
            case "经理":
                people = new ManagerEmployee(id, name, job, holiday, salary);
                ((ManagerEmployee) people).updateMoney();
                break;
            case "董事":
                people = new DirectorEmployee(id, name, job, holiday, salary);
                ((DirectorEmployee) people).updateMoney();
                break;
            default:
                System.out.println("职位输入错误");
                break;
        }
        return people;
    }

    /**
     * 根据 num 对 HasMap 查重
     * @param num key 值
     * @return 是否存在
     */
    private static boolean checkAgain(int num) {
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            int key = (int) iterator.next();
            if (key == num)
                return true;
        }
        return false;
    }
}

class People {
    private int ID;
    private String name;
    private String job;
    private double holiday;
    private double salary;

    public People() {
    }

    public People(int ID, String name, String job, double holiday, double salary) {
        this.ID = ID;
        this.name = name;
        this.job = job;
        this.holiday = holiday;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getHoliday() {
        return holiday;
    }

    public void setHoliday(double holiday) {
        this.holiday = holiday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "编号：" + ID +
                " 姓名：" + name +
                " 职务：" + job +
                " 请假天数：" + holiday +
                " 工资：" + salary;
    }
}

/**
 * 经理
 */
class ManagerEmployee extends People {

    public ManagerEmployee(int ID, String name, String job, double holiday, double salary) {
        super(ID, name, job, holiday, salary);
    }

    public void updateMoney() {
        double yingFa = super.getSalary();
        yingFa += yingFa * 0.7 + 500;
        super.setSalary(yingFa);
    }
}

/**
 * 董事长
 */
class DirectorEmployee extends People {

    public DirectorEmployee(int ID, String name, String job, double holiday, double salary) {
        super(ID, name, job, holiday, salary);
    }

    public void updateMoney() {
        double yingFa = super.getSalary();
        yingFa = yingFa * 2 + 200;
        super.setSalary(yingFa);
    }
}

/**
 * 普通员工
 */
class CommonEmployee extends People {

    public CommonEmployee(int ID, String name, String job, double holiday, double salary) {
        super(ID, name, job, holiday, salary);
    }

    public void updateMoney() {
        double yingFa = super.getSalary();
        yingFa += yingFa * 0.6 + 200;
        super.setSalary(yingFa);
    }
}