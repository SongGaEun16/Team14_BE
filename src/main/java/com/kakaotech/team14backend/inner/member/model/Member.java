package com.kakaotech.team14backend.inner.member.model;

import com.kakaotech.team14backend.inner.post.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  @OneToMany(mappedBy = "member")
  private List<Post> posts = new ArrayList<>();

  @Column(nullable = false, length = 50)
  private String userName; // 유저 이름

  @Column(nullable = false, length = 50)
  private String kakaoId; // 카카오 아이디

  @Column(nullable = false, length = 50)
  private String instaId; // 인스타그램 아이디

  @Column(nullable = false, length = 50)
  @Enumerated(EnumType.STRING)
  private Role role;

  @Column(nullable = false)
  private Long totalLike = 0L; // 보유 좋아요 수

  @Column(nullable = false)
  @CreationTimestamp
  private LocalDateTime createdAt; // 생성일

  @Column(nullable = false)
  @CreationTimestamp
  private LocalDateTime updatedAt; // 수정일

  @Column(nullable = false, length = 20)
  @Enumerated(EnumType.STRING)
  private Status userStatus; // 제재, 탈퇴, 정상 등등

  @Builder
  public Member(String userName, Role role, Status status, String kakaoId, String instaId, Long totalLike) {
    this.userName = userName;
    this.role = role;
    this.kakaoId = kakaoId;
    this.instaId = instaId;
    this.userStatus = status;
    this.totalLike = totalLike;
  }



}
