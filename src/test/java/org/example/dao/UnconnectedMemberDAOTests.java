package org.example.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnconnectedMemberDAOTests {

    @Autowired
    private UnconnectedMemberDAO unconnectedMemberDAO;

    @Transactional
    @Test
    public void unconnectedMemberInsert() {
        int result = unconnectedMemberDAO.insert();

        assertThat(result==600000).isTrue();
    }
}
