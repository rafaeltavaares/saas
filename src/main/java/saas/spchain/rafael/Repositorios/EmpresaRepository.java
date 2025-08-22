package saas.spchain.rafael.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.spchain.rafael.Dominio.Usuario.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findAllByAtivoTrue();


    Optional<Empresa> findByCnpj(String cnpj);

}
