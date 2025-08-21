package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;
import saas.spchain.rafael.Dominio.Status.Status;

import java.time.LocalDateTime;
import java.util.List;
// Enum para o status do pedido

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
}