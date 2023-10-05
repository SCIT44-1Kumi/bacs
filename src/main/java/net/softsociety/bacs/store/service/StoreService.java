package net.softsociety.bacs.store.service;

import net.softsociety.bacs.store.dto.request.CreateStoreDTO;
import net.softsociety.bacs.store.dto.request.GetStoreDTO;
import net.softsociety.bacs.store.dto.response.StoreResponseDTO;

public interface StoreService {
    void createStore(CreateStoreDTO createStoreDTO);

    StoreResponseDTO getStore(String storeId);
}
