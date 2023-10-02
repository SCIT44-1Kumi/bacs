package net.softsociety.bacs.kiosk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.kiosk.dto.CreateKioskDTO;
import net.softsociety.bacs.kiosk.dto.DeleteKioskDTO;
import net.softsociety.bacs.kiosk.dto.GetKioskDTO;
import net.softsociety.bacs.kiosk.dto.UpdateKioskDTO;
import net.softsociety.bacs.kiosk.entity.Kiosk;
import net.softsociety.bacs.kiosk.entity.KioskRepository;
import net.softsociety.bacs.kiosk.exception.KioskErrorCode;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class KioskServiceImpl implements KioskService {

    private final StoreRepository storeRepository;
    private final KioskRepository kioskRepository;

    @Override
    public void createKiosk(String storeId, CreateKioskDTO dto) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        Kiosk kiosk = Kiosk.builder()
                .storeCode(dto.storeCode())
                .store(store)
                .build();
        kioskRepository.save(kiosk);
        store.addKiosk(kiosk);
    }

    @Override
    public void deleteKiosk(String storeId, DeleteKioskDTO dto) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        Kiosk kiosk = kioskRepository.findById(dto.kioskNo())
                .orElseThrow(KioskErrorCode.KIOSK_NULL::defaultException);

        kioskRepository.delete(kiosk);
        store.removeKiosk(kiosk);
    }

    @Override
    public void updateKiosk(String storeId, UpdateKioskDTO dto) {
        // TODO: 매장번호 검증 기능
        Kiosk kiosk = kioskRepository.findById(dto.kioskNo())
                .orElseThrow(KioskErrorCode.KIOSK_NULL::defaultException);

        kiosk.update(dto.storeCode());
    }

    @Override
    public Kiosk getKiosk(GetKioskDTO dto) {

        return kioskRepository.findById(dto.kioskNo())
                .orElseThrow(KioskErrorCode.KIOSK_NULL::defaultException);

    }

}
