> SpringMVC 初学习。

（1）web.xml

```xml
<!--前端控制器，分发器，拦截服务器请求，并分发给 springmvc-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
    </servlet>

    <!--设置拦截规则 拦截.do-->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>

    <!--编码解析器-->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>

    <!--设置拦截规则 根目录下所有请求为 UTF-8-->
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

（2）springmvc.xml

```xml
<!--注解开发配置-->
<context:component-scan base-package="com.inkss.day05_2" ></context:component-scan>

<!--配置注解开发的处理器映射器-->
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"></bean>

    <!--配置注解开发的处理器适配器-->
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"></bean>

<!--视图解析器：优化控制器访问前端页面-->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/jsps/" ></property>
    <property name="suffix" value=".jsp"></property>
</bean>
```

（3）使用 1

```java
/**
 * 通过注解来注明当前类为控制器类
 */
@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("toList")
    public String toList(Model model) {

        model.addAttribute("name","user 控制器");

        return "success";
    }
}
```

（4）使用 2

```java
@Controller
@RequestMapping("list")
public class ListController {

    @RequestMapping("toList")
    public String toList(Model model) {

        List<User> list = new ArrayList<>();

        User user = new User();
        user.setName("张三");
        user.setAge(12);
        user.setSex(1);
        user.setId(1);

        User user2 = new User();
        user2.setName("李四");
        user2.setAge(22);
        user2.setSex(0);
        user2.setId(2);

        list.add(user);
        list.add(user2);

        // 将 model 数据传递到 View 层
        // 参数1：前端 jsp 页面使用的变量
        // 参数2：传递过去的变量
        model.addAttribute("userList",list);

        return "list";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {

        System.out.println("待删除的 ID 为：" + id);

        return "success";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(Integer id) {

        System.out.println("待修改的 ID 为：" + id);

        // redirect 重定向 url 改变
        // forward 转发 url 不变
        return "redirect:/user/toList.do"; // 跨域
    }
}
```

