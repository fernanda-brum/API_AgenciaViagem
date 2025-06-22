package br.com.senai.agenciaviagem.agenciaviagemapi.service;

import br.com.senai.agenciaviagem.agenciaviagemapi.model.Destino;
import br.com.senai.agenciaviagem.agenciaviagemapi.repository.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinoService {
    private final DestinoRepository destinoRepository;

    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public List<Destino> listarTodos() {
        return destinoRepository.findAll();
    }

    public Destino salvar(Destino destino) {
        return destinoRepository.save(destino);
    }

    public Optional<Destino> buscaId(Long id) {
        return destinoRepository.findById(id);
    }

    public List<Destino> buscar(String nome, String local) {
        return destinoRepository.buscar(nome, local);
    }

    public void adicionarAvaliacao(Long id, int nota) {
        destinoRepository.findById(id).ifPresent(d -> {
            d.adicionarAvaliacao(nota);
            destinoRepository.save(d);
        });
    }

    public boolean excluir(Long id) {
        if (destinoRepository.existsById(id)) {
            destinoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
