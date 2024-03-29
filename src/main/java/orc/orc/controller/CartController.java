package orc.orc.controller;

import lombok.extern.slf4j.Slf4j;
import orc.orc.controller.pc.vo.AjaxResponse;
import orc.orc.domain.Cart;
import orc.orc.domain.CartVO;
import orc.orc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/29.
 */

@Slf4j
@Controller
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/list")
    public String cartList(Integer userId, ModelMap map) {
        log.info("搜索购物车添加记录，请求入参：userId:{}", userId);
        Cart cart = new Cart();
        cart.setUserId(userId);

        List<CartVO> cartVOList = cartService.findCart(cart);
        map.put("cartVOList", cartVOList);
        return "cart/list";
    }
}
