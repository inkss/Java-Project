> MyBatis 初学习。

（1）db 数据库配置

```properties
db.driver=com.mysql.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf8
db.username=root
db.password=123456
```

（2）SqlMapConfig 配置

```xml
<configuration>

    <!--加载 db.properties-->
    <properties resource="db.properties"></properties>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${db.driver}"/>
                <property name="url" value="${db.url}"/>
                <property name="username" value="${db.username}"/>
                <property name="password" value="${db.password}"/>
            </dataSource>
        </environment>
    </environments>

    <!--加载 sql 操作配置语句-->
    <mappers>
        <mapper resource="UserMapper.xml"></mapper>
    </mappers>

</configuration>
```

（3）UserMapper 配置

```xml
<!--通过命令空间找到指定 sql 操作文件-->
<mapper namespace="UserMapper">
    
    <!--查询 user 表中的所有数据-->
    <select id="selectAllUser" resultType="com.inkss.day05_3.pojo.User">
        select * from user;
    </select>
</mapper>
```

（4）使用

```java
// 在类中访问库
// 先加载 mybatis 配置文件
String path = "SqlMapConfig.xml";

InputStream inputStream = Resources.getResourceAsStream(path);

// 生成 sql 会话工厂类对象
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

// 获取 SqlSession 对象：也就是一次 sql 会话对象
SqlSession sqlSession = sqlSessionFactory.openSession();

// 使用 sqlSession 进行 sql 查询
// selectList 是查询集合数据
List<User> userList = sqlSession.selectList("UserMapper.selectAllUser");

for (User user : userList)
    System.out.println(user);
```

