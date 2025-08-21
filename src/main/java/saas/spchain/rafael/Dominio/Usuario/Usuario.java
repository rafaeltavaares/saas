package saas.spchain.rafael.Dominio.Usuario;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @Column(unique = true, nullable = false)
    String email;

    String senhaHash;     // senha criptografada (BCrypt)

    String papel;         // ADMIN, CLIENTE, DONO_NEGOCIO

    @ManyToMany
    @JoinTable(
            name = "usuario_empresa",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "empresa_id")
    )
    List<Empresa> empresas; // um usuário pode estar em várias empresas
}