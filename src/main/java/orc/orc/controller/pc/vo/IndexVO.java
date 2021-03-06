package orc.orc.controller.pc.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by wenjin.wang on 2020/1/17.
 */
@Data
public class IndexVO {
    private boolean login;
    private String userName;
    private List<CategoryVO> categoryList;
    private List<ProductVO> productList;


    @Data
    public static class CategoryVO {
        private Integer cid;
        private String name;
    }

    @Data
    public static class ProductVO {
        private Integer pid;
        private Integer cid;
        private String productName;
        private String productPrice;
        private String imageUrl;
        private Integer stock;
    }

}
