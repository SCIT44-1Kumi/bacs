package net.softsociety.bacs.kiosk.controller;

import net.softsociety.bacs.kiosk.dto.CreateKioskDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("{storeId}/admin/kiosk")
public class KioskController {

    @PostMapping("create")
    public void createKiosk(@Valid @RequestBody CreateKioskDTO createKioskdto){

    }
}
