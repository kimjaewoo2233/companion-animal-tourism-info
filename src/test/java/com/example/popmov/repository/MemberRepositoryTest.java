package com.example.popmov.repository;

import com.example.popmov.dto.MemberRole;
import com.example.popmov.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Test
    void test(){
        IntStream.rangeClosed(1,10).forEach(value -> {
                Member member = Member.builder()
                        .mid("user"+value)
                        .mpw(passwordEncoder.encode("1111"))
                        .email("email"+value+"@naver.com")
                        .build();

                member.addRole(MemberRole.USER);
                if(value > 8){
                    member.addRole(MemberRole.ADMIN);
                }
                memberRepository.save(member);
        });
    }
}