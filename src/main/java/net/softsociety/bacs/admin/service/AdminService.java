package net.softsociety.bacs.admin.service;

import net.softsociety.bacs.admin.dto.BlockStoreDTO;
import net.softsociety.bacs.admin.dto.DeleteStoreDTO;
import net.softsociety.bacs.store.entity.Store;

import java.util.List;

public interface AdminService {
    List<Store> getStoreList();

    void deleteStore(DeleteStoreDTO storeId);

    void blockStore(BlockStoreDTO dto);

    void rebockStore(BlockStoreDTO dto);
}
