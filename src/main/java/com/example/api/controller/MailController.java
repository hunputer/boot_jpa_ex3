package com.example.api.controller;

import com.example.api.controller.dto.EmailMessage;
import com.example.api.controller.dto.EmailPostDto;
import com.example.api.controller.dto.EmailResponseDto;
import com.example.api.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;

    @PostMapping("/check/email")
    public ResponseEntity sendJoinMail(EmailPostDto emailPostDto) {
        EmailMessage emailMessage = EmailMessage.builder()
                .to(emailPostDto.getEmail())
                .subject("안녕하세요 테스트 문자 입니다")
                .build();

        emailService.sendMail(emailMessage, "email");

        EmailResponseDto emailResponseDto = new EmailResponseDto();
        emailResponseDto.setCode("200");

        return ResponseEntity.ok(emailResponseDto);
    }
}
