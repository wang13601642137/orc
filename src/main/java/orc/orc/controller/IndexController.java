package orc.orc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wenjin.wang on 2019/12/27.
 */

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping("/index")
    public String sayHello1(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "index";
    }

}
