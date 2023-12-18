package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/members/register")
    public String registerMember() {
        return "members/register";
    }
    @PostMapping("/members/create")
    public String CreateMember(MemberForm memberForm) {
        Member member = memberForm.toEntity();
        System.out.println("member엔티티 : " + member.toString());
        Member saved = memberRepository.save(member);
        System.out.println("DB변환 : " + saved.toString());
        return "";
    }
}
