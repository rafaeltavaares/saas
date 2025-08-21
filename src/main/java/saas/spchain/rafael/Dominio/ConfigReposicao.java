package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;
import saas.spchain.rafael.Dominio.Usuario.Empresa;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
