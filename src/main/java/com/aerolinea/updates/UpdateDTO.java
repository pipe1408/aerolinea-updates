package com.aerolinea.updates;

import java.time.LocalDate;
import java.time.LocalTime;

public record UpdateDTO(
        String flightId,
        String origen,
        String destino,
        LocalDate fecha,
        LocalTime hora,
        EstadoEnum previousState,
        EstadoEnum newState
) {
}
