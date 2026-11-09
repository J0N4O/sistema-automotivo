package com.sistemaautomotivo.sistemaautomotivo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemaautomotivo.sistemaautomotivo.model.Modelo;
import com.sistemaautomotivo.sistemaautomotivo.repository.ModeloRepository;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public List<Modelo> listarTodos() {
        return modeloRepository.findAll();
    }

    public Modelo buscarPorId(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public Modelo salvar(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public void excluir(Long id) {
        modeloRepository.deleteById(id);
    }
}