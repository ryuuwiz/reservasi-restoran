package dev.ryuuwiz.reservasi_restoran.dto;

import dev.ryuuwiz.reservasi_restoran.model.Reservasi;

public class Mapper {

    public static ReservasiDto mapReservasiDto(Reservasi reservasi) {
        ReservasiDto reservasiDto = new ReservasiDto();
        reservasiDto.setId(reservasi.getId());
        reservasiDto.setNo_meja(reservasi.getNo_meja());
        reservasiDto.setNama_pelanggan(reservasi.getNama_pelanggan());
        reservasiDto.setTgl_reservasi(reservasi.getTgl_reservasi());
        reservasiDto.setJam_reservasi(reservasi.getJam_reservasi());

        return reservasiDto;
    }

    public static Reservasi mapReservasi(ReservasiDto reservasiDto) {
        Reservasi reservasi = new Reservasi();
        reservasi.setNo_meja(reservasiDto.getNo_meja());
        reservasi.setNama_pelanggan(reservasiDto.getNama_pelanggan());
        reservasi.setTgl_reservasi(reservasiDto.getTgl_reservasi());
        reservasi.setJam_reservasi(reservasiDto.getJam_reservasi());

        return reservasi;
    }
}
