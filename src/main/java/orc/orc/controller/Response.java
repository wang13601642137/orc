package orc.orc.controller;

import lombok.Data;

/**
 * Created by wenjin.wang on 2019/12/27.
 */
@Data
public class Response {
    private String statusCode = "200";
    private String message = "操作成功";
    private String navTabId = "";
    private String rel = "";
    private String callbackType = "";
    private String forwardUrl = "";
}
