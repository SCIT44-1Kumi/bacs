package net.softsociety.bacs.admin.dao;


import net.softsociety.bacs.domain.dto.admin.BlockStoreDTO;
import net.softsociety.bacs.domain.dto.admin.DeleteStoreDTO;
import net.softsociety.bacs.domain.vo.BacsStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface AdminDAO {

    ArrayList<BacsStore> getStoreList();

    int deleteStore(DeleteStoreDTO storeId);

    int blockStore(BlockStoreDTO userId);

    int rebockStore(BlockStoreDTO userId);
}
