package br.com.senai.agenciaviagem.agenciaviagemapi.model;

import java.time.LocalDate;

public class Reserva {
    private Long id;
    private Long idDestino;
    private String nomeCliente;
    private int quantidadePessoas;
    private LocalDate dataViagem;

    public Reserva() {
    }

    public Reserva(Long id, Long idDestino, String nomeCliente, int quantidadePessoas, LocalDate dataViagem) {
        this.id = id;
        this.idDestino = idDestino;
        this.nomeCliente = nomeCliente;
        this.quantidadePessoas = quantidadePessoas;
        this.dataViagem = dataViagem;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDestino() {
        return idDestino;
    }
    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public LocalDate getDataViagem() {
        return dataViagem;
    }
    public void setDataViagem(LocalDate dataViagem) {
        this.dataViagem = dataViagem;
    }
}
