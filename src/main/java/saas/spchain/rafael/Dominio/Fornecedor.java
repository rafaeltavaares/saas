package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity

@EqualsAndHashCode
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String contato;
    String tipoIntegracao; // API, EMAIL, WHATSAPP
    @OneToMany(mappedBy = "fornecedor")
    List<Produto> produtos; // 1 fornecedor -> muitos produtos

    public Fornecedor(Long id, String nome, String contato, String tipoIntegracao, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.tipoIntegracao = tipoIntegracao;
        this.produtos = produtos;
    }

    public Fornecedor() {
    }

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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTipoIntegracao() {
        return tipoIntegracao;
    }

    public void setTipoIntegracao(String tipoIntegracao) {
        this.tipoIntegracao = tipoIntegracao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
