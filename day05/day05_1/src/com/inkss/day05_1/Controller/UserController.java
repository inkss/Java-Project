package com.inkss.day05_1.Controller;

import com.inkss.day05_1.Po.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("addUser.do")
    public String addUser(Teacher teacher) {

        System.out.println(teacher);

        return "success";
    }
}
