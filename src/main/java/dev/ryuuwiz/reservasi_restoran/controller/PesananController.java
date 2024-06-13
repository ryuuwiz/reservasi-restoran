package dev.ryuuwiz.reservasi_restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.ryuuwiz.reservasi_restoran.dto.PesananDto;
import dev.ryuuwiz.reservasi_restoran.service.PesananService;
import dev.ryuuwiz.reservasi_restoran.service.ReservasiService;
import jakarta.validation.Valid;

@Controller
public class PesananController {

  @Autowired
  ReservasiService reservasiService;

  @Autowired
  PesananService pesananService;

  @GetMapping("/reservasi/{id}/pesanan")
  public String PesananView(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("reservasi", reservasiService.satu(id));
    model.addAttribute("allPesanan", pesananService.semua(id));
    return "pesanan";
  }

  @PostMapping("/reservasi/{id}/pesanan")
  public String simpan(@PathVariable("id") Integer id, @Valid PesananDto pesananDto, BindingResult result) {
    String path = "redirect:/" + "/reservasi/" + id + "/pesanan";

    if (result.hasErrors()) {
      return "tambah-pesanan";
    }
    pesananService.simpan(id, pesananDto);
    return path;
  }
}
