package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.BacsUser;

import java.util.ArrayList;

public interface UserService {
//    public boolean createUser(BacsUser newUser);

    ArrayList<BacsUser> getUserList();
}
