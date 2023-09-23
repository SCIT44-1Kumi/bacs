package net.softsociety.bacs.store.service;

import net.softsociety.bacs.domain.vo.BacsStore;
import net.softsociety.bacs.store.dto.CreateStoreDTO;
import net.softsociety.bacs.store.entity.Store;

import java.util.Optional;

public interface StoreService {
    Store createStore(CreateStoreDTO createStoreDTO);
}
