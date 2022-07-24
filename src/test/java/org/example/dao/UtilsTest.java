package org.example.dao;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UtilsTest {

    @Test
    public void strTest() {
        LocalDate localDate = LocalDate.now();
        localDate.minusYears(1);

        String sql = String.format("insert into unconnected_member " +
                "select * from member where last_login_time < '%s'",localDate.toString());

        System.out.println(sql);
    }
}
