package dev.ryuuwiz.reservasi_restoran.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Reservasi {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column
    private int no_meja;

    @NotBlank
    @NotNull
    @Column
    private String nama_pelanggan;

    @NotNull
    @Column
    private LocalDate tgl_reservasi;

    @NotNull
    @Column
    private String jam_reservasi;

    @OneToMany(mappedBy = "reservasi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pesanan> pesanan = new ArrayList<>();
}
