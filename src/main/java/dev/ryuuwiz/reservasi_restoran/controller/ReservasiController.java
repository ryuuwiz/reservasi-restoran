package dev.ryuuwiz.reservasi_restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ryuuwiz.reservasi_restoran.service.ReservasiService;

@Controller
@RequestMapping("/")
public class ReservasiController {

  @Autowired
  ReservasiService reservasiService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("semuaMeja", reservasiService.semua());
    return "index";
  }

  @GetMapping("/meja/simpan")
  public String tambahView() {
    return "tambah-meja";
  }

}
