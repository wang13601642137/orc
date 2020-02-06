package orc.orc.domain;

import lombok.Data;
import orc.orc.enums.OrderStatus;

/**
 * Created by wenjin.wang on 2020/2/6.
 */
@Data
public class MyOrderVO {
    private String itemImageUrl;
    private String itemName;
    private Integer itemQuantity;
    private String consigneeName;
    private String orderAmount;
    private Integer orderStatus;
    private String orderStatusDesc;
}
