package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO dao;
    /**
     * @return
     */
    @Override
    public String getStoreInfo() {
        String ex = dao.getStoreInfo();
        return null;
    }
}
