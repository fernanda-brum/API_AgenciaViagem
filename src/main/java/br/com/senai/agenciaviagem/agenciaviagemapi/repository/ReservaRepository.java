package br.com.senai.agenciaviagem.agenciaviagemapi.repository;

import br.com.senai.agenciaviagem.agenciaviagemapi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByDestino_Id(Long destinoId);
}
