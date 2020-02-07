package orc.orc.controller;

import orc.orc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wenjin.wang on 2019/12/27.
 */

@Controller
@RequestMapping(value = "/")
public class IndexController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    public String sayHello1(ModelMap map) {
        return "index";
    }
}
