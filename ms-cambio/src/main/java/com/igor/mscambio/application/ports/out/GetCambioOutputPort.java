package com.igor.mscambio.application.ports.out;

import com.igor.mscambio.application.core.domain.Cambio;

import java.util.Optional;

public interface GetCambioOutputPort {

    Optional<Cambio> findByFromAndTo(final String from, final String to);
}
