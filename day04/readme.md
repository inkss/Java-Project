# SpringMVC 注解开发

## 1: 处理器映射器和处理器适配器

### a: 注解的处理器映射器

* 在 springmvc.xml 配置 `RequestMappingHandlerMapping` 作为处理器映射器。

* 在 handler 中使用 `@Controller` 注解 ,并在 springmvc.xml 中开启注解扫描。

* 在 handler 的某个方法前使用 `@RequestMapping` 注解指定请求的 url 来匹配此方法。

### b: 注解的处理器适配器

* 在 springmvc.xml 配置 `RequestMappingHandlerAdapter` 作为处理器适配器。

* 不需要 `handler` 实现任何接口 ,是一个单纯的 pojo 类。

* `RequestMappingHandlerMapping` 处理器映射器需要与 `RequestMappingHandlerAdapter` 处理器适配器配对使用。

### c: 总结

* 可以 contoller 类前面加上类似于 namespace 的注解,方便管理 url 请求。

* `@RequestMapping` 指定请求对应的 url,可以省略后缀(.do,.action.html)。

* `ModelAndView` 返回页面的时候,可以只指定逻辑视图的名称,将前缀和后缀配置在视图解析器中。

* 真实的返回地址 `prefix+viewName+suffix` 。

* 在正式的注解开发是,可以用 mvc 标签的注解驱动来替代映射器和处理的配置。

## 2: Controller 方法返回方式

`Controller` 的方法有多种开发方式,开发人员可以根据不同的业务需求来选择：

* a: 返回字符串

  应用场景:直接返回视图名称,例如进入某个功能主页 ,详见 `UserController.gotoUser()` 。

  应用场景: 登陆成功以后,我们需要重定下到主页,失败以后转发到登陆页面。

* b: 返回 `ModelAndView`

  应用场景:查询用户列表

* c: 返回 `void`

## 3: Controller 方法获取请求参数

获取请求的参数：

* a: 默认支持的类型

  `HttpServletRequest` `HttpServletResponse`  `HttpSession`

* b: 可以通过简单的数据类型来接收参数值

  `int` `string` `double` `float`

  利用 `@RequestParam(value="username" ,required=true)` `String username` 来绑定请求参数名的名称。

* c: 可以通过简单的 pojo 类来接收参数

  应用场景:保存新增用户页面的数据

* d: 通过包装类来接收参数

* e: 通过集合类型获取

  应用场景:批量删除 `Long[] ids`

  应用场景:批量修改

 

 

 

 

 