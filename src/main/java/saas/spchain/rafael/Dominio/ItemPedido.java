package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity

@EqualsAndHashCode
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    Produto produto; // Muitos itens -> 1 produto

    Integer quantidade;

    Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    Pedido pedido; // Muitos itens -> 1 pedido

    public ItemPedido() {
    }

    public ItemPedido(Long id, Produto produto, Integer quantidade, Double precoUnitario, Pedido pedido) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.pedido = pedido;
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

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}