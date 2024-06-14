package dev.ryuuwiz.reservasi_restoran.dto;

import dev.ryuuwiz.reservasi_restoran.model.Pesanan;
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

    public static PesananDto mapPesananDto(Pesanan pesanan) {
        PesananDto pesananDto = new PesananDto();
        pesananDto.setId(pesanan.getId());
        pesananDto.setNama_pesanan(pesanan.getNama_pesanan());
        pesananDto.setJumlah(pesanan.getJumlah());
        pesananDto.setHarga(pesanan.getHarga());

        return pesananDto;
    }

    public static Reservasi mapReservasi(ReservasiDto reservasiDto) {
        Reservasi reservasi = new Reservasi();
        reservasi.setNo_meja(reservasiDto.getNo_meja());
        reservasi.setNama_pelanggan(reservasiDto.getNama_pelanggan());
        reservasi.setTgl_reservasi(reservasiDto.getTgl_reservasi());
        reservasi.setJam_reservasi(reservasiDto.getJam_reservasi());

        return reservasi;
    }

    public static Pesanan mapPesanan(Reservasi reservasi, PesananDto pesanandDto) {
        Pesanan pesanan = new Pesanan();
        pesanan.setReservasi(reservasi);
        pesanan.setNama_pesanan(pesanandDto.getNama_pesanan());
        pesanan.setJumlah(pesanandDto.getJumlah());
        pesanan.setHarga(pesanandDto.getHarga());

        return pesanan;
    }
}
