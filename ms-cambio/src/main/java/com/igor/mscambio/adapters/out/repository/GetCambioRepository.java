package com.igor.mscambio.adapters.out.repository;

import com.igor.mscambio.adapters.out.repository.entity.CambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GetCambioRepository extends JpaRepository<CambioEntity, Long> {

    Optional<CambioEntity> findByFromAndTo(final String from, final String to);
}
