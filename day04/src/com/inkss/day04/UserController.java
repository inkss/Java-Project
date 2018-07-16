package com.inkss.day04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过注解来注明当前类为控制器类
 */
@Controller
public class UserController  {

    /**
     * 访问前端 list.jsp 页面
     * @return list.jsp 页面的名字
     */
    @RequestMapping("user.do")
    public String toList(){

        return "list";
    }

}
