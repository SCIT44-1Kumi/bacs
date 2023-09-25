package net.softsociety.bacs.user.service;

import net.softsociety.bacs.user.dto.TokenInfo;
import net.softsociety.bacs.user.dto.JoinUserDTO;
import net.softsociety.bacs.user.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    TokenInfo login(String userId, String userPw);

    User join(JoinUserDTO user);

//    int saleToday(SaleTodayDTO data);
//
//    int salesWeek(SaleTodayDTO data);
}
