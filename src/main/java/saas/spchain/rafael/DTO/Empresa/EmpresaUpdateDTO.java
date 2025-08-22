package saas.spchain.rafael.DTO.Empresa;

// DTO de atualização para a entidade Empresa

import jakarta.validation.constraints.Size;

public record EmpresaUpdateDTO (
        @Size(max = 255, message = "O nome fantasia deve ter no máximo 255 caracteres")
        String nomeFantasia,
        // CNPJ não pode ser alterado após a criação, portanto, não está neste DTO
         String telefone,
         String razaoSocial,
         String endereco

){


}