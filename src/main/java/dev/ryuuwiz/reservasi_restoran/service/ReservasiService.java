package dev.ryuuwiz.reservasi_restoran.service;

import dev.ryuuwiz.reservasi_restoran.dto.Mapper;
import dev.ryuuwiz.reservasi_restoran.dto.ReservasiDto;
import dev.ryuuwiz.reservasi_restoran.model.Reservasi;
import dev.ryuuwiz.reservasi_restoran.repository.ReservasiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
