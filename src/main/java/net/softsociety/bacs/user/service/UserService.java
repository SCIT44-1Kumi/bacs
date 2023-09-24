package net.softsociety.bacs.user.service;

import net.softsociety.bacs.domain.dto.TokenInfo;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.user.controller.dto.JoinUserDTO;
import net.softsociety.bacs.user.controller.dto.SalesDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserService {

    @Transactional
    TokenInfo login(String userId, String userPw);

    BacsUser join(JoinUserDTO user);

    Optional<Integer> saleToday(SalesDTO dto);
    // int salesWeek(SaleTodayDTO data);
}
