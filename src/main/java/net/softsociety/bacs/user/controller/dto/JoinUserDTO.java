package net.softsociety.bacs.user.controller.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
public record JoinUserDTO(
        @NotBlank
        @Pattern(regexp = "[a-zA-Z0-9]{3,30}", // ValidationConstants.USER_ID
                message = "아이디는 영문과 숫자로 3글자 이상 30글자 이하입니다." // ValidationMessageConstants.USER_ID
        )
        String userId,

        @NotBlank
        String userPw,

        @NotBlank
        String email,

        @NotBlank
        String phone
) {
}
