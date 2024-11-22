package com.aerolinea.updates;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UpdateController {

    private final UpdateService updateService;

    public UpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @GetMapping("/updates")
    public List<UpdateDTO> getAllUpdates() {
        return updateService.getAllUpdates();
    }
}
