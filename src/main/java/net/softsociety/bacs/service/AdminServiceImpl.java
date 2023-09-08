package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.AdminDAO;
import net.softsociety.bacs.domain.vo.BacsStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO dao;

    @Override
    public ArrayList<BacsStore> getStoreList() {
        return dao.getStoreList();
    }

    @Override
    public boolean deleteStore(Map<String, String> storeId) {
        int n = dao.deleteStore(storeId);
        return n != 0;
    }

    @Override
    public boolean blockStore(Map<String, String> userId) {
        int n = dao.blockStore(userId);
        return n != 0;
    }
}
