package com.igor.msbook.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cambio {

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue;
    private String environment;

}
