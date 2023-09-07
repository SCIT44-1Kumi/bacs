package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.StoreAdminDAO;
import net.softsociety.bacs.domain.vo.BacsHomepage;
import net.softsociety.bacs.domain.vo.BacsStore;
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
