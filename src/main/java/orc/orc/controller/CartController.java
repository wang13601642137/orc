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

    @RequestMapping("/add")
    @ResponseBody
    public AjaxResponse addCart(Integer productId, Integer quantity, HttpServletRequest request) {
        log.info("添加购物车，请求参数：productId:{}, quantity:{}", productId, quantity);
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(request.getSession().getAttribute("login").equals("0")) {
            ajaxResponse.setCode(AjaxResponse.fail);
            ajaxResponse.setMsg("请您先登陆");
        } else {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            try {
                cartService.addCart(productId, quantity, userId);
            } catch (Exception e) {
                ajaxResponse.setCode(AjaxResponse.fail);
                ajaxResponse.setMsg("添加购物车失败");
            }
        }
        return ajaxResponse;
    }
}
