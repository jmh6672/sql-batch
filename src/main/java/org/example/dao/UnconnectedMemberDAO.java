package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnconnectedMemberDAO {
    private final JdbcTemplate jdbcTemplate;

    public int insert(){
        String sql = "insert into unconnected_member " +
                "select * from member where last_login_time < TIMESTAMPADD(year, -1, current_date)";
        return jdbcTemplate.update(sql);
    }
}
