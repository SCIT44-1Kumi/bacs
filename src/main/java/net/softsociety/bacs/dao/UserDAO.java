package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.vo.BacsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserDAO {
//    public boolean createUser(BacsUser newUser);

    ArrayList<BacsUser> getUserList();
}
