package com.example.knockknock.domain.member.controller;

import com.example.knockknock.domain.member.dto.request.CheckResetCodeRequestDto;
import com.example.knockknock.domain.member.dto.request.EmailAuthenticationRequestDto;
import com.example.knockknock.domain.member.dto.request.PasswordUpdateRequestDto;
import com.example.knockknock.domain.member.service.PasswordResetService;
import com.example.knockknock.global.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/forgot-password")
@RequiredArgsConstructor
@RestController
public class PasswordResetController {
    private final PasswordResetService passwordResetService;
    @PostMapping("/code")
    public ResponseEntity resetPassword(@RequestBody EmailAuthenticationRequestDto request) {
        passwordResetService.sendResetCode(request);
        return ResponseMessage.SuccessResponse("이메일 전송", "");
    }

    @PostMapping("/authentication")
    public ResponseEntity authentication(@RequestBody CheckResetCodeRequestDto request){
        return ResponseMessage.SuccessResponse("인증이 완료되었습니다.", passwordResetService.isAuthenticated(request));
    }

    @PostMapping("/change-password")
    public ResponseEntity newPassword(@RequestBody PasswordUpdateRequestDto request) {

        passwordResetService.resetPassword(request);
        return ResponseMessage.SuccessResponse("비밀번호가 변경되었습니다.", "");
    }

}
