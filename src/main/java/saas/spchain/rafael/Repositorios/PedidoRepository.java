package saas.spchain.rafael.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.spchain.rafael.Dominio.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
