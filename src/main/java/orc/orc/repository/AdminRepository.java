package orc.orc.repository;

import orc.orc.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wenjin.wang on 2019/12/25.
 */
@Repository("adminRepository")
public interface AdminRepository {
    void insert(Admin entity);

    void deleteById(Integer id);

    void update(Admin entity);

    List<Admin> find(Map map);

    Admin findById(Integer id);
}
