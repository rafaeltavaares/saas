package saas.spchain.rafael.DTO.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UsuarioCreateDTO(
    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres.")
     String nome,

    @NotBlank(message = "O sobrenome não pode ser vazio.")
    @Size(min = 2, max = 100, message = "O sobrenome deve ter entre 2 e 100 caracteres.")
     String sobrenome,

    @NotBlank(message = "O e-mail não pode ser vazio.")
    @Email(message = "Formato de e-mail inválido.")
     String email,

    @NotBlank(message = "A senha não pode ser vazia.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
     String senha,

    @NotBlank(message = "O telefone principal é obrigatório.")
     String telefone1,

    String telefone2, // Opcional

    String CEP,

    String endereço,

    String complemento,

    String numero,

    @NotBlank(message = "O CPF é obrigatório.")
    // Adicionar validação de CPF se necessário (ex: @CPF da biblioteca Hibernate Validator)
     String cpf,

    @NotNull(message = "O ID do papel é obrigatório.")
     Long papelId,

    // Pode ser uma lista vazia se o usuário não estiver associado a nenhuma empresa inicialmente
    List<Long> empresaIds

) {
}
