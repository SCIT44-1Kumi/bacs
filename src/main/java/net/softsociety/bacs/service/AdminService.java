package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.vo.BacsStore;

import java.util.ArrayList;

public interface AdminService {
    ArrayList<BacsStore> getStoreList();
}
