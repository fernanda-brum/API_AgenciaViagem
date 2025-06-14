package br.com.senai.agenciaviagem.agenciaviagemapi.service;

import br.com.senai.agenciaviagem.agenciaviagemapi.model.Destino;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class DestinoService {
    private final Map<Long, Destino> destinos = new HashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public List<Destino> listarTodos() {
        return new ArrayList<>(destinos.values());
    }

    public Destino salvar(Destino destino) {
        Long id = proximoId.getAndIncrement();
        destino.setId(id);
        destinos.put(id, destino);
        return destino;
    }

    public Optional<Destino> buscaId(Long id) {
        return Optional.ofNullable(destinos.get(id));
    }

    public List<Destino> buscar(String nome, String local) {
        return destinos.values().stream()
                .filter(d ->
                        (nome == null || d.getNome().toLowerCase().contains(nome.toLowerCase())) &&
                                (local == null || d.getLocal().toLowerCase().contains(local.toLowerCase()))
                )
                .collect(Collectors.toList());
    }

    public void adicionarAvaliacao(Long id, int nota) {
        Destino dest = destinos.get(id);
        if (dest != null) {
            dest.adicionarAvaliacao(nota);
        }
    }

    public boolean excluir(Long id) {
        return destinos.remove(id) != null;
    }
}