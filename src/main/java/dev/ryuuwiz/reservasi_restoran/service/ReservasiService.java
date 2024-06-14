package dev.ryuuwiz.reservasi_restoran.service;

import dev.ryuuwiz.reservasi_restoran.dto.Mapper;
import dev.ryuuwiz.reservasi_restoran.dto.ReservasiDto;
import dev.ryuuwiz.reservasi_restoran.model.Reservasi;
import dev.ryuuwiz.reservasi_restoran.repository.ReservasiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservasiService {

    @Autowired
    ReservasiRepo reservasiRepo;

    public ReservasiDto simpan(ReservasiDto reservasiDto) {
        Reservasi reservasi = Mapper.mapReservasi(reservasiDto);
        return Mapper.mapReservasiDto(reservasiRepo.save(reservasi));
    }

    public List<ReservasiDto> semua() {
        List<Reservasi> semua = reservasiRepo.findAll();
        return semua.stream().map(Mapper::mapReservasiDto).collect(Collectors.toList());
    }

    public ReservasiDto satu(Integer id) {
        Optional<Reservasi> satu = reservasiRepo.findById(id);
        return Mapper.mapReservasiDto(satu.get());
    }

    public ReservasiDto ubah(Integer id, ReservasiDto reservasiDto) {
        Optional<Reservasi> reservasi = reservasiRepo.findById(id);

        Reservasi _reservasi = reservasi.get();
        _reservasi.setNo_meja(reservasiDto.getNo_meja());
        _reservasi.setNama_pelanggan(reservasiDto.getNama_pelanggan());
        _reservasi.setTgl_reservasi(reservasiDto.getTgl_reservasi());
        _reservasi.setJam_reservasi(reservasiDto.getJam_reservasi());
        reservasiRepo.save(_reservasi);

        return Mapper.mapReservasiDto(_reservasi);
    }

    public void hapus(Integer id) {
        reservasiRepo.deleteById(id);
    }
}
