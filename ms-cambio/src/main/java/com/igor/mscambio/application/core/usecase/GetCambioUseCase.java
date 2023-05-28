package com.igor.mscambio.application.core.usecase;

import com.igor.mscambio.application.core.domain.Cambio;
import com.igor.mscambio.application.ports.in.GetCambioInputPort;
import com.igor.mscambio.application.ports.out.GetCambioOutputPort;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

public class GetCambioUseCase implements GetCambioInputPort {

    private final GetCambioOutputPort findByFromAndToOutputPort;

    public GetCambioUseCase(GetCambioOutputPort findByFromAndToOutputPort) {
        this.findByFromAndToOutputPort = findByFromAndToOutputPort;
    }

    @Override
    public Cambio get(String from, String to, BigDecimal amount) {
        var cambio = findByFromAndToOutputPort.findByFromAndTo(from, to).orElseThrow(() -> new EntityNotFoundException("Cambio not found"));
        final BigDecimal convertedValue = cambio.getConversionFactor().multiply(amount);
        cambio.setConvertedValue(convertedValue);
        return cambio;
    }
}
