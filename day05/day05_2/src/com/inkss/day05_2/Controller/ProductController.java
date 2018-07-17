package com.inkss.day05_2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pd")
public class ProductController  {

    /**
     * 访问前端 list.jsp 页面
     * @return list.jsp 页面的名字
     */
    @RequestMapping("product.do")
    public String toList(){

        return "product";
    }
}
