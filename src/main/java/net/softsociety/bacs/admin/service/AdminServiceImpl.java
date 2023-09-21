package net.softsociety.bacs.admin.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.admin.dao.AdminDAO;
import net.softsociety.bacs.domain.dto.admin.BlockStoreDTO;
import net.softsociety.bacs.domain.dto.admin.DeleteStoreDTO;
import net.softsociety.bacs.domain.vo.BacsStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
    public boolean deleteStore(DeleteStoreDTO storeId) {
        int n = dao.deleteStore(storeId);
        return n != 0;
    }

    @Override
    public boolean blockStore(BlockStoreDTO userId) {
        int n = dao.blockStore(userId);
        return n != 0;
    }

    @Override
    public boolean rebockStore(BlockStoreDTO userId) {
        int n = dao.rebockStore(userId);
        return n != 0;

    }
}
