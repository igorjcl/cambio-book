package com.igor.mscambio.adapters.out.repository.mapper;

import com.igor.mscambio.adapters.out.repository.entity.CambioEntity;
import com.igor.mscambio.application.core.domain.Cambio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CambioEntityMapper {

    @Mapping(target = "convertedValue", ignore = true)
    @Mapping(target = "environment", ignore = true)
    Cambio toCambio(CambioEntity cambioEntity);
}
