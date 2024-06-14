package dev.ryuuwiz.reservasi_restoran.dto;

import lombok.Data;

@Data
public class PesananDto {
  private int id;
  private String nama_pesanan;
  private int jumlah;
  private double harga;
}
