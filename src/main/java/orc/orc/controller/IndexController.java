package orc.orc.controller;

import orc.orc.controller.vo.IndexVO;
import orc.orc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "index";
    }


    @RequestMapping("/pc/index")
    @ResponseBody
    public AjaxResponse pcindex() {
        AjaxResponse response = new AjaxResponse();
        IndexVO vo = new IndexVO();

        response.setData(vo);
        return response;
    }
}
