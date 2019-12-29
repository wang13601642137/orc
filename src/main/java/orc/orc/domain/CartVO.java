package orc.orc.domain;

/**
 * Created by wenjin.wang on 2019/12/29.
 */
public class CartVO extends Cart {
    private String productName;
    private String userName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
