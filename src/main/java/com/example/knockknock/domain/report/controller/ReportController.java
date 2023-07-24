package com.example.knockknock.domain.report.controller;

import com.example.knockknock.domain.report.dto.response.GetReportResponseDto;
import com.example.knockknock.domain.report.dto.request.ReportRequestDto;
import com.example.knockknock.domain.report.service.ReportService;
import com.example.knockknock.global.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/report")
@RequiredArgsConstructor
@RestController
public class ReportController {
    private final ReportService reportService;

    @PostMapping("/post/{postId}")
    public ResponseEntity reportPost(
            @PathVariable Long postId,
            @RequestBody ReportRequestDto request
    ) {
        reportService.reportPost(postId, request);
        return ResponseMessage.SuccessResponse("신고가 접수되었습니다.", "");
    }

    @PostMapping("/comment/{commentId}")
    public ResponseEntity reportComment(
            @PathVariable Long commentId,
            @RequestBody ReportRequestDto request
    ) {
        reportService.reportComment(commentId, request);
        return ResponseMessage.SuccessResponse("신고가 접수되었습니다.", "");
    }

    @GetMapping("/post/{postId}/reports")
    public ResponseEntity<List<GetReportResponseDto>> getPostReports(
            @PathVariable Long postId
    ) {
        return new ResponseEntity<>(reportService.getPostReports(postId), HttpStatus.OK);
    }

    @GetMapping("/comment/{commentId}/reports")
    public ResponseEntity<List<GetReportResponseDto>> getCommentReports(
            @PathVariable Long commentId
    ) {
        return new ResponseEntity<>(reportService.getCommentReports(commentId), HttpStatus.OK);
    }
}