package br.com.senai.agenciaviagem.agenciaviagemapi.service;

import br.com.senai.agenciaviagem.agenciaviagemapi.model.Destino;
import br.com.senai.agenciaviagem.agenciaviagemapi.model.Reserva;
import br.com.senai.agenciaviagem.agenciaviagemapi.repository.DestinoRepository;
import br.com.senai.agenciaviagem.agenciaviagemapi.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final DestinoRepository destinoRepository;

    public ReservaService(ReservaRepository reservaRepository, DestinoRepository destinoRepository) {
        this.reservaRepository = reservaRepository;
        this.destinoRepository = destinoRepository;
    }

    public Reserva salvar(Long idDestino, Reserva reserva) {
        Destino destino = destinoRepository.findById(idDestino).orElseThrow();
        reserva.setDestino(destino);
        return reservaRepository.save(reserva);
    }

    public List<Reserva> buscarDestinoId(Long idDestino) {
        return reservaRepository.findByDestino_Id(idDestino);
    }

    public boolean excluirId(Long idReserva) {
        if (reservaRepository.existsById(idReserva)) {
            reservaRepository.deleteById(idReserva);
            return true;
        }
        return false;
    }
}
