package orc.orc.controller.pc;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import orc.orc.controller.pc.vo.AddCartVO;
import orc.orc.controller.pc.vo.AjaxResponse;
import orc.orc.controller.pc.vo.IndexVO;
import orc.orc.domain.Category;
import orc.orc.domain.Product;
import orc.orc.service.CartService;
import orc.orc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenjin.wang on 2020/1/20.
 */
@Slf4j
@Controller
@RequestMapping(value = "pc")
public class PcController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    @RequestMapping("/index")
    @ResponseBody
    public AjaxResponse index() {
        AjaxResponse response = new AjaxResponse();
        IndexVO vo = new IndexVO();
        vo.setLogin(true);
        vo.setUserName("wwj2020");
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


    @RequestMapping("/cart/add")
    @ResponseBody
    public AjaxResponse addCart(@RequestBody(required = false) AddCartVO addCartVO) {
        log.info("添加购物，请求参数:{}", JSON.toJSON(addCartVO));
        AjaxResponse ajaxResponse = new AjaxResponse();
        try {
            for(AddCartVO.AddItem addItem : addCartVO.getAddItemList()) {
                cartService.addCart(addItem.getProductId(), addItem.getNumber(), addCartVO.getMemberId());
            }
        } catch (Exception e) {
            ajaxResponse.setCode(AjaxResponse.fail);
            ajaxResponse.setMsg("添加购物车失败");
        }
        return ajaxResponse;
    }
}
