package com.kakaotech.team14backend.inner.post.usecase;

import com.kakaotech.team14backend.common.RedisKey;
import com.kakaotech.team14backend.outer.post.dto.GetPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class SaveTemporaryPostViewCountUsecase {

  private final RedisTemplate<String,Object> redisTemplate;

  /**
   * 게시물에대한 조회수를 Redis에 임시 저장한다.
   *
   * @author : hwangdaesun
   * @param : 게시물 구분자, 유저 구분자
   * @see : Redis의 Set 자료구조를 사용, key는 게시물 구분자, value는 유자 구분자
   */

  @Transactional
  public void execute(GetPostDTO getPostDTO) {
    // 데이터를 Redis Set에 추가하는 코드
    redisTemplate.opsForSet().add(RedisKey.VIEW_COUNT_PREFIX + String.valueOf(getPostDTO.postId()), getPostDTO.memberId());
  }

}
