package br.com.senai.agenciaviagem.agenciaviagemapi.repository;

import br.com.senai.agenciaviagem.agenciaviagemapi.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
    @Query("SELECT d FROM Destino d WHERE (:nome IS NULL OR LOWER(d.nome) LIKE LOWER(CONCAT('%',:nome,'%'))) AND (:local IS NULL OR LOWER(d.local) LIKE LOWER(CONCAT('%',:local,'%')))")
    List<Destino> buscar(@Param("nome") String nome, @Param("local") String local);
}
