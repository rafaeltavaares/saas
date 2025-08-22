package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;
import saas.spchain.rafael.Dominio.Usuario.Empresa;

@Entity

@EqualsAndHashCode
public class ConfigReposicao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    Empresa empresa_id;
    @OneToOne
    @JoinColumn(name="produto_id")
    Produto produto;        // 1-para-1
    Integer estoqueMinimo;
    Integer estoqueMaximo;
    Boolean modoAutomatico; // se true, gera pedido automático

    public ConfigReposicao(Long id, Empresa empresa_id, Produto produto, Integer estoqueMinimo, Integer estoqueMaximo, Boolean modoAutomatico) {
        this.id = id;
        this.empresa_id = empresa_id;
        this.produto = produto;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.modoAutomatico = modoAutomatico;
    }

    public ConfigReposicao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Empresa empresa_id) {
        this.empresa_id = empresa_id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Integer getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(Integer estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public Boolean getModoAutomatico() {
        return modoAutomatico;
    }

    public void setModoAutomatico(Boolean modoAutomatico) {
        this.modoAutomatico = modoAutomatico;
    }
}
