package com.igor.mscambio.usecase;

import com.igor.mscambio.application.core.domain.Cambio;
import com.igor.mscambio.application.core.usecase.GetCambioUseCase;
import com.igor.mscambio.application.ports.out.GetCambioOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetCambioUseCaseTest {

    @Mock
    private GetCambioOutputPort findByFromAndToOutputPort;

    @InjectMocks
    private GetCambioUseCase cambioUseCase;

    @Test
    void shouldGetCambioAndReturnSuccess() {
        var cambio = new Cambio(1L, "USD", "BRL", new BigDecimal("5.40"));
        var amount = new BigDecimal("20");
        when(findByFromAndToOutputPort.findByFromAndTo(any(), any())).thenReturn(Optional.of(cambio));

        var response = cambioUseCase.get(cambio.getFrom(), cambio.getTo(), amount);

        assertEquals(cambio.getId(), response.getId());
        assertEquals(cambio.getFrom(), response.getFrom());
        assertEquals(cambio.getTo(), response.getTo());
        assertEquals(cambio.getConversionFactor(), response.getConversionFactor());
        assertEquals(cambio.getConversionFactor().multiply(amount), response.getConvertedValue());
        verify(findByFromAndToOutputPort, times(1)).findByFromAndTo(any(), any());
    }

    @Test
    void shouldErroWhenNotFoundCambio() {
        when(findByFromAndToOutputPort.findByFromAndTo(any(), any())).thenReturn(Optional.empty());

        var response = assertThrows(EntityNotFoundException.class, () -> cambioUseCase.get(null, null, null));

        assertEquals("Cambio not found", response.getMessage());
    }
}
