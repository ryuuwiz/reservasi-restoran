package dev.ryuuwiz.reservasi_restoran.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservasiDto {
    private int id;
    private int no_meja;
    private String nama_pelanggan;
    private LocalDate tgl_reservasi;
    private String jam_reservasi;
}
