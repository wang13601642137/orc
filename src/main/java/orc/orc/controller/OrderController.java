package orc.orc.controller;

import lombok.extern.slf4j.Slf4j;
import orc.orc.domain.ProductOrder;
import orc.orc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/list")
    public String orderList(String keyword, ModelMap map) {
        log.info("搜索订单，请求入参：keyword:{}", keyword);
        ProductOrder order = new ProductOrder();
        order.setProductName(keyword);
        List<ProductOrder> orderList = orderService.search(order);
        map.put("orderList", orderList);
        return "order/list";
    }
}
