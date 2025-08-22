package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    String categoria;
    Integer estoqueAtual;
    Double precoCompra;
    Double precoVenda;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    Fornecedor fornecedor;   // muitos produtos -> 1 fornecedor
    @OneToOne(mappedBy = "produto")
    ConfigReposicao configReposicao; // 1-para-1

    public Produto() {
    }

    public ConfigReposicao getConfigReposicao() {
        return configReposicao;
    }

    public void setConfigReposicao(ConfigReposicao configReposicao) {
        this.configReposicao = configReposicao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Integer getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(Integer estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto(Long id, String nome, String categoria, Integer estoqueAtual, Double precoCompra, Double precoVenda, Fornecedor fornecedor, ConfigReposicao configReposicao) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.estoqueAtual = estoqueAtual;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.fornecedor = fornecedor;
        this.configReposicao = configReposicao;
    }
}
