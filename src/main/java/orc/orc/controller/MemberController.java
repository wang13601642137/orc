package orc.orc.controller;


import lombok.extern.slf4j.Slf4j;
import orc.orc.controller.pc.vo.AjaxResponse;
import orc.orc.domain.Category;
import orc.orc.domain.Member;
import orc.orc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by wenjin.wang on 2019/12/29.
 */
@Slf4j
@Controller
@RequestMapping(value = "member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/list")
    public String find(ModelMap map) {
        List<Member> memberList = memberService.find(new Member());
        map.put("memberList", memberList);
        return "member/list";
    }

    @RequestMapping("/register")
    @ResponseBody
    public AjaxResponse register(String userName, String password) {
        log.info("会员注册，请求参数：userName：{}, password:{}", userName, password);
        Assert.notNull(userName, "用户名不能为空");
        Assert.notNull(password, "密码不能为空");
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(!validateName(userName)) {
            ajaxResponse.setCode(AjaxResponse.fail);
            ajaxResponse.setMsg("用户名不合法");
        }
        if(!validatePassword(password)) {
            ajaxResponse.setCode(AjaxResponse.fail);
            ajaxResponse.setMsg("密码不合法");
        }

        //检验用户名是否已经注册了
        Member exist = memberService.findByUsername(userName);
        if(exist != null) {
            ajaxResponse.setCode(AjaxResponse.fail);
            ajaxResponse.setMsg("用户名已被注册");
        }
        memberService.register(userName, password);
        return ajaxResponse;
    }


    @RequestMapping("/login")
    @ResponseBody
    public AjaxResponse login(String userName, String password, HttpServletRequest request) {
        log.info("会员登陆，请求参数：userName：{}, password:{}", userName, password);
        Assert.notNull(userName, "用户名不能为空");
        Assert.notNull(password, "密码不能为空");
        AjaxResponse ajaxResponse = new AjaxResponse();
        Member exist = memberService.login(userName, password);
        if(exist == null) {
            //在session中记录登陆失败状态
            request.getSession().setAttribute("login","0");
            ajaxResponse.setCode(AjaxResponse.fail);
            ajaxResponse.setMsg("登陆失败");
        } else {
            //在session中记录登陆成功状态以及用户名
            request.getSession().setAttribute("login","1");
            request.getSession().setAttribute("username",exist.getUserName());
            request.getSession().setAttribute("userId",exist.getId());
            ajaxResponse.setMsg("登陆成功");
        }
        return ajaxResponse;
    }

    public static boolean validateName(String name) {
        String regExp = "^[^0-9][\\w_]{5,9}$";
        if(name.matches(regExp)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 密码验证
     * @param pwd
     * @return
     */
    public static boolean validatePassword(String pwd) {
        String regExp = "^[\\w_]{6,20}$";
        if(pwd.matches(regExp)) {
            return true;
        }
        return false;
    }
}
