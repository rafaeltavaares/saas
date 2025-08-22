package saas.spchain.rafael.Services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import saas.spchain.rafael.DTO.Empresa.EmpresaCreateDTO;
import saas.spchain.rafael.DTO.Empresa.EmpresaResponseDTO;
import saas.spchain.rafael.DTO.Empresa.EmpresaUpdateDTO;
import saas.spchain.rafael.Dominio.Usuario.Empresa;
import saas.spchain.rafael.Repositorios.EmpresaRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    // Injeção de dependência via construtor (melhor prática)
    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }


    @Transactional
    public EmpresaResponseDTO create(EmpresaCreateDTO createDTO) throws Exception {
        // Regra de Negócio: Validar se o CNPJ já existe
        if (empresaRepository.findByCnpj(createDTO.cnpj()).isPresent()) {
            throw new Exception("O CNPJ informado já está cadastrado.");
        }

        Empresa empresa = new Empresa();
        // Mapeamento do DTO para a Entidade
        empresa.setNomeFantasia(createDTO.nomeFantasia());
        empresa.setRazaoSocial(createDTO.razaoSocial());
        empresa.setCnpj(createDTO.cnpj());
        empresa.setNicho(createDTO.nicho());
        empresa.setQtdFuncionarios(createDTO.qtdFuncionaios());
        empresa.setSetor(createDTO.setor());
        empresa.setAtivo(true); // Regra de Negócio: Toda nova empresa começa como ativa

        Empresa savedEmpresa = empresaRepository.save(empresa);

        return toResponseDTO(savedEmpresa);
    }

    /**
     * Busca todas as empresas ATIVAS.
     *
     * @return Lista de DTOs das empresas ativas.
     */
    @Transactional()
    public List<EmpresaResponseDTO> findAllActive() {
        return empresaRepository.findAllByAtivoTrue().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    @Transactional()
    public EmpresaResponseDTO findById(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Empresa não encontrada com o ID: " + id));
        return toResponseDTO(empresa);
    }

    @Transactional
    public EmpresaResponseDTO update(Long id, EmpresaUpdateDTO updateDTO) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Empresa não encontrada com o ID: " + id));

        // Atualiza apenas os campos fornecidos no DTO
        if (updateDTO.nomeFantasia() != null) {
            empresa.setNomeFantasia(updateDTO.nomeFantasia());
        }
        if (updateDTO.razaoSocial() != null) {
            empresa.setRazaoSocial(updateDTO.razaoSocial());
        }
        // CNPJ geralmente não é alterado, mas se for necessário, a lógica de validação
        // de duplicidade deveria ser adicionada aqui também.

        Empresa updatedEmpresa = empresaRepository.save(empresa);
        return toResponseDTO(updatedEmpresa);
    }


    @Transactional
    public void deleteById(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Empresa não encontrada com o ID: " + id));

        // Regra de Negócio: Soft Delete
        empresa.setAtivo(false);
        empresaRepository.save(empresa);
    }

    // --- MAPPERS PRIVADOS ---


    private EmpresaResponseDTO toResponseDTO(Empresa empresa) {

        return new EmpresaResponseDTO(empresa);
    }
}
