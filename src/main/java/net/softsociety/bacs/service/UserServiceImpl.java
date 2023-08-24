package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.UserDAO;
import net.softsociety.bacs.domain.BacsUser;
import net.softsociety.bacs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;


    /**
     * @param newUser
     * @return
     */
    @Override
    public boolean createUser(BacsUser newUser) {
        return dao.createUser(newUser);
    }

    /**
     * @return
     */
    @Override
    public ArrayList<BacsUser> getUserList() {
        return dao.getUserList();
    }
}
