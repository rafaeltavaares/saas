package saas.spchain.rafael.DTO.Usuario;

import saas.spchain.rafael.Dominio.Usuario.Usuario;

import java.util.List;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email
) {
    // Construtor que mapeia a entidade Usuario para este DTO.
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
