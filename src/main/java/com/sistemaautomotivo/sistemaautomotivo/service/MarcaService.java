package com.sistemaautomotivo.sistemaautomotivo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemaautomotivo.sistemaautomotivo.model.Marca;
import com.sistemaautomotivo.sistemaautomotivo.repository.MarcaRepository;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> listarTodas() {
        return marcaRepository.findAll();
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca salvar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void excluir(Long id) {
        marcaRepository.deleteById(id);
    }
}