package com.example.popmov.entity;


import com.example.popmov.dto.MemberRole;
import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Member {

        @Id
        private String mid;

        private String mpw;

        private String email;

        private boolean del;

        @Builder.Default
        @ElementCollection(fetch = FetchType.LAZY)
        private Set<MemberRole> roleSet = new HashSet<>();

        public void addRole(MemberRole memberRole){
            roleSet.add(memberRole);
        }

}
