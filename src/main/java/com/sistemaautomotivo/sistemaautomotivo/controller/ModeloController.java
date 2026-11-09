package com.sistemaautomotivo.sistemaautomotivo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaautomotivo.sistemaautomotivo.model.Modelo;
import com.sistemaautomotivo.sistemaautomotivo.service.ModeloService;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public List<Modelo> listarTodos() {
        return modeloService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable Long id) {
        Modelo modelo = modeloService.buscarPorId(id);

        if (modelo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(modelo);
    }

    @PostMapping
    public Modelo cadastrar(@Valid @RequestBody Modelo modelo) {
        return modeloService.salvar(modelo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        modeloService.excluir(id);
    }
}