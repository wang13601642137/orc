package orc.orc.domain;

/**
 * Created by wenjin.wang on 2019/12/23.
 */
public class Category extends BaseDomain {
    private String name;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
