package orc.orc.service;

import orc.orc.domain.ProductOrder;
import orc.orc.repository.ProductOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/29.
 */
@Service
public class OrderService {
    @Autowired
    private ProductOrderMapper orderMapper;

    public List<ProductOrder> search(ProductOrder record) {
        return orderMapper.find(record);
    }
}
