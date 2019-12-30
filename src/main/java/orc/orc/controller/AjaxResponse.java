package orc.orc.controller;

/**
 * Created by wenjin.wang on 2019/12/30.
 */
public class AjaxResponse {
    public static int success = 0;
    public static int fail = 1;
    private int code = success;
    private String msg = "ok";
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
