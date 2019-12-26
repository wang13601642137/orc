package orc.orc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenjin.wang on 2019/12/3.
 */
@Controller
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping(value = "/test", produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String test() {
        return "ok";
    }

    @RequestMapping("/testftl")
    public String sayHello1(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "test";
    }
}
