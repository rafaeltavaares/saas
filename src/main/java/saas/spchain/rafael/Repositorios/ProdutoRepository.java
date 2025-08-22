package saas.spchain.rafael.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.spchain.rafael.Dominio.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
