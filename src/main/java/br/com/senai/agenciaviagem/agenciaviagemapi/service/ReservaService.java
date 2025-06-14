package br.com.senai.agenciaviagem.agenciaviagemapi.service;

import br.com.senai.agenciaviagem.agenciaviagemapi.model.Reserva;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    private final Map<Long, Reserva> reservas = new HashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public Reserva salvar(Long idDestino, Reserva reserva) {
        Long id = proximoId.getAndIncrement();
        reserva.setId(id);
        reserva.setIdDestino(idDestino);
        reservas.put(id, reserva);
        return reserva;
    }

    public List<Reserva> buscarDestinoId(Long idDestino) {
        return reservas.values().stream()
                .filter(r -> r.getIdDestino().equals(idDestino))
                .collect(Collectors.toList());
    }

    public boolean excluirId(Long idReserva) {
        return reservas.remove(idReserva) != null;
    }
}
