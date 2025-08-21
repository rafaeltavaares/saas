package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
}