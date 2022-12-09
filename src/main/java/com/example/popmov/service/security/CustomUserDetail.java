package com.example.popmov.service.security;

import com.example.popmov.dto.MemberDTO;
import com.example.popmov.entity.Member;
import com.example.popmov.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetail implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("in username ==> {}",username);

        Optional<Member> result = memberRepository.findById(username);
        if(result.isEmpty()){
            throw new UsernameNotFoundException("username not found");
        }

        Member member = result.get();

        MemberDTO memberDTO = new MemberDTO(member.getMid()
                ,member.getMpw()
                , member.getEmail()
                , member.isDel()
                , member.getRoleSet().stream()
                .map(memberRole ->
                        new SimpleGrantedAuthority("ROLE_"+memberRole.name()))
                .collect(Collectors.toList()));
        log.info("{}",memberDTO);
        return memberDTO;
    }



}
