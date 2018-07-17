package com.inkss.day05_2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
