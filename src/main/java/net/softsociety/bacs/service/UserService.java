package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.domain.dto.SaleTodayDTO;
import net.softsociety.bacs.domain.vo.BacsUser;

import java.util.ArrayList;

public interface UserService {
//    public boolean createUser(BacsUser newUser);

    ArrayList<BacsUser> getUserList();

    int login(BacsUser user);

    int join(BacsUser user);

    int saleToday(SaleTodayDTO data);

    int salesWeek(SaleTodayDTO data);
}
