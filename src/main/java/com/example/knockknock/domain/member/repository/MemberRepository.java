package com.example.knockknock.domain.member.repository;

import com.example.knockknock.domain.member.entity.Member;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findBySocialId(String id);

    Optional<Member> findByNickName(String nickName);

}
