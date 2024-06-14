package dev.ryuuwiz.reservasi_restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ryuuwiz.reservasi_restoran.dto.ReservasiDto;
import dev.ryuuwiz.reservasi_restoran.service.ReservasiService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ReservasiController {

  @Autowired
  ReservasiService reservasiService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("allReservasi", reservasiService.semua());
    return "index";
  }

  @GetMapping("/reservasi/simpan")
  public String tambahView() {
    return "tambah-reservasi";
  }

  @PostMapping("/reservasi/simpan")
  public String simpan(@Valid ReservasiDto reservasiDto, BindingResult result) {
    if (result.hasErrors()) {
      return "tambah-reservasi";
    }
    reservasiService.simpan(reservasiDto);
    return "redirect:/";
  }

  @GetMapping("/reservasi/ubah/{id}")
  public String ubahView(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("reservasi", reservasiService.satu(id));
    return "ubah-reservasi";
  }

  @PostMapping("/reservasi/ubah/{id}")
  public String ubah(@PathVariable("id") Integer id, @Valid ReservasiDto reservasiDto, BindingResult result) {
    if (result.hasErrors()) {
      return "ubah-reservasi";
    }
    reservasiService.ubah(id, reservasiDto);
    return "redirect:/";
  }

  @GetMapping("/reservasi/hapus/{id}")
  public String hapus(@PathVariable("id") Integer id) {
    reservasiService.hapus(id);
    return "redirect:/";
  }
}
