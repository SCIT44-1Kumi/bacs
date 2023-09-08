package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.vo.BacsStore;

import java.util.ArrayList;
import java.util.Map;

public interface AdminService {
    ArrayList<BacsStore> getStoreList();

    boolean deleteStore(Map<String, String> storeId);

    boolean blockStore(Map<String, String> userId);
}
