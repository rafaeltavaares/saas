package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
}
