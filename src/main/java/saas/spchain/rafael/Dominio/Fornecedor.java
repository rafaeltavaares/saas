package saas.spchain.rafael.Dominio;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
