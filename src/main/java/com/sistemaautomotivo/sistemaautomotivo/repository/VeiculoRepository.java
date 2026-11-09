
package com.sistemaautomotivo.sistemaautomotivo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemaautomotivo.sistemaautomotivo.model.Veiculo;
import com.sistemaautomotivo.sistemaautomotivo.model.StatusVeiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("""
        SELECT v FROM Veiculo v
        WHERE (:marca IS NULL OR LOWER(v.modelo.marca.nome) = LOWER(:marca))
        AND (:modelo IS NULL OR LOWER(v.modelo.nome) = LOWER(:modelo))
        AND (:ano IS NULL OR v.ano = :ano)
        AND (:precoMinimo IS NULL OR v.preco >= :precoMinimo)
        AND (:precoMaximo IS NULL OR v.preco <= :precoMaximo)
        AND (:status IS NULL OR v.status = :status)
    """)
    List<Veiculo> filtrar(
        @Param("marca") String marca,
        @Param("modelo") String modelo,
        @Param("ano") Integer ano,
        @Param("precoMinimo") BigDecimal precoMinimo,
        @Param("precoMaximo") BigDecimal precoMaximo,
        @Param("status") StatusVeiculo status
    );
}
