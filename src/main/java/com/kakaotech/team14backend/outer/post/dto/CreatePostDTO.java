package com.kakaotech.team14backend.outer.post.dto;

import com.kakaotech.team14backend.inner.image.model.Image;
import com.kakaotech.team14backend.inner.member.model.Member;

public record CreatePostDTO(Image image, UploadPostRequestDTO uploadPostRequestDTO, Member member) {
}
