package com.example.knockknock.domain.member.dto;

import com.example.knockknock.domain.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailResponseDto {
    private Long memberId;
    private String memberName;
    private String memberGender;
    private String nickName;
    private String phoneNumber;
    private String email;
    private String birthDay;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    public static MemberDetailResponseDto of(Member member) {
        String formattedBirthDay = formatDate(member.getBirthDay());
        return MemberDetailResponseDto.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .memberGender(String.valueOf(member.getMemberGender()))
                .nickName(member.getNickName())
                .phoneNumber(member.getPhoneNumber())
                .email(member.getEmail())
                .birthDay(formattedBirthDay)
                .age(member.getAge())
                .createdAt(member.getCreatedAt())
                .modifiedAt(member.getModifiedAt())
                .build();

    }
    private static String formatDate(String birthDay) {
        String year = birthDay.substring(0, 2);
        String month = birthDay.substring(2, 4);
        String day = birthDay.substring(4, 6);
        return year + "년" + month + "월 " + day + "일";
    }
}