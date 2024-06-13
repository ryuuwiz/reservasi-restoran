package dev.ryuuwiz.reservasi_restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ryuuwiz.reservasi_restoran.model.Pesanan;
import dev.ryuuwiz.reservasi_restoran.model.Reservasi;

import java.util.List;

@Repository
public interface PesananRepo extends JpaRepository<Pesanan, Integer> {
  List<Pesanan> findByReservasi(Reservasi reservasi);
}
