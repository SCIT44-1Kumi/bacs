package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.UserDAO;
import net.softsociety.bacs.domain.vo.BacsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;

    /**
     * 회원 데이터 가져오기 (임시)
     * @return list
     */
    @Override
    public ArrayList<BacsUser> getUserList() {
        return dao.getUserList();
    }
}
