package orc.orc.service;

import orc.orc.domain.Member;
import orc.orc.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wenjin.wang on 2019/12/29.
 */
@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;


    public void register(String userName, String password) {
        Member member = new Member();
//        member.
    }
}
