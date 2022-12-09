package com.example.popmov.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MemberDTO extends User {

    private String mid;
    private String mpw;
    private String email;
    private boolean del;


    public MemberDTO(String username, String password,String email,boolean del, Collection<? extends GrantedAuthority> authorityCollection){
        super(username,password,authorityCollection);
        this.mid = username;
        this.mpw = password;
        this.email = email;
        this.del = del;

    }
}
