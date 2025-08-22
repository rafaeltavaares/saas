package saas.spchain.rafael.Dominio.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import saas.spchain.rafael.Dominio.Status.TamanhoEmpresa;

import java.util.List;


@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nomeFantasia;

    @Column(unique = true)
    String cnpj;

    String telefone;
    String endereco;

    @ManyToMany(mappedBy = "empresas")
    List<Usuario> usuarios; // uma empresa pode ter vários usuários

    String nicho;

    String setor;

    TamanhoEmpresa qtdFuncionarios;

    Boolean ativo;

    String razaoSocial;

    public Empresa() {
    }

    public Empresa(Long id, String nomeFantasia, String cnpj, String telefone, String endereco, List<Usuario> usuarios, String nicho, String setor, TamanhoEmpresa qtdFuncionarios, Boolean ativo, String razaoSocial) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.usuarios = usuarios;
        this.nicho = nicho;
        this.setor = setor;
        this.qtdFuncionarios = qtdFuncionarios;
        this.ativo = ativo;
        this.razaoSocial = razaoSocial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNicho() {
        return nicho;
    }

    public void setNicho(String nicho) {
        this.nicho = nicho;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public TamanhoEmpresa getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(TamanhoEmpresa qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}