package saas.spchain.rafael.Dominio.Usuario;

import jakarta.persistence.*;
import lombok.*;
import saas.spchain.rafael.Dominio.Status.PapelUsuario;

import java.util.List;

@Entity

@EqualsAndHashCode
public class Papel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true) // O nome do papel deve ser único
    PapelUsuario nome;

    @OneToMany(mappedBy = "papel") // Correção: Mapeado pelo campo 'papel' em Usuario
    List<Usuario> usuarios;

    public Papel(Long id, PapelUsuario nome, List<Usuario> usuarios) {
        this.id = id;
        this.nome = nome;
        this.usuarios = usuarios;
    }

    public Papel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PapelUsuario getNome() {
        return nome;
    }

    public void setNome(PapelUsuario nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}