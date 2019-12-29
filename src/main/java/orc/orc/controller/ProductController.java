package orc.orc.controller;

import lombok.extern.slf4j.Slf4j;
import orc.orc.domain.Category;
import orc.orc.domain.Product;
import orc.orc.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/27.
 */
@Slf4j
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

    @RequestMapping("/toAdd")
    public String toAddProduct(ModelMap map) {
        return "product/add";
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
    public String toUpdateCategory(Integer cid, ModelMap map) {
        log.info("cid:" + cid);
        Category category = productService.getCategoryById(cid);
        map.put("category", category);
        return "category/update";
    }

    @RequestMapping("/toUpdate")
    public String toUpdateProduct(Integer pid, ModelMap map) {
        log.info("pid:" + pid);
        Product product = productService.getProductById(pid);
        map.put("product", product);
        return "product/update";
    }

    @ResponseBody
    @RequestMapping("/category/modify")
    public Response saveCategory(@Param("cid") String cid, @Param("name") String name, ModelMap map) {
        Category record = productService.getCategoryById(Integer.parseInt(cid));
        record.setName(name);
        productService.modifyCategory(record);
        Response response = new Response();
        return response;
    }

    @ResponseBody
    @RequestMapping("/category/delete")
    public Response deleteCategory(Integer cid, ModelMap map) {
        productService.deleteCategory(cid);
        Response response = new Response();
        return response;
    }

    @ResponseBody
    @RequestMapping("/save")
    public Response saveProduct(String name, BigDecimal price,Integer quantity,  Integer cid, String imgUrl, String description, ModelMap map) {
        log.info("name:{}, price:{}, cid:{}, imgUrl:{}, description:{}", name, price, cid, imgUrl, description);
        Product record = new Product();
        record.setName(name);
        record.setPrice(price);
        record.setCategoryId(cid);
        record.setImageUrl(imgUrl);
        record.setQuantity(quantity);
        record.setDescription(description);
        record.setStatus(true);
        record.setSale(true);
        record.setCreatedAt(new Date());
        record.setCreatedBy(0);
        record.setUpdatedAt(new Date());
        record.setUpdatedBy(0);
        record.setStatus(true);
        productService.saveProduct(record);
        Response response = new Response();
        return response;
    }


    @RequestMapping("/list")
    public String productList(ModelMap map) {
        List<Product> productList = productService.findProduct(new Product());
        map.put("productList", productList);
        return "product/list";
    }
}
