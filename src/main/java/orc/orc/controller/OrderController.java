package orc.orc.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import orc.orc.controller.vo.PlaceOrderVO;
import orc.orc.domain.Product;
import orc.orc.domain.ProductOrder;
import orc.orc.service.OrderService;
import orc.orc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/29.
 */
@Slf4j
@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String orderList(String keyword, ModelMap map) {
        log.info("搜索订单，请求入参：keyword:{}", keyword);
        ProductOrder order = new ProductOrder();
        order.setProductName(keyword);
        List<ProductOrder> orderList = orderService.search(order);
        map.put("orderList", orderList);
        return "order/list";
    }


    @RequestMapping("/place")
    @ResponseBody
    public AjaxResponse placeOrder(PlaceOrderVO req, HttpServletRequest request) {
        log.info("用户下单，请求参数：" + JSON.toJSONString(req));
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(request.getSession().getAttribute("login").equals("0")) {
            ajaxResponse.setCode(AjaxResponse.fail);
            ajaxResponse.setMsg("请您先登陆");
        } else {
            try {
                Integer userId = (Integer) request.getSession().getAttribute("userId");
                List<PlaceOrderVO.ProductItem> productItemList = req.getProductItemList();
                for(PlaceOrderVO.ProductItem each : productItemList) {
                    ProductOrder order = new ProductOrder();
                    Product product = productService.getProductById(each.getProductId());
                    order.setProductName(product.getName());
                    order.setAmount(each.getPrice().multiply(BigDecimal.valueOf(each.getQuantity())));
                    order.setProductId(product.getId());
                    order.setStatus(true);
                    order.setCreatedAt(new Date());
                    order.setCreatedBy(0);
                    order.setUpdateAt(new Date());
                    order.setUpdateBy(0);
                    order.setUserId(userId);
                    order.setConsigneeAddress(req.getConsigneeAddress());
                    order.setConsigneeMobile(req.getConsigneeMobile());
                    order.setConsigneeName(req.getConsigneeName());
                    orderService.placeOrder(order);
                }
            } catch (Exception e) {
                ajaxResponse.setCode(AjaxResponse.fail);
                ajaxResponse.setMsg("下单失败");
            }
        }
        return ajaxResponse;
    }
}
