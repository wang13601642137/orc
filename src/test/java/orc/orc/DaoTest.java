package orc.orc;

import orc.orc.domain.Admin;
import orc.orc.domain.Member;
import orc.orc.domain.Product;
import orc.orc.repository.AdminMapper;
import orc.orc.repository.MemberMapper;
import orc.orc.repository.ProductMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

/**
 * Created by wenjin.wang on 2019/12/25.
 */
public class DaoTest extends BaseTest{
    @Autowired
    private AdminMapper adminRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsertAdmint() {
        Admin ad = new Admin();
        ad.setPassword("admin");
        ad.setUserName("admin");
        ad.setCreatedAt(new Date());
        ad.setCreatedBy(0);
        ad.setUpdatedAt(new Date());
        ad.setUpdatedBy(0);
        adminRepository.insert(ad);
    }


    @Test
    public void testFindProduct() {
        Product product = productMapper.selectByPrimaryKey(1);
        System.out.println(product);
    }

    @Test

    public void testFindMember() {
        Member m = new Member();
        m.setUserName("admin");
        memberMapper.find(m);

    }


}
