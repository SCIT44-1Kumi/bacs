package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.dto.admin.BlockStoreDTO;
import net.softsociety.bacs.domain.dto.admin.DeleteStoreDTO;
import net.softsociety.bacs.domain.vo.BacsStore;

import java.util.ArrayList;
import java.util.Map;

public interface AdminService {
    ArrayList<BacsStore> getStoreList();

    boolean deleteStore(DeleteStoreDTO storeId);

    boolean blockStore(BlockStoreDTO userId);

    boolean rebockStore(BlockStoreDTO userId);
}
