package orc.orc.service;

import orc.orc.domain.Category;
import orc.orc.domain.Member;
import orc.orc.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/29.
 */
@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;


    public void register(String userName, String password) {
        Member member = new Member();
        member.setUserName(userName);
        member.setPassword(password);
        member.setStatus(true);
        member.setCreatedAt(new Date());
        member.setCreatedBy(0);
        member.setUpdatedAt(new Date());
        member.setUpdatedBy(0);
        memberMapper.insert(member);
    }

    public Member login(String userName, String password) {
        Member record = new Member();
        record.setUserName(userName);
        record.setPassword(password);
        List<Member> memberList = memberMapper.find(record);
        if(memberList != null && memberList.size() > 0) {
            return memberList.get(0);
        }
        return null;
    }

    public Member findByUsername(String userName) {
        Member record = new Member();
        record.setUserName(userName);
        List<Member> memberList = memberMapper.find(record);
        if(memberList != null && memberList.size() > 0) {
            return memberList.get(0);
        }
        return null;
    }

    public List<Member> find(Member condition) {
        return memberMapper.find(condition);
    }

}
