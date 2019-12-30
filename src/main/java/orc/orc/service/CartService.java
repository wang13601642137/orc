package orc.orc.service;

import orc.orc.domain.Cart;
import orc.orc.domain.CartVO;
import orc.orc.repository.CartMapper;
import orc.orc.repository.MemberMapper;
import orc.orc.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/29.
 */
@Service
public class CartService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private CartMapper cartMapper;

    public List<CartVO> findCart(Cart record) {
        return cartMapper.find(record);
    }

    public void addCart(Integer productId, Integer quantity, Integer userId) {
        Cart record = new Cart();
        record.setUserId(userId);
        record.setProductId(productId);
        record.setQuantity(quantity);
        record.setCreatedAt(new Date());
        record.setCreatedBy(0);
        record.setUpdateAt(new Date());
        record.setUpdatedBy(0);
        cartMapper.insert(record);
    }
}
