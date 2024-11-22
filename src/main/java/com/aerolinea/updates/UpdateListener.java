package com.aerolinea.updates;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class UpdateListener {

    private final UpdateService updateService;

    public UpdateListener(UpdateService updateService) {
        this.updateService = updateService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void onMessageReceived(String message) {
        try {
            log.info("Received update: {}", message);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            UpdateDTO updateDTO = objectMapper.readValue(message, UpdateDTO.class);

            processFlightUpdate(updateDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processFlightUpdate(UpdateDTO updateDTO) {
        log.info("Processing update for flight {}: {}", updateDTO.flightId(), updateDTO.newState());
        updateService.addUpdate(updateDTO);
    }
}
