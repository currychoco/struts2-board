package com.currychoco.board.features.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class User {

    @Setter
    private Long seq;
    private String id;
    private String password;
    private String nickname;
}
