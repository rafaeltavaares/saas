package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity

public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    Produto produto; // Muitos vendas -> 1 produto

    Integer quantidade;

    Double valorTotal;

    LocalDateTime data;

    public Venda(Long id, Produto produto, Integer quantidade, Double valorTotal, LocalDateTime data) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}