package dev.ryuuwiz.reservasi_restoran.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservasiDto {
    private int id;
    private int no_meja;
    private String nama_pelanggan;
    private LocalDate tgl_reservasi;
    private LocalTime jam_reservasi;
}
