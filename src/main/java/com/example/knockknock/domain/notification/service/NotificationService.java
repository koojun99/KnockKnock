package com.example.knockknock.domain.notification.service;

import com.example.knockknock.domain.friend.entity.Friend;
import com.example.knockknock.domain.friend.service.GetFriendService;
import com.example.knockknock.domain.notification.dto.requestDto.NotificationRequestDto;
import com.example.knockknock.domain.notification.dto.responseDto.NotificationResponseDto;
import com.example.knockknock.domain.notification.entity.Notification;
import com.example.knockknock.domain.notification.repository.NotificationRepository;
import com.example.knockknock.global.exception.GlobalErrorCode;
import com.example.knockknock.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final GetFriendService getFriendService;
    private final NotificationRepository notificationRepository;

    // 연락 일정 불러오기
    @Transactional(readOnly = true)
    public NotificationResponseDto getSchedule(Long friendId) {
        // isLogin
        // convert 함수 만들어서 간편하게 변경할 수 있도록 코드 수정
        Friend friend = getFriendService.getFriend(friendId);
        Notification notification = notificationRepository.findAllByFriend(friend);
        return new NotificationResponseDto(notification);
    }

    // 연락 일정 불러오기
    @Transactional(readOnly = true)
    public Notification getNotificationSchedule(Long friendId) {
        // isLogin
        Friend friend = getFriendService.getFriend(friendId);
        return notificationRepository.findAllByFriend(friend);
    }

    // 연락 일정 생성
    @Transactional
    public void createSchedule(Long friendId, NotificationRequestDto notificationRequestDto) {
        // isLogin
        Friend friend = getFriendService.getFriend(friendId);
        Notification notification = new Notification(friend, notificationRequestDto);
        notificationRepository.save(notification);
    }

    // 연락 일정 수정
    @Transactional
    public void updateSchedule(Long notificationId, NotificationRequestDto notificationRequestDto) {
        // isLogin
        Notification notification = notificationRepository.findById(notificationId).orElseThrow(
                () -> new GlobalException(GlobalErrorCode.NOTIFICATION_NOT_FOUND)
        );
        notification.update(notificationRequestDto);
    }

    // 연락 일정 삭제
    @Transactional
    public void deleteSchedule(Long notificationId) {
        // isLogin
        notificationRepository.deleteById(notificationId);
    }

    // todo: 알림 보내기 스케쥴링
}
