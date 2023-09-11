package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.dto.SaleTodayDTO;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.domain.dto.SaleTodayDTO;
import net.softsociety.bacs.domain.vo.BacsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Optional;

@Mapper
public interface UserDAO {

    // MyBatis 3.5+
    Optional<BacsUser> getUser(String userId); // TODO implement Optional<BacsUser> getUser(String userId)

    ArrayList<BacsUser> getUserList();

    int login(BacsUser user);

    int join(BacsUser user);

    int saleToday(SaleTodayDTO data);

    int salesWeek(SaleTodayDTO data);

}
