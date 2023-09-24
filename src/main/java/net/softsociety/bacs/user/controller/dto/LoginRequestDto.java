package net.softsociety.bacs.user.controller.dto;

// record -> entity(VO) X, DTO (O)

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

// immutable -> thread-safe
// getter: .userId(), .userPw()
// toString, hashCode/equals
// implements Serializable
// all args constructor
// ...

@Builder
public record LoginRequestDto(


        @NotBlank // NotNull, NotEmpty, NotBlank(prevents null, "", " ", ... every white space)
        @Pattern(
                regexp = "[a-zA-Z0-9]{3,30}", // ValidationConstants.USER_ID
                message = "아이디는 영문과 숫자로 3글자 이상 30글자 이하입니다." // ValidationMessageConstants.USER_ID
        )
        String userId,

        @NotBlank // NotNull, NotEmpty, NotBlank(prevents null, "", " ", ... every white space)
        // ...
        String userPw,


        @NotBlank
        String Email,


        @NotBlank
        String Phone
) {

}
