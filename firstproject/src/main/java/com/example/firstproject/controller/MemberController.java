package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/members/signUp")
    public String registerMember() {
        return "members/signUp";
    }
    @PostMapping("/members/join")
    public String CreateMember(MemberForm memberForm) {
        Member member = memberForm.toEntity();
        log.info("member엔티티 : " + member.toString());
        Member saved = memberRepository.save(member);
        log.info("DB변환 : " + saved);
        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id) {
        return "members/show";
    }
}
