package saas.spchain.rafael.Dominio.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import saas.spchain.rafael.Dominio.Pedido;
import saas.spchain.rafael.Dominio.Produto;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nomeFantasia;

    @Column(unique = true)
    String cnpj;

    String telefone;
    String endereco;

    @ManyToMany(mappedBy = "empresas")
    List<Usuario> usuarios; // uma empresa pode ter vários usuários
}