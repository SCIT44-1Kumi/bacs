package net.softsociety.bacs.kiosk.service;

import net.softsociety.bacs.kiosk.dto.CreateKioskDTO;
import net.softsociety.bacs.kiosk.dto.DeleteKioskDTO;
import net.softsociety.bacs.kiosk.dto.GetKioskDTO;
import net.softsociety.bacs.kiosk.dto.UpdateKioskDTO;
import net.softsociety.bacs.kiosk.entity.Kiosk;

public interface KioskService {

    void createKiosk(String storeId, CreateKioskDTO dto);

    void deleteKiosk(String storeId, DeleteKioskDTO dto);

    void updateKiosk(String storeId, UpdateKioskDTO dto);

    Kiosk getKiosk(GetKioskDTO dto);
}
