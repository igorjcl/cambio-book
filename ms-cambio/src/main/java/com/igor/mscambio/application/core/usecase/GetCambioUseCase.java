package com.igor.mscambio.application.core.usecase;

import com.igor.mscambio.application.core.domain.Cambio;
import com.igor.mscambio.application.ports.in.GetCambioInputPort;
import com.igor.mscambio.application.ports.out.GetCambioOutputPort;

import java.math.BigDecimal;

public class GetCambioUseCase implements GetCambioInputPort {

    private final GetCambioOutputPort findByFromAndToOutputPort;

    public GetCambioUseCase(GetCambioOutputPort findByFromAndToOutputPort) {
        this.findByFromAndToOutputPort = findByFromAndToOutputPort;
    }

    @Override
    public Cambio get(String from, String to, BigDecimal amount) {
        var cambio = findByFromAndToOutputPort.findByFromAndTo(from, to).orElseThrow(() -> new RuntimeException("Customer not found"));
        final BigDecimal convertedValue = convertValue(cambio.getConversionFactor(), amount);
        cambio.setConvertedValue(convertedValue);
        return cambio;
    }

    private BigDecimal convertValue(BigDecimal conversionFactor, BigDecimal amount) {
        return conversionFactor.multiply(amount);
    }
}
