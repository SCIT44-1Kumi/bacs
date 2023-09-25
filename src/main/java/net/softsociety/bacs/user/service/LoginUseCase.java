package net.softsociety.bacs.user.service;

import net.softsociety.bacs.user.dto.LoginRequestDto;
import net.softsociety.bacs.user.service.data.TokenPair;

import javax.servlet.http.HttpServletResponse;

public interface LoginUseCase {
    // Entity <-> DTO 변환을 컨트롤러 vs 서비스
    TokenPair login(String userId, String userPw); // 도메인, 범용적 타입 I/O
    String login(LoginRequestDto dto, HttpServletResponse response);


}
