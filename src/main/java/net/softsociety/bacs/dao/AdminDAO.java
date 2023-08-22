package net.softsociety.bacs.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDAO {
    public String getStoreInfo();
}
