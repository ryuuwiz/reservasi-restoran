package dev.ryuuwiz.reservasi_restoran.controller;

import java.util.Map;

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
  public String pesananView(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("reservasi", reservasiService.satu(id));
    model.addAttribute("allPesanan", pesananService.semua(id));
    return "pesanan";
  }

  @GetMapping("/reservasi/{id}/pesanan/simpan")
  public String simpanPesananView(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("reservasi", reservasiService.satu(id));
    return "tambah-pesanan";
  }

  @GetMapping("/reservasi/{id}/pesanan/ubah/{id_pesanan}")
  public String ubahPesananView(@PathVariable Map<String, String> pvMap, Model model) {
    model.addAttribute("reservasi", reservasiService.satu(Integer.valueOf(pvMap.get("id"))));
    model.addAttribute("pesanan", pesananService.satu(Integer.valueOf(pvMap.get("id_pesanan"))));
    return "ubah-pesanan";
  }

  @PostMapping("/reservasi/{id}/pesanan/simpan")
  public String simpan(@PathVariable("id") Integer id, @Valid PesananDto pesananDto, BindingResult result) {
    if (result.hasErrors()) {
      return "tambah-pesanan";
    }
    pesananService.simpan(id, pesananDto);
    return "redirect:/reservasi/{id}/pesanan";
  }

  @PostMapping("/reservasi/{id}/pesanan/ubah/{id_pesanan}")
  public String ubah(@PathVariable Map<String, String> pvMap, @Valid PesananDto pesananDto, BindingResult result) {
    if (result.hasErrors()) {
      return "ubah-pesanan";
    }
    pesananService.ubah(Integer.valueOf(pvMap.get("id_pesanan")), pesananDto);
    return "redirect:/reservasi/{id}/pesanan";
  }

  @GetMapping("/reservasi/{id}/pesanan/{id_pesanan}")
  public String hapus(@PathVariable Map<String, String> pvMap) {
    Integer id_pesanan = Integer.valueOf(pvMap.get("id_pesanan"));
    pesananService.hapus(id_pesanan);
    return "redirect:/reservasi/{id}/pesanan";
  }
}
