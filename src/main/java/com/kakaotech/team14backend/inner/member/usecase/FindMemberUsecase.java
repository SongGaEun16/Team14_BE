package com.kakaotech.team14backend.inner.member.usecase;

import com.kakaotech.team14backend.inner.member.model.Member;
import com.kakaotech.team14backend.inner.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindMemberUsecase {

  private final MemberRepository memberRepository;

  public Member execute(Long memberId) {
    return memberRepository.findById(memberId).orElseThrow(
        () -> new RuntimeException("Member not found")
    );
  }

}
