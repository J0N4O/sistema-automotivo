package com.sistemaautomotivo.sistemaautomotivo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaautomotivo.sistemaautomotivo.model.Marca;
import com.sistemaautomotivo.sistemaautomotivo.service.MarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> listarTodas() {
        return marcaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Long id) {
        Marca marca = marcaService.buscarPorId(id);

        if (marca == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public Marca cadastrar(@Valid @RequestBody Marca marca) {
        return marcaService.salvar(marca);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        marcaService.excluir(id);
    }
}