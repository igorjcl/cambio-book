package com.igor.mscambio.adapters.in.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CambioResponse {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
}
