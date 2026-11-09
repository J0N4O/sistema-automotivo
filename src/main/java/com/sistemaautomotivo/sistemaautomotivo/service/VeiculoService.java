
package com.sistemaautomotivo.sistemaautomotivo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemaautomotivo.sistemaautomotivo.model.Veiculo;
import com.sistemaautomotivo.sistemaautomotivo.model.Modelo;
import com.sistemaautomotivo.sistemaautomotivo.model.StatusVeiculo;
import com.sistemaautomotivo.sistemaautomotivo.repository.VeiculoRepository;
import com.sistemaautomotivo.sistemaautomotivo.repository.ModeloRepository;
import java.math.BigDecimal;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ModeloRepository modeloRepository;

    public VeiculoService(
            VeiculoRepository veiculoRepository,
            ModeloRepository modeloRepository) {

        this.veiculoRepository = veiculoRepository;
        this.modeloRepository = modeloRepository;
    }

    public List<Veiculo> listarTodos() {
    return veiculoRepository.findAll();
    }

    public List<Veiculo> filtrar(
        String marca,
        String modelo,
        Integer ano,
        BigDecimal precoMinimo,
        BigDecimal precoMaximo,
        StatusVeiculo status) {

    return veiculoRepository.filtrar(
            marca,
            modelo,
            ano,
            precoMinimo,
            precoMaximo,
            status
    );
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public Veiculo salvar(Veiculo veiculo) {

        Long modeloId = veiculo.getModelo().getId();

        Modelo modelo = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado."));

        veiculo.setModelo(modelo);

        if (veiculo.getStatus() == null) {
            veiculo.setStatus(StatusVeiculo.DISPONIVEL);
        }

        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizar(Long id, Veiculo novosDados) {

        Veiculo veiculo = buscarPorId(id);

        if (veiculo == null) {
            return null;
        }

        Long modeloId = novosDados.getModelo().getId();

        Modelo modelo = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado."));

        veiculo.setPlaca(novosDados.getPlaca());
        veiculo.setModelo(modelo);
        veiculo.setAno(novosDados.getAno());
        veiculo.setCor(novosDados.getCor());
        veiculo.setQuilometragem(novosDados.getQuilometragem());
        veiculo.setPreco(novosDados.getPreco());

        if (novosDados.getStatus() != null) {
            veiculo.setStatus(novosDados.getStatus());
        }

        return veiculoRepository.save(veiculo);
    }

    public void excluir(Long id) {
        veiculoRepository.deleteById(id);
    }
}
