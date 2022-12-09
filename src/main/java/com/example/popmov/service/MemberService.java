package com.example.popmov.service;

import com.example.popmov.dto.MemberJoinDTO;

public interface MemberService {
    static  class  MidExistException extends Exception{

    }

    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
}
