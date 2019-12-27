package orc.orc.controller;

import orc.orc.domain.Category;
import orc.orc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/27.
 */
@Controller
@RequestMapping(value = "product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/category/list")
    public String categoryList(ModelMap map) {
        List<Category> categoryList = productService.findCategory(new Category());
        map.put("categoryList", categoryList);
        return "category/list";
    }

    @RequestMapping("/category/toAdd")
    public String toAddCategory(ModelMap map) {
        return "category/add";
    }

    @ResponseBody
    @RequestMapping("/category/save")
    public Response saveCategory(String name, ModelMap map) {
        Category record = new Category();
        record.setName(name);
        record.setStatus(true);
        productService.saveCategory(record);
        Response response = new Response();
        return response;
    }

    @RequestMapping("/category/toUpdate")
    public String toUpdateCategory(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "category/add";
    }

    @ResponseBody
    @RequestMapping("/category/delete")
    public Response deleteCategory(Integer cid, ModelMap map) {
        productService.deleteCategory(cid);
        Response response = new Response();
        return response;
    }


    @RequestMapping("/list")
    public String sayHello1(ModelMap map) {
        map.put("userName", "小明");
        map.put("userAge", 23);
        return "product/list";
    }

}
