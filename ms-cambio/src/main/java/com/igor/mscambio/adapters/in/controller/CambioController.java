package com.igor.mscambio.adapters.in.controller;

import com.igor.mscambio.adapters.in.controller.mapper.CambioMapper;
import com.igor.mscambio.adapters.in.controller.response.CambioResponse;
import com.igor.mscambio.application.ports.in.GetCambioInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cambio")
public class CambioController {

    private final GetCambioInputPort getCambioInputPort;
    private final CambioMapper cambioMapper;

    public CambioController(GetCambioInputPort getCambioInputPort, CambioMapper cambioMapper) {
        this.getCambioInputPort = getCambioInputPort;
        this.cambioMapper = cambioMapper;
    }

    @GetMapping("/{amount}/{from}/{to}")
    public ResponseEntity<CambioResponse> getCambio(@PathVariable("amount") BigDecimal amount,
                                                    @PathVariable("from") String from,
                                                    @PathVariable("to") String to) {
        var cambio = getCambioInputPort.get(from, to, amount);
        var cambioResponse = cambioMapper.toCambioResponse(cambio);
        return ResponseEntity.ok().body(cambioResponse);
    }
}