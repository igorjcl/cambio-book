package com.igor.mscambio.config;

import com.igor.mscambio.adapters.out.GetCambioAdapter;
import com.igor.mscambio.application.core.usecase.GetCambioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetCambioConfig {

    @Bean
    public GetCambioUseCase getCambioUseCase(final GetCambioAdapter cambioAdapter) {
        return new GetCambioUseCase(cambioAdapter);
    }
}
