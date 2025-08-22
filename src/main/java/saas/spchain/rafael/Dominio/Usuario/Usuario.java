package saas.spchain.rafael.Dominio.Usuario;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity

@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String sobrenome;
    String telefone1;
    String telefone2;
    String CEP;
    String endereço;
    String complemento;
    String numero;
    String cpf;
    @Column(unique = true, nullable = false)
    String email;

    String senhaHash;

    @ManyToOne // Correção: Muitos usuários -> um papel
    @JoinColumn(name = "papel_id")
    Papel papel;

    @ManyToMany
    @JoinTable(
            name = "usuario_empresa",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "empresa_id")
    )
    List<Empresa> empresas;

    public Usuario(Long id, String nome, String sobrenome, String telefone1, String telefone2, String CEP, String endereço, String complemento, String numero, String cpf, String email, String senhaHash, Papel papel, List<Empresa> empresas) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.CEP = CEP;
        this.endereço = endereço;
        this.complemento = complemento;
        this.numero = numero;
        this.cpf = cpf;
        this.email = email;
        this.senhaHash = senhaHash;
        this.papel = papel;
        this.empresas = empresas;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}