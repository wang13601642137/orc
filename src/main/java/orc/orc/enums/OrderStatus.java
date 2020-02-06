package orc.orc.enums;

import org.springframework.core.annotation.Order;

/**
 * Created by wenjin.wang on 2020/2/6.
 */
public enum OrderStatus {
    INIT(0, "初始化"), PAIED(1, "待付款"), SHIPPING(2, "待发货"), SIGN(3, "待签收"), FINISH(4, "已完成");

    private int code;
    private String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static OrderStatus forCode(Integer code) {
        OrderStatus[] arr = OrderStatus.values();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getCode() == code) {
                return arr[i];
            }
        }
        return null;
    }
}
