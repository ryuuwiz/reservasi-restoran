package dev.ryuuwiz.reservasi_restoran.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ryuuwiz.reservasi_restoran.dto.Mapper;
import dev.ryuuwiz.reservasi_restoran.dto.PesananDto;
import dev.ryuuwiz.reservasi_restoran.model.Pesanan;
import dev.ryuuwiz.reservasi_restoran.model.Reservasi;
import dev.ryuuwiz.reservasi_restoran.repository.PesananRepo;
import dev.ryuuwiz.reservasi_restoran.repository.ReservasiRepo;

@Service
public class PesananService {

  @Autowired
  PesananRepo pesananRepo;

  @Autowired
  ReservasiRepo reservasiRepo;

  public PesananDto simpan(Integer id, PesananDto pesananDto) {
    Optional<Reservasi> reservasi = reservasiRepo.findById(id);
    Pesanan pesanan = Mapper.mapPesanan(reservasi.get(), pesananDto);
    return Mapper.mapPesananDto(pesananRepo.save(pesanan));
  }

  public List<PesananDto> semua(Integer id) {
    Optional<Reservasi> reservasi = reservasiRepo.findById(id);
    List<Pesanan> pesananByReservasi = pesananRepo.findByReservasi(reservasi.get());
    return pesananByReservasi.stream().map(Mapper::mapPesananDto).collect(Collectors.toList());
  }

  public void hapus(Integer id) {
    pesananRepo.deleteById(id);
  }

}
