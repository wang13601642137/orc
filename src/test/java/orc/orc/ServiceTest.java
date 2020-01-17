package orc.orc;

import com.alibaba.fastjson.JSON;
import orc.orc.domain.Member;
import orc.orc.service.MemberService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wenjin.wang on 2020/1/17.
 */
public class ServiceTest extends BaseTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void testFindByUsername() {
        Member a = memberService.findByUsername("123");
        System.out.println(JSON.toJSON(a));
    }

}
