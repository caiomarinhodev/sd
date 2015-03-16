package models;

import javax.persistence.*;

/**
 * Created by Caio on 08/03/2015.
 */

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String nome;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Usuario(String email, String senha, String nome) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(){

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!email.equals(usuario.email)) return false;
        if (id != null ? !id.equals(usuario.id) : usuario.id != null) return false;
        if (!senha.equals(usuario.senha)) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + senha.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}