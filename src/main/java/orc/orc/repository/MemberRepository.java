package orc.orc.repository;

import orc.orc.domain.Admin;
import orc.orc.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wenjin.wang on 2019/12/25.
 */
@Repository("memberRepository")
public interface MemberRepository {
    void insert(Member entity);

    void deleteById(Integer id);

    void update(Member entity);

    List<Member> find(Map map);

    Member findById(Integer id);
}
