package com.igor.mscambio.application.ports.in;

import com.igor.mscambio.application.core.domain.Cambio;

import java.math.BigDecimal;

public interface GetCambioInputPort {

    Cambio get(final String from, final String to, final BigDecimal amount);
}
