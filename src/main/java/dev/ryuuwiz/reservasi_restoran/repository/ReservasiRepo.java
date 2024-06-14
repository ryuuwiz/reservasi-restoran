package dev.ryuuwiz.reservasi_restoran.repository;

import dev.ryuuwiz.reservasi_restoran.model.Reservasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasiRepo extends JpaRepository<Reservasi, Integer> {
}
