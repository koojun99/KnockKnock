package com.example.knockknock.domain.comment.controller;

import com.example.knockknock.domain.comment.dto.request.CommentRegisterRequestDto;
import com.example.knockknock.domain.comment.dto.request.CommentUpdateRequestDto;
import com.example.knockknock.domain.comment.service.CommentService;
import com.example.knockknock.domain.member.security.UserDetailsImpl;
import com.example.knockknock.global.message.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/post/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity registerComment(
            @RequestBody @Valid CommentRegisterRequestDto request,
            @PathVariable Long postId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        commentService.registerComment(postId, request, userDetails);
        return ResponseMessage.SuccessResponse("댓글 작성 완료", "");
    }


    @PutMapping("/edit/{commentId}")
    public ResponseEntity updateComment(
            @RequestBody @Valid CommentUpdateRequestDto request,
            @PathVariable Long commentId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        commentService.updateComment(commentId, request, userDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity deleteComment(
            @PathVariable Long commentId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        commentService.deleteComment(commentId, userDetails);
        return ResponseEntity.ok().build();
    }


}
