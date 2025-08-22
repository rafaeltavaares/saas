package saas.spchain.rafael.DTO.Empresa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import saas.spchain.rafael.Dominio.Status.TamanhoEmpresa;

public record EmpresaCreateDTO(
        @NotBlank(message = "O nome fantasia é obrigatório")
        @Size(max = 255, message = "O nome fantasia deve ter no máximo 255 caracteres")
        String nomeFantasia,

        @NotBlank(message = "O CNPJ é obrigatório")
        @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter exatamente 14 dígitos")
         String cnpj,

         String telefone,

         String endereco,

         String nicho,

         String setor,

         TamanhoEmpresa qtdFuncionaios,

         String razaoSocial
) {
}
