package net.softsociety.bacs.dao;


import net.softsociety.bacs.domain.vo.BacsStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AdminDAO {

    ArrayList<BacsStore> getStoreList();
}
