package net.softsociety.bacs.user.service;

import net.softsociety.bacs.domain.dto.TokenInfo;
import net.softsociety.bacs.user.controller.dto.JoinUserDTO;
import net.softsociety.bacs.domain.vo.BacsUser;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    TokenInfo login(String userId, String userPw);

    BacsUser join(JoinUserDTO user);

//    int saleToday(SaleTodayDTO data);
//
//    int salesWeek(SaleTodayDTO data);
}
