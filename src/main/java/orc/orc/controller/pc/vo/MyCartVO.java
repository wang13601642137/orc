package orc.orc.controller.pc.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by wenjin.wang on 2020/1/20.
 */
@Data
public class MyCartVO {
    private Integer productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer number;
}
