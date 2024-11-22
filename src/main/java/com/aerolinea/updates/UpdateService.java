package com.aerolinea.updates;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class UpdateService {

    private final List<UpdateDTO> updates = new CopyOnWriteArrayList<>();

    public void addUpdate(UpdateDTO updateDTO) {
        updates.add(updateDTO);
    }

    public List<UpdateDTO> getAllUpdates() {
        return updates;
    }
}
