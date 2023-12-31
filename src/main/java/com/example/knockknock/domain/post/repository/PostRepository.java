package com.example.knockknock.domain.post.repository;

import com.example.knockknock.domain.board.entity.BoardType;
import com.example.knockknock.domain.member.entity.Member;
import com.example.knockknock.domain.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByBoardType(BoardType boardType, Pageable pageable);

    Page<Post> findByBoardTypeAndMemberAgeBetween(BoardType boardType, int ageGroupStart, int ageGroupEnd, Pageable pageable);

    Page<Post> findByBoardTypeAndTitleContainingIgnoreCase(BoardType boardType, String keyword, Pageable pageable);

    Page<Post> findByBoardTypeAndContentContainingIgnoreCase(BoardType boardType, String keyword, Pageable pageable);

    Page<Post> findByBoardTypeAndTitleContainingIgnoreCaseOrContentContainingIgnoreCase(BoardType boardType, String keyword, String keyword1, Pageable pageable);

    List<Post> findByMember(Member member);

    List<Post> findByBoardTypeAndHashtags_TagNameContainingIgnoreCase(BoardType boardType, String tagName);
}
