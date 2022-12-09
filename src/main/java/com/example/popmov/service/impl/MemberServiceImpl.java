package com.example.popmov.service.impl;


import com.example.popmov.dto.MemberJoinDTO;
import com.example.popmov.dto.MemberRole;
import com.example.popmov.entity.Member;
import com.example.popmov.repository.MemberRepository;
import com.example.popmov.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public void join(MemberJoinDTO memberJoinDTO) throws MemberService.MidExistException {

        String mid = memberJoinDTO.getMid();

        boolean exist = memberRepository.existsById(mid);

        if(exist){
            throw new MemberService.MidExistException();
        }


        Member member = Member.builder()
                .mid(memberJoinDTO.getMid())
                .mpw(passwordEncoder.encode(memberJoinDTO.getMpw()))
                .email(memberJoinDTO.getEmail())
                .build();
        member.addRole(MemberRole.USER);


        memberRepository.save(member);

    }
}
