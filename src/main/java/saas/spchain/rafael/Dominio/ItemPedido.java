package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}