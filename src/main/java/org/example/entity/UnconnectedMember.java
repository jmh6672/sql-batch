package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "unconnected_member")
@Getter
@Setter
@Builder
@ToString
@Table(indexes = @Index(columnList = "email",unique = true))
public class UnconnectedMember {

    @Id
    @Column(name = "idx", columnDefinition = "int(10) not null comment '회원 고유키'")
    private Integer idx;

    @Column(name = "email", columnDefinition = "varchar(100) not null comment '이메일'")
    private String email;

    @Column(name = "name", columnDefinition = "varchar(50) not null comment '이름'")
    private String name;

    @Column(name = "join_date", columnDefinition = "datetime not null comment '회원가입시간'")
    private Date joinDate;

    @Column(name = "last_login_time", columnDefinition = "datetime comment '마지막 로그인 시간'")
    private Date lastLoginTime;
}
