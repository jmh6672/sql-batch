package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.entity.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberDAO {
    private final JdbcTemplate jdbcTemplate;

    public void insert(List<Member> list, int batchSize){
        String sql = "insert  into member " +
                "(email,name,join_date,last_login_time) " +
                "values (?,?,?,?)";

        jdbcTemplate.batchUpdate(sql,list,batchSize,
                (ps, argument) -> {
                    ps.setString(1, argument.getEmail());
                    ps.setString(2, argument.getName());
                    ps.setDate(3, argument.getJoinDate());
                    ps.setDate(4, argument.getLastLoginTime());
                }
        );
    }
}
