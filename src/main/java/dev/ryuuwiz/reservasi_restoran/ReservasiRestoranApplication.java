package dev.ryuuwiz.reservasi_restoran;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.format.annotation.DateTimeFormat;

import dev.ryuuwiz.reservasi_restoran.dto.PesananDto;
import dev.ryuuwiz.reservasi_restoran.dto.ReservasiDto;
import dev.ryuuwiz.reservasi_restoran.service.PesananService;
import dev.ryuuwiz.reservasi_restoran.service.ReservasiService;

@SpringBootApplication
public class ReservasiRestoranApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasiRestoranApplication.class, args);
	}

	@Autowired
	ReservasiService reservasiService;

	@Autowired
	PesananService pesananService;

	@Bean
	public CommandLineRunner run() {

		ReservasiDto reservasiSeed1 = new ReservasiDto();
		reservasiSeed1.setNo_meja(1);
		reservasiSeed1.setNama_pelanggan("John Doe");
		reservasiSeed1.setTgl_reservasi(LocalDate.parse("2024-06-21"));
		reservasiSeed1.setJam_reservasi("15:00");

		ReservasiDto reservasiSeed2 = new ReservasiDto();
		reservasiSeed2.setNo_meja(2);
		reservasiSeed2.setNama_pelanggan("Jessica Doe");
		reservasiSeed2.setTgl_reservasi(LocalDate.parse("2024-06-21"));
		reservasiSeed2.setJam_reservasi("17:00");

		PesananDto pesananSeed1 = new PesananDto();
		pesananSeed1.setNama_pesanan("Bakso");
		pesananSeed1.setJumlah(2);
		pesananSeed1.setHarga(20000);

		return (args) -> {
			reservasiService.simpan(reservasiSeed1);
			reservasiService.simpan(reservasiSeed2);
			pesananService.simpan(1, pesananSeed1);
		};
	}

}
