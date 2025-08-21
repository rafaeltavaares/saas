package saas.spchain.rafael.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.spchain.rafael.Dominio.Status.Papel;
import saas.spchain.rafael.Dominio.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
