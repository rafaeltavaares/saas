package saas.spchain.rafael.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.spchain.rafael.Dominio.Status.Papel;
import saas.spchain.rafael.Dominio.Usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
