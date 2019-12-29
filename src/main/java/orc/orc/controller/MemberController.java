package orc.orc.controller;


import orc.orc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by wenjin.wang on 2019/12/29.
 */
@Controller
@RequestMapping(value = "member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(String userName, String password) {


        return "ok";
    }
}
