package net.softsociety.bacs.dao;


import net.softsociety.bacs.domain.vo.BacsStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface AdminDAO {

    ArrayList<BacsStore> getStoreList();

    int deleteStore(Map<String, String> storeId);

    int blockStore(Map<String, String> userId);

    int rebockStore(Map<String, String> userId);
}
