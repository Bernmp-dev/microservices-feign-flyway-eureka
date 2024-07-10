package com.bernmpdev.cambioservice.repository;

import com.bernmpdev.cambioservice.model.CambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CambioRepository extends JpaRepository<CambioEntity, Long> {

    Optional<CambioEntity> findByFromAndTo(String from, String to);

}
