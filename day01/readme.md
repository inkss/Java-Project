# DAY 01

>很**水**的一天。基础的 Java 概念复习。
>
>涉及：变量、条件、循环等。

## 1 学习内容：

* Java概述，Java发展史，JDK与JVM
* Java变量，数据类型，运算符，运算符
* Java选择结构：if选择结构，switch选择结构
* 循环结构概述，循环实现原理，while与do-while循环

## 2 目标：

* 掌握Java开发环境基本配置；
* 掌握运算符、表达式、流程控制语句、数组等的使用；
* 熟练使用Idea开发工具；
* 掌握Java基本面向对象知识；
* 掌握常用类String、ArrayList等的使用。

## 3 附录

```java
// 指定范围的随机数
int num = (int) (random() * (max - min) + min);

// 取出一个数的千分位、百分位、十分位
int n = 9876;
int a = n / 1000;
int b = n / 100 - a * 10;
int c = n / 10 - a * 100 - b * 10;
int d = n - a * 1000 - b * 100 - c * 10;
```