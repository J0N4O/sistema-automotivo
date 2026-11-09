
package com.sistemaautomotivo.sistemaautomotivo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaautomotivo.sistemaautomotivo.model.Veiculo;
import com.sistemaautomotivo.sistemaautomotivo.service.VeiculoService;

import java.math.BigDecimal;
import com.sistemaautomotivo.sistemaautomotivo.model.StatusVeiculo;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }

    @GetMapping("/filtro")
    public List<Veiculo> filtrar(
        @RequestParam(required = false) String marca,
        @RequestParam(required = false) String modelo,
        @RequestParam(required = false) Integer ano,
        @RequestParam(required = false) BigDecimal precoMinimo,
        @RequestParam(required = false) BigDecimal precoMaximo,
        @RequestParam(required = false) StatusVeiculo status) {

    return veiculoService.filtrar(
            marca,
            modelo,
            ano,
            precoMinimo,
            precoMaximo,
            status
    );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
    Veiculo veiculo = veiculoService.buscarPorId(id);

    if (veiculo == null) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public Veiculo cadastrar(@Valid @RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Veiculo veiculo) {

        Veiculo atualizado = veiculoService.atualizar(id, veiculo);

        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atualizado);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
    Veiculo veiculo = veiculoService.buscarPorId(id);

    if (veiculo == null) {
        return ResponseEntity.notFound().build();
    }

    veiculoService.excluir(id);
    return ResponseEntity.noContent().build();
    }
}
