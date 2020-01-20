package orc.orc.controller.pc.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by wenjin.wang on 2020/1/20.
 */
@Data
public class AddCartVO {
    private Integer memberId;
    private List<AddItem> addItemList;

    @Data
    public static class AddItem {
        private Integer productId;
        private Integer number;
    }
}
