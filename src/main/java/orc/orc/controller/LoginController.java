package orc.orc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wenjin.wang on 2019/12/27.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @RequestMapping("/login")
    public String sayHello1(ModelMap map) {

        return "login";
    }
}
