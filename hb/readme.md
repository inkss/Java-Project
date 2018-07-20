> 概述：基于 JavaWeb : Hotelbook 的改制。

### 一、概述

原项目为：JDBC + C3P0 + Servlet 和乱七八糟的前端插件

现在改为：数据部分使用 MyBatis ，前后端传值使用 SpringMVC ，使用 Maven 管理依赖。

### 二、备注

（1） Dao 与 Mapper

最初的项目对数据库使用的是 Dao 的方式，诸如一个接口，一个实现类 `LoginDao`。在这里面提供了增、删、改、查啊什么的， Sql 语句也是写在这部分文件中的。所以改变的重点就是将原 DAO 实现类中的代码换成 `xxxMapper.xml` 的形式，甚至于原 Dao 接口不用大改，直接换成 `xxxMapper` 的名称就可。

但是原 Dao 的实现类中对查询语句进行了一些“加工”，换成 Mapper 后只能在里面放 SQL 语句，所以对数据的处理就放在 `service` 层，而本来 service 层就是 `controller` 和 `dao` 的中间件，所以在业务层接口上几乎不用修改，对其实现类进行小部分的改动就好了（*我算是体验到当初用 MVC 思想写代码，分层的好处了*）。

（2） Controller 与 Servlet

接下来就是前后端通信部分了，也就是需要把 `JavaWeb` 提供的 Servlet 换成 `SpringMVC` 所使用的 Controller ，正所谓注解开发。

然后原项目使用的是 `Ajax` 调用的 Servlet ，现在只需要将原来发给 servlet 的数据发给 `xxxController` ，通过函数回调取返回值。所以依次来说，对 SpringMVC 最直观的感受便是：**原先需要写多个 Servlet 的地方，现在都集中在一个 Controller 里了。**

### 三、附录

Dao 改成 Mapper 很简单，这里不多叙述，下面记录一下 Ajax 调 Controller。（省略了一部分）

* 前端 JS 代码

```jsp
$.ajax({
	timeout: 2000,
	type: "POST",
	url: baseUrl + "/QueryLoginName/login.do",
	data: params,
	success: function (data) {
		if (data === '1')
			alert("成功");
		else alert("失败");
	},
	error : function (){
		alert("请求失败")
	}
});
```
* 后端 Java 代码

```java
@Controller
@RequestMapping("QueryLoginName")
public class LoginController {

    private LoginService service = new LoginServiceImpl();

    @RequestMapping("login.do")
    @ResponseBody   // <---- 必加，否则 404
    public String toList(String loginName, String loginPwd) {

        String data = String.valueOf(service.queryByName(loginName, loginPwd));
        return data;
    }

}
```

