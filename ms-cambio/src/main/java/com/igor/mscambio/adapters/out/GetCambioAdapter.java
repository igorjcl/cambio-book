package com.igor.mscambio.adapters.out;

import com.igor.mscambio.adapters.out.repository.GetCambioRepository;
import com.igor.mscambio.application.core.domain.Cambio;
import com.igor.mscambio.application.ports.out.GetCambioOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCambioAdapter implements GetCambioOutputPort {

    private final GetCambioRepository getCambioRepository;

    public GetCambioAdapter(GetCambioRepository getCambioRepository) {
        this.getCambioRepository = getCambioRepository;
    }

    @Override
    public Optional<Cambio> findByFromAndTo(String from, String to) {
        final var cambio = getCambioRepository.findByFromAndTo(from, to);
        return cambio.map(c -> new Cambio(c.getId(), c.getFrom(), c.getTo(), c.getConversionFactor()));
    }
}
