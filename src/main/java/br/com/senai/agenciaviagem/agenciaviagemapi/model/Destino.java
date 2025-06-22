package br.com.senai.agenciaviagem.agenciaviagemapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "destino")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String local;
    private String descricao;
    private double avaliacaoMedia;
    private int quantidadeAvaliacoes;

    public Destino() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void adicionarAvaliacao(int nota) {
        double total = this.avaliacaoMedia * this.quantidadeAvaliacoes;
        this.quantidadeAvaliacoes++;
        total += nota;
        this.avaliacaoMedia = total / this.quantidadeAvaliacoes;
    }
}
