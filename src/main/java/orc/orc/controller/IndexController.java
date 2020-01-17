package orc.orc.controller;

import orc.orc.controller.vo.IndexVO;
import orc.orc.domain.Category;
import orc.orc.domain.Product;
import orc.orc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
        vo.setLogin(true);
        vo.setNickname("蜡笔小新");
        response.setData(vo);
        Category queryCategoryCondition = new Category();
        queryCategoryCondition.setStatus(true);
        List<Category> categoryList =  productService.findCategory(queryCategoryCondition);
        if(categoryList != null && categoryList.size() > 0) {
            List<IndexVO.CategoryVO> categoryVOList = new ArrayList<>();
            vo.setCategoryList(categoryVOList);
            for(Category each : categoryList) {
                IndexVO.CategoryVO cvo = new IndexVO.CategoryVO();
                cvo.setCid(each.getId());
                cvo.setName(each.getName());
                categoryVOList.add(cvo);
            }
        }
        Product queryProductCondition = new Product();
        queryProductCondition.setStatus(true);
        List<Product> productList = productService.findProduct(queryProductCondition);
        if(productList != null && productList.size() > 0) {
            List<IndexVO.ProductVO> productVOList = new ArrayList<>();
            vo.setProductList(productVOList);
            for(Product each : productList) {
                IndexVO.ProductVO pvo = new IndexVO.ProductVO();
                pvo.setCid(each.getCategoryId());
                pvo.setPid(each.getId());
                pvo.setProductName(each.getName());
                pvo.setImageUrl(each.getImageUrl());
                pvo.setProductPrice(each.getPrice().toString());
                pvo.setStock(each.getQuantity());
                productVOList.add(pvo);
            }
        }
        return response;
    }
}
