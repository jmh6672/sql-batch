package org.example.dao;

import org.example.entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;
    private Random random = new Random();
    private static String[] MAILS = {"naver.com","gmail.com","daum.net","nate.com"};


    public String createName(){
        final StringBuilder sb = new StringBuilder();

        for(int i=0; i<10; i++) {
            int rndVal = (int)(Math.random() * 62);
            if(rndVal < 10) {
                sb.append(rndVal);
            } else if(rndVal > 35) {
                sb.append((char)(rndVal + 61));
            } else {
                sb.append((char)(rndVal + 55));
            }
        }
        return sb.toString();
    }
    public String createMail() {
        final StringBuilder sb = new StringBuilder(createName());

        sb.append("@");
        sb.append(MAILS[random.nextInt(MAILS.length)]);

        return sb.toString();
    }

    @ParameterizedTest
    @MethodSource("memberInsertParams")
    public void memberInsert(int insertSize, int batchSize) {
        List<Member> data = new ArrayList<>();

        for(int i=0; i<insertSize; i++){
            Date date = new Date(new java.util.Date().getTime());

            data.add(Member.builder()
                    .email(createMail())
                    .name(createName())
                    .joinDate(date)
                    .lastLoginTime(date)
                    .build());
        }

        memberDAO.insert(data,batchSize);
    }


    @Test
    public void oldMemberInsert() throws ParseException {
        List<Member> list = new ArrayList<>();

        for(int i=0; i<600000; i++){
            Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01").getTime());

            list.add(Member.builder()
                    .email(createMail())
                    .name(createName())
                    .joinDate(date)
                    .lastLoginTime(date)
                    .build());
        }

        memberDAO.insert(list,1000);
    }

    @Test
    public void nullMemberInsert() throws ParseException {
        List<Member> list = new ArrayList<>();

        for(int i=0; i<400000; i++){
            Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01").getTime());

            list.add(Member.builder()
                    .email(createMail())
                    .name(createName())
                    .joinDate(date)
                    .build());
        }

        memberDAO.insert(list,1000);
    }

    private static Stream<Arguments> memberInsertParams() { // argument source method
        return Stream.of(
                Arguments.of(1000000, 100),
                Arguments.of(1000000, 200),
                Arguments.of(1000000, 300),
                Arguments.of(1000000, 400),
                Arguments.of(1000000, 500),
                Arguments.of(1000000, 600),
                Arguments.of(1000000, 700)
        );
    }
}
