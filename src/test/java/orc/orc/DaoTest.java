package orc.orc;

import com.alibaba.fastjson.JSON;
import orc.orc.domain.Admin;
import orc.orc.repository.AdminRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenjin.wang on 2019/12/25.
 */
public class DaoTest extends BaseTest{
    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testInsertAdmint() {
        Admin ad = new Admin();
        ad.setPassword("admin2");
        ad.setUserName("admin2");
        ad.setCreatedAt(new Date());
        ad.setCreatedBy(0);
        ad.setUpdatedAt(new Date());
        ad.setUpdatedBy(0);
        adminRepository.insert(ad);
    }

    @Test
    public void testFind() {
        Map<String, Object> map = new HashMap();
        map.put("userName", "admin");
        map.put("password", "admin");

        List<Admin> adminList = adminRepository.find(map);
        System.out.println(JSON.toJSONString(adminList));
    }

    @Test
    public void testFindById() {
        Admin admin = adminRepository.findById(1);
        System.out.println(JSON.toJSONString(admin));
    }

    @Test
    public void testUpdateAdmin() {
        Admin admin = adminRepository.findById(1);
        admin.setUserName("www");
        adminRepository.update(admin);
        admin = adminRepository.findById(1);
        System.out.println(JSON.toJSONString(admin));
    }

    @Test
    public void deleteById() {
        adminRepository.deleteById(1);
        adminRepository.deleteById(2);
    }
}
