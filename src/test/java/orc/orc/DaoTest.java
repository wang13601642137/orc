package orc.orc;

import orc.orc.domain.Admin;
import orc.orc.repository.AdminRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by wenjin.wang on 2019/12/25.
 */
public class DaoTest extends BaseTest{
    @Autowired
    private AdminRepository adminRepository;

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
}
