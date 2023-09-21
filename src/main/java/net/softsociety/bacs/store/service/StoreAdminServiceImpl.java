package net.softsociety.bacs.store.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.store.dao.StoreAdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class StoreAdminServiceImpl implements StoreAdminService {

    @Autowired
    StoreAdminDAO dao;


}
