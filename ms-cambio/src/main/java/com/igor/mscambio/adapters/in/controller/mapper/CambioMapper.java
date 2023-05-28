package com.igor.mscambio.adapters.in.controller.mapper;


import com.igor.mscambio.adapters.in.controller.response.CambioResponse;
import com.igor.mscambio.application.core.domain.Cambio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CambioMapper {

    CambioResponse toCambioResponse(final Cambio cambio);
}
