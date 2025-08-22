package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;
import saas.spchain.rafael.Dominio.Status.Status;

import java.time.LocalDateTime;
import java.util.List;
// Enum para o status do pedido

@Entity

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    Fornecedor fornecedor; // Muitos pedidos -> 1 fornecedor

    LocalDateTime data;

    @Enumerated(EnumType.STRING)
    Status status;

    Double valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ItemPedido> itens; // 1 pedido -> muitos itens

    public Pedido() {
    }

    public Pedido(Long id, Fornecedor fornecedor, LocalDateTime data, Status status, Double valorTotal, List<ItemPedido> itens) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.data = data;
        this.status = status;
        this.valorTotal = valorTotal;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}