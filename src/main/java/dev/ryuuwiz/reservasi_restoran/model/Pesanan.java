package dev.ryuuwiz.reservasi_restoran.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Pesanan {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_reservasi", nullable = false)
  private Reservasi reservasi;

  @Column
  @NotNull
  @NotBlank
  private String nama_pesanan;

  @Column
  @NotNull
  private int jumlah;

  @Column
  @NotNull
  private double harga;
}
