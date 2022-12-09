package com.example.popmov.controller;


import com.example.popmov.dto.MemberJoinDTO;
import com.example.popmov.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MemberController {

        private final MemberService memberService;

        @GetMapping("/login")
        public void loginGET(String error,String logout){

        }

        @GetMapping("/join")
        public void joinGET(){

        }

        @PostMapping("/join")
        public String joinPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes){
                try{
                        memberService.join(memberJoinDTO);
                }catch (MemberService.MidExistException e){
                        redirectAttributes.addFlashAttribute("error","mid");
                        return "redirect:/join";
                }

                return "redirect:/board";
        }
}
