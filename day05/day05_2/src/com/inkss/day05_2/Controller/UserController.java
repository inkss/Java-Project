package com.inkss.day05_2.Controller;

import com.inkss.day05_2.Po.User;
import com.inkss.day05_2.Po.UserPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过注解来注明当前类为控制器类
 */
@Controller
public class UserController {

    /**
     * 访问前端页面
     *
     * @return list.jsp 页面的名字
     */
    @RequestMapping("user.do")
    public String toList() {

        return "list";
    }

    /**
     * 负责回显 add.jsp 页面
     *
     * @return jsp 页面
     */
    @RequestMapping("toAdd.do")
    public String toAdd() {
        return "add";
    }

    /**
     * 用户提交 id 时访问的方法
     *
     * @param id form 表单中的 name = "id"
     * @return 回显到成功界面
     */
    @RequestMapping("addUserID.do")
    public String addUserId(String id) {
        System.out.println("用户提交的id：" + id);
        return "success";
    }

    @RequestMapping("addUser.do")
    public String addUser(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("addUserList.do")
    public String addUserList(UserPojo userPojo) {
        System.out.println(userPojo.getUserList());
        return "success";
    }

}
