package saas.spchain.rafael.DTO.Empresa;

import saas.spchain.rafael.DTO.Usuario.UsuarioResponseDTO;
import saas.spchain.rafael.Dominio.Usuario.Empresa;

import java.util.List;
import java.util.stream.Collectors;

public record EmpresaResponseDTO(
        Long id,
        String nomeFantasia,
        String cnpj,
        String telefone,
        String razaoSocial,
        String endereco,
        List<UsuarioResponseDTO> usuarios
) {
    public EmpresaResponseDTO(Empresa dados) {
        this(
                dados.getId(),
                dados.getNomeFantasia(),
                dados.getCnpj(),
                dados.getTelefone(),
                dados.getRazaoSocial(),
                dados.getEndereco(),
                // Correção: Mapeia a lista de entidades Usuario para uma lista de UsuarioResponseDTO
                dados.getUsuarios().stream()
                        .map(UsuarioResponseDTO::new) // Para cada Usuario, cria um novo UsuarioResponseDTO
                        .collect(Collectors.toList())
        );
    }
}
