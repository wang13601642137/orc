package orc.orc.domain;

/**
 * Created by wenjin.wang on 2019/12/23.
 */
public class Admin extends BaseDomain {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
