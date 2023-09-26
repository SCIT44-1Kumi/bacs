package net.softsociety.bacs.kiosk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.kiosk.dto.CreateKioskDTO;
import net.softsociety.bacs.kiosk.dto.DeleteKioskDTO;
import net.softsociety.bacs.kiosk.dto.GetKioskDTO;
import net.softsociety.bacs.kiosk.dto.UpdateKioskDTO;
import net.softsociety.bacs.kiosk.entity.Kiosk;
import net.softsociety.bacs.kiosk.service.KioskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("{storeId}/admin/kiosk")
@Slf4j
@RequiredArgsConstructor
public class KioskController {

    private final KioskService kioskService;

    @PostMapping("create")
    public void createKiosk(@PathVariable(name = "storeId") String storeId,
                            @RequestBody @Valid CreateKioskDTO dto
    ) {
        kioskService.createKiosk(storeId, dto);
    }

    @PostMapping("delete")
    public void deleteKiosk(@PathVariable(name = "storeId") String storeId,
                            @RequestBody @Valid DeleteKioskDTO dto
    ) {
        kioskService.deleteKiosk(storeId, dto);
    }

    @PostMapping("update")
    public void updateKiosk(@PathVariable(name = "storeId") String storeId,
                            @RequestBody @Valid UpdateKioskDTO dto
    ) {
        kioskService.updateKiosk(storeId, dto);
    }

    @GetMapping("getKiosk")
    public Kiosk getKiosk(@RequestBody @Valid GetKioskDTO dto) {
        return kioskService.getKiosk(dto);
    }

}
