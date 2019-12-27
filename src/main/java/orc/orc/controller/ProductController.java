package orc.orc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenjin.wang on 2019/12/27.
 */
@Controller
@RequestMapping(value = "product")
public class ProductController {

    @RequestMapping("/category/list")
    public String categoryList(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "category/list";
    }

    @RequestMapping("/category/toAdd")
    public String toAddCategory(ModelMap map) {
        return "category/add";
    }

    @ResponseBody
    @RequestMapping("/category/save")
    public Response saveCategory(String name, ModelMap map) {
        Response response = new Response();
        response.setForwardUrl("product/category/list");
        return response;
    }

    @RequestMapping("/category/toUpdate")
    public String toUpdateCategory(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "category/add";
    }

    @RequestMapping("/category/delete")
    public String deleteCategory(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "category/list";
    }


    @RequestMapping("/list")
    public String sayHello1(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "product/list";
    }

}
