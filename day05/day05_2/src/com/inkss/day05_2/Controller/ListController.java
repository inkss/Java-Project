package com.inkss.day05_2.Controller;

import com.inkss.day05_2.Po.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
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

        return "success";
    }
}
