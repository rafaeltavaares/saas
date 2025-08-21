package saas.spchain.rafael.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.spchain.rafael.Dominio.Produto;
import saas.spchain.rafael.Dominio.Status.Papel;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
